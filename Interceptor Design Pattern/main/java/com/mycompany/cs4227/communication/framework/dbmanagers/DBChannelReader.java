/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import com.mycompany.cs4227.communication.framework.models.ChannelModel;
import com.mycompany.cs4227.communication.framework.models.ChannelSingleton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rory
 */
public class DBChannelReader implements ValidaterDatabaseStrategy{

    @Override
    public boolean performAction(String filePath, String userName, String userType, String password) {
        return readChannelFile(filePath,userType);
    }
    
    public boolean readChannelFile(String filePath, String userType){
        boolean isValid = false;
         BufferedReader br = null;
        File file = new File(filePath);
        if (file.exists()) {
            try {
                br = new BufferedReader(new java.io.FileReader(filePath));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                StringBuilder all = new StringBuilder();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    String [] lineSplit = line.split(",");
                    String user = lineSplit[0];
                    String content = lineSplit[2];
                    all.append(user).append("; ").append(content).append("\n");
                    line = br.readLine();
                }
                ChannelModel channel;
                if (ChannelSingleton.getInstance().getChannel(userType) != null){
                    channel = ChannelSingleton.getInstance().getChannel(userType);
                    channel.setChannelContent(all.toString());
                }
                else {
                     channel = new ChannelModel(userType,all.toString());
                }
                ChannelSingleton.getInstance().addChannel(channel);
                isValid = true;

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
        System.out.println("Channel Read");
        return isValid;
    }
}
