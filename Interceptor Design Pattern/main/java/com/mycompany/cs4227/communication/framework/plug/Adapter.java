/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.plug;

/**
 *
 * @author Rory
 */
public class Adapter implements IPlugInterface{
    private SuperConnect connectionType;
    
    public Adapter(SuperConnect localServer){
        this.connectionType = localServer;
    }
    
    @Override
    public void setDelegate(SuperConnect connect){
        this.connectionType = connect;
    }
    
    @Override
    public boolean requestDelegate() {
        return this.connectionType.connect();
    }
}
