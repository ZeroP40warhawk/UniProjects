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
public class LocalServer extends ILocalServer{

    @Override
    public boolean connect() {
        System.out.print("Setting up local Server");
        return true;
    }
    
}
