/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import com.mycompany.cs4227.communication.framework.profile.LoggedInState;
import com.mycompany.cs4227.communication.framework.profile.LoggedOutState;
import com.mycompany.cs4227.communication.framework.profile.ProfileContext;
import com.mycompany.cs4227.communication.framework.models.UsersProfiles;
import com.mycompany.cs4227.communication.framework.profile.IProfileInterFace;

/**
 *
 * @author Rory
 */
public class FileParser {
    
    public void parseFile(String line) {
        String [] lineSplit = line.split(",");
        IProfileInterFace user = new ProfileContext(lineSplit[0],lineSplit[1]);
        String password = ""+lineSplit[2]+","+lineSplit[3]+","+lineSplit[4]+","+lineSplit[5]+"";
        user.setPassword(password);
        if (lineSplit[6].equalsIgnoreCase("ONLINE")){
            LoggedInState login = new LoggedInState();
                    user.setState(login);
        } else {
            LoggedOutState loggedOut = new LoggedOutState();
                    user.setState(loggedOut);
        }
        if (lineSplit.length > 6){
            for (int i = 7 ; i < lineSplit.length ; i++){
                user.addChannel(lineSplit[i]);
            }
        }
        UsersProfiles.getInstance().addUser(user);
    }
}
