package usecase;

import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.util.Scanner;

public class LogInCase {
    public String ID, password, Name, Address, Phone, CCNumber, Type;
    public String[] log(String user, String pass){
        String[] userType= {"",""};
        String ReturnBoolean = "false";
        File accountsFile = new File("TextFiles/accounts.txt");
        File cUserFile = new File("TextFiles/currentUser.txt");
        File cartFile = new File("TextFiles/cartPrice.txt");
        String fileLine, userInfo = "";
        String currentFile = "cUserFile";
        /* Old input method
        System.out.println("Please enter your user ID:");
        ID = keyboardInput.nextLine();
        System.out.println("Please enter your password:");
        password = keyboardInput.nextLine();
         */
        //Verify valid info
        password = pass;
        ID = user;

        //Verify valid info
        try {
            Scanner accountsReader = new Scanner(accountsFile);
            while (accountsReader.hasNextLine()) {
                fileLine = accountsReader.nextLine();
                if (fileLine.equals("--")){
                    if (accountsReader.nextLine().equals(ID)) {
                        userInfo = userInfo + ID;
                        if (accountsReader.nextLine().equals(password)) {

                            try {

                                PrintWriter wipe = new PrintWriter(cUserFile);
                                wipe.print("");
                                PrintWriter wipePrice = new PrintWriter(cartFile);
                                wipePrice.print("");
                                wipePrice.close();
                                System.out.println(ID);
                                FileWriter writer = new FileWriter(cUserFile, false);

                                writer.write(ID + "\n" + password+"\n");

                                Name = accountsReader.nextLine();
                                writer.write(Name+"\n");
                                if(accountsReader.hasNextLine()){
                                    Address = accountsReader.nextLine();
                                    writer.write(Address+"\n");
                                    Phone = accountsReader.nextLine();
                                    writer.write(Phone+"\n");
                                    CCNumber = accountsReader.nextLine();
                                    writer.write(CCNumber+"\n");
                                    Type = accountsReader.nextLine();
                                    writer.write(Type+"\n");
                                }
                                else if(!accountsReader.hasNextLine()){
                                    Type = Name;
                                }

                                writer.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }



                            ReturnBoolean = "true";
                            userType = new String[]{ReturnBoolean, Type};
                            //main2();
                        }
                    }
                }
            }
            accountsReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        /*public void setUserName(String user) {
            this.ID = new String(user);
        }*/

        return userType;
    }

}
