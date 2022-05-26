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
public interface IProfileInterFace {

    public boolean isLoggedIn();

   public void setState(State state);

    public void setActivateAccount();

    public String getUserType();

    public State getState();
    
    public IProfileInterFace getMyAccount();

    public String[] getChannels();

    public String getUserName();

    public void setPassword(String password);

    public void addChannel(String string);

    public String getPassword();
    
}
