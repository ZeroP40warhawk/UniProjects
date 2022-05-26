/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.profile;

import java.util.ArrayList;

/**
 *
 * @author Rory
 * 
 */
public class ProfileContext implements IProfileInterFace{
      private State state;
      private String userName;
      private String userType;
      private String password;
      private ArrayList <String> channels;

  public ProfileContext(State state) {
    this.state= state;
  }

    public ProfileContext(String userName,String userType) {
        this.userName = userName;
        this.userType = userType;
        this.channels = new ArrayList<>();
    }
    
      @Override
    public void addChannel(String channel){
        this.channels.add(channel);
    }
    
      @Override
    public String [] getChannels(){
        String [] channelsList = new String[channels.size()];
        for (int i =0 ; i < channels.size(); i++){
            channelsList[i] = channels.get(i);
        }
        return channelsList;
    }
    
      @Override
    public String getUserName(){
        return this.userName;
    }
    
      @Override
    public String getUserType(){
        return this.userType;
    }
    
      @Override
    public void setPassword(String password){
        this.password = password;
    }
    
      @Override
    public String getPassword (){
        return this.password;
    }
    
      @Override
    public void setActivateAccount(){
        ProfileFactory profileTypeFactory = new ProfileFactory();
        Profile profileType = profileTypeFactory.getProfileType(userType);
        profileType.signIn();
    }
    
    public void setUpFactory(){
        ProfileFactory profileTypeFactory = new ProfileFactory();
        Profile profileType = profileTypeFactory.getProfileType(userType);
        profileType.signIn();
    }

      @Override
  public boolean isLoggedIn() {
    return state.getLogState();
  }
  
      @Override
  public State getState() {
    return state;
  }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public IProfileInterFace getMyAccount() {
        return this;
    }

 


}
