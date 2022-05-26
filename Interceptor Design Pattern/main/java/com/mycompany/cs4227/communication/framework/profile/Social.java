/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.profile;

import com.mycompany.cs4227.communication.framework.ui.FlexiableFrame;

/**
 *
 * @author Rory
 */
public class Social implements Profile{
    
    public Social(){
        
       /**
        * Creates Social frame
        */
    }

    @Override
    public void signIn() {
        System.out.print("Social USER");
        FlexiableFrame business = new FlexiableFrame();
        business.runUI();
    }
    
}
