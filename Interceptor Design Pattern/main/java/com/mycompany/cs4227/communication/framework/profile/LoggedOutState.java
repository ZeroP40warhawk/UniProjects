/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.profile;

import com.mycompany.cs4227.communication.framework.dbmanagers.DBLogout;
import com.mycompany.cs4227.communication.framework.dbmanagers.DataBase;
import static com.mycompany.cs4227.communication.framework.ui.Main.USERSFILE;

/**
 *
 * @author Rory
 */
public class LoggedOutState implements State{

    @Override
    public void login(IProfileInterFace profile) {
        System.out.println("User logged out.");
        profile.setState(this);
        DataBase database = new DataBase(USERSFILE);
        database.setStrategy(new DBLogout());
        database.isValidOperation();
         }
    
    @Override
    public boolean getLogState(){
        return false;
    }
    
}
