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
public class NameOfChannel implements Command {
    
    Channel aChannel;
    
    public NameOfChannel(Channel newChannel){
        
        aChannel = newChannel;
        
    }
    
    @Override
    public void execute() {
        aChannel.getChannelName();
    }
    
}
