/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dialogs;

/**
 *
 * @author Rory
 */
public class OptionPaneFacade {
    
    private ErrorOption error;
    private ValidOption valid;
    private UserNotFoundOption notFound;
    private InputTextError textError;
    
        
    private static OptionPaneFacade instance = null;
    
     protected OptionPaneFacade(){
        //BEST PATTERN EVER!!!!!!!!
        error = new ErrorOption();
        valid = new ValidOption();
        notFound = new UserNotFoundOption();
        textError = new InputTextError();
        
    }
     
     public static OptionPaneFacade getInstance(){
        if (instance == null){
            instance = new OptionPaneFacade();
        }
        return instance;
    }
    
    public void showInputError(){
        textError.show();
    }
     
     public void showError(){
         error.show();
     }
     
     public void showValid(){
         valid.show();
     }
     
     public void notFound(){
         notFound.show();
     }
  
}
