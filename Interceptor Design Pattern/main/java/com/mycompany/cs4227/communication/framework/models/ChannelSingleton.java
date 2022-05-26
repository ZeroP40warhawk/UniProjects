/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.models;

import java.util.ArrayList;

/**
 *
 * @author Rory
 */
public class ChannelSingleton {
     private static ChannelSingleton instance = null;
     
     private ArrayList<ChannelModel> channels;
     
     protected ChannelSingleton(){
        //BEST PATTERN EVER!!!!!!!!
        channels = new ArrayList<>();
    }
     
     public static ChannelSingleton getInstance(){
        if (instance == null){
            instance = new ChannelSingleton();
        }
        return instance;
    }
     
    public ChannelModel getChannel(String name){
        for (int i = 0; i < channels.size(); i++){
            if (channels.get(i).getChannelName().equalsIgnoreCase(name)){
               return channels.get(i);
           }
        }
        return null;
    }
    
     
   public String getChannelText(String name){
       for (int i =0 ; i < channels.size();i++){
           if (channels.get(i).getChannelName().equalsIgnoreCase(name)){
               return channels.get(i).getChannelContext();
           }
       }
       return "Just a lonely string";
   }
   
    public void addChannel(ChannelModel channel) {
        this.channels.add(channel);
    }
}
