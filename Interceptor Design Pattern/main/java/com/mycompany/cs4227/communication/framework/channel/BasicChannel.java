/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.channel;

import javax.swing.JOptionPane;

/**
 *
 * @author Gavin Thorpe
 */
public class BasicChannel implements Channel { //A Reciever

    private boolean muted = false;
    private String channelName = null;
    
    @Override
    public void mute() {
        JOptionPane.showMessageDialog(null, "Old Value - Channel Muted: " + muted + "\nNew Value - Channel Muted: true");
        muted = true;
        System.out.println("Channel is muted");
    }

    @Override
    public void unmute() {
        JOptionPane.showMessageDialog(null, "Old Value - Channel Muted: " + muted + "\nNew Value - Channel Muted: false");
        muted = false;
        System.out.println("Channel is unmuted");
    }
    
    @Override
    public boolean checkIfMuted() {
        System.out.println("Channel muted: " + muted);
        return muted;
    }
    
    @Override
    public String getChannelName() {
        System.out.println("Channel name: " + channelName);
        return channelName;
    }
    
}
