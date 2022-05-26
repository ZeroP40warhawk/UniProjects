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
public class ProfileFactory {
     public Profile getProfileType(String profileType){
      if(profileType == null){
         return null;
      }		
      if(profileType.equalsIgnoreCase("SOCIAL")){
         return new Social();
         
      } else if(profileType.equalsIgnoreCase("GAMER")){
         return new Gamer();
         
      } else if(profileType.equalsIgnoreCase("BUSINESS")){
         return new Business();
      }
     
      return null;
   }
}
