/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import com.mycompany.cs4227.communication.framework.profile.LoggedInState;
import com.mycompany.cs4227.communication.framework.profile.LoggedOutState;
import com.mycompany.cs4227.communication.framework.profile.ProfileContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.cs4227.communication.framework.models.UsersProfiles;

/**
 *
 * @author Rory
 */
public class DBReader implements ValidaterDatabaseStrategy {

    @Override
    public boolean performAction(String filePath, String userName, String userType, String password) {   
        return checkUserName(filePath, userName);
    }
    
    private ArrayList <String[]> allUsers = new ArrayList();
    private String userName;

    public boolean checkUserName(String filePath, String userName) {
        this.userName = userName;
        boolean isValid = false;
        System.out.println("DBValidateUser accepted");
        BufferedReader br = null;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(filePath));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    parseFile(line);
                    line = br.readLine();
                }
                isValid = isUserNameAvailable();

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            } catch (IOException ex) {
                Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("File Not Found");
        }
        return isValid;
    }

    private void parseFile(String line) {
        String [] lineSplit = line.split(",");
        ProfileContext user = new ProfileContext(lineSplit[0],lineSplit[1]);
        System.out.println(lineSplit[3]);
        if (lineSplit[6].equalsIgnoreCase("ONLINE")){
            LoggedInState login = new LoggedInState();
                    user.setState(login);
        } else {
            LoggedOutState loggedOut = new LoggedOutState();
                    user.setState(loggedOut);
        }
        UsersProfiles.getInstance().addUser(user);
        allUsers.add(lineSplit);
    }

    private boolean isUserNameAvailable() {
        for (int i = 0 ; i < allUsers.size(); i++){
            String [] lineSplit = allUsers.get(i);
            if (userName.equals(lineSplit[0])){
                //user name already in use
                return false;
            }
        }
        // user name is avaiable
        return true;
    }

}
