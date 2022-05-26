/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.profile;

/**
 *
 * @author Rory
 */
public class LoggedInState implements State{

    @Override
    public void login(IProfileInterFace profile) {
        System.out.println("User is logged in.");
        profile.setState(this);
    }
    
    @Override
    public boolean getLogState(){
        return true;
    }
    
    
}
