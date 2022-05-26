/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.models;

import com.mycompany.cs4227.communication.framework.profile.IProfileInterFace;

/**
 *
 * @author Rory
 */
public class MyProfile {
    
    private IProfileInterFace myAccount;
    
    private static MyProfile instance = null;
    
     protected MyProfile(IProfileInterFace myAcount){
        //BEST PATTERN EVER!!!!!!!!
        this.myAccount = myAcount;
    }
     
     public IProfileInterFace getMyAccount(){
         return this.myAccount;
     }
     
     public static MyProfile getInstance(){
         return instance;
     }
     
     public static MyProfile getInstance(IProfileInterFace myAcount){
        if (instance == null){
            instance = new MyProfile(myAcount);
        }
        return instance;
    }
}
