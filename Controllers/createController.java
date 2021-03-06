package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import usecase.CreateAccountCase;

import java.io.IOException;

public class createController {
    public Button createButton;
    @FXML
    Button backButton,exitButton;
    @FXML
    public Label emptyfieldWarning;
    @FXML
    public Label duplicateIDWarning;
    @FXML
    TextField userID, passwordField, nameField, phoneField,creditField, accountType;
    @FXML
    TextArea addressField;
    String vide = "";
    String password, name, address, phone,  CC,  ID, accType;
    String duplicateCheck = "";
    public void backbutton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/Welcome.fxml"));
        Stage backStage = (Stage) backButton.getScene().getWindow();
        backStage.setScene(new Scene(root));
    }
    public void exitbutton(){
        System.exit(0);
    }

    public void createbutton(ActionEvent actionEvent) {
        CreateAccountCase createaccount = new CreateAccountCase();
        ID = userID.getText(); password = passwordField.getText();name = nameField.getText();
        phone = phoneField.getText(); CC = creditField.getText(); accType = accountType.getText();
        address = addressField.getText();
        if(password == vide||name==vide||address == vide||phone == vide||CC == vide||ID == vide|| accType == vide){
            emptyfieldWarning.setText("Fill out all fields to create account");
        }
        else{
            duplicateCheck =createaccount.accountCreate(password, name, address,phone, CC,  ID, accType);
            if(duplicateCheck == "duplicate"){
                duplicateIDWarning.setText("Account ID already exists. Enter another ID");

            }
            else {
                duplicateIDWarning.setText("Account Successfully Created");
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../resources/itemOrder.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage createStage = (Stage) createButton.getScene().getWindow();
                
                createStage.setScene(new Scene(root));
            }
        }


    }
}
