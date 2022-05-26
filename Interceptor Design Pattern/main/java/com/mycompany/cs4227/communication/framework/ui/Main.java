/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.ui;

import java.io.File;

/**
 *
 * @author Rory
 */

public class Main {
    // this is just set up so we only have to change where the we are looking at files on one area
    public static final String USERSFILE = "C:"+File.separatorChar+"users"+File.separatorChar+"alan"+File.separatorChar+"desktop"+File.separatorChar+"usersList.txt";
    public static final String FILEPATH = "C:"+File.separatorChar+"users"+File.separatorChar+"alan"+File.separatorChar+"desktop"+File.separatorChar;

    
    public static void main (String [] args){
        
        LoginFrame frame = new LoginFrame();
        frame.runUI();
        
    }
}

