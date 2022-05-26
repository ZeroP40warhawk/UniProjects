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
public class OnlineServer extends IOnlineServer{

    @Override
    public boolean connect() {
       System.out.println("Trying to connect to remote server");
       System.out.println("Could not connect to remote server");
       return false;
    }
    
}
