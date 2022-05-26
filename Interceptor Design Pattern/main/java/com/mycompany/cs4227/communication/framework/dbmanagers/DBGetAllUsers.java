/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

/**
 *
 * @author Rory
 */
public class DBGetAllUsers implements ValidaterDatabaseStrategy{

    @Override
    public boolean performAction(String filePath, String userName, String userType, String password) {
        return readInUsersFile(filePath);
    }

    private boolean readInUsersFile(String filePath) {
        return new DBFileReader(filePath).readFile();
    }
    
}
