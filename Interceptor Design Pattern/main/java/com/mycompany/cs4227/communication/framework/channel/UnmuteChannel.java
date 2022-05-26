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
public class UnmuteChannel implements Command {
    
    Channel aChannel;
    
    public UnmuteChannel(Channel newChannel){
        
        aChannel = newChannel;
        
    }
    
    @Override
    public void execute() {
        aChannel.unmute();
    }
    
}
