/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rory
 */
public class DBgetUserType implements ValidaterDatabaseStrategy{
    
    private ArrayList <String[]> allUsers = new ArrayList();
    private String userName;
    private String userType;
    
    @Override
    public boolean performAction(String filePath, String userName, String userType, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return gameType(filePath, userName, userType);
    }

    private boolean gameType(String filePath, String userName, String userType) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         this.userName = userName;
         this.userType = userType;
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
                isValid = isGameType();

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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String [] lineSplit = line.split(",");
        allUsers.add(lineSplit);
    }
    
    private boolean isGameType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0 ; i < allUsers.size(); i++){
            
            String [] lineSplit = allUsers.get(i);
            System.out.println(userName +"   "+ userType);
            if (userType.equals(lineSplit[1]) && userName.equals(lineSplit[0])){
                //user name already in use
                return true;
            }
        }
        // user name is avaiable
        return false;
    }
    
}
