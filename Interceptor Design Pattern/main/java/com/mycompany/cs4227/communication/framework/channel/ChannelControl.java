/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.channel;

/**
 *
 * @author Gavin Thorpe
 */
public class ChannelControl {
    
    public ChannelControl(){
        /**
        * Default constructor no args needed
        */       
    }
    
    public static Channel getChannel(){
        
        return new BasicChannel();
        
    }
    
}
