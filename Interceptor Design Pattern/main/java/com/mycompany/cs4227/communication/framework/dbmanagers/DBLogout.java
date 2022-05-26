/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rory
 */
public class DBLogout implements ValidaterDatabaseStrategy{

    @Override
    public boolean performAction(String filePath, String userName, String userType, String password) {
       return userStateUpdated(filePath);
    }

    private boolean userStateUpdated(String filePath) {
        boolean userSuccess = false;
         // add a new user to users file
        BufferedWriter bw = null;
        FileWriter fw = null;
         try {
         //Specify the file name and path here
	 File file = new File(filePath);

	 /* This logic will make sure that the file 
	  * gets created if it is not present at the
	  * specified location*/
	  if (!file.exists()) {
	     
             boolean fileCreated = file.createNewFile();
             if(fileCreated)
                 System.out.println("File created.");
             else
                 System.out.println("File not created");
	  }

	  fw = new FileWriter(file,true);
	  bw = new BufferedWriter(fw);
          //Needs to be edited to change users state to OFFLINE
          System.out.println("File written Successfully");

      } catch (IOException ioe) {
          System.out.println(ioe);
	}
	finally
	{ 
	   try{
	      if(bw!=null)
                 bw.close();
              if (fw!=null)
              fw.close();
	   }catch(Exception ex){
	       System.out.println("Error in closing the BufferedWriter"+ex);
	    }
	}
        
        return userSuccess;
    }
    
}
