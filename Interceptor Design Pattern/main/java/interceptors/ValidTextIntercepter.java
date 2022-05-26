/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import contextobjects.IContextObjects;

/**
 *
 * @author Rory
 * this validates users name input and also checks if password is in correct format
 */
public class ValidTextIntercepter implements Interceptor{

    @Override
    public void update(IContextObjects context) {
        System.out.println("Update called on ValidTextIntercepter.");  //observer
        String userInput = context.getTextString();
        if (userInput.length() < 4 || userInput.equalsIgnoreCase("") ) {
            System.out.println("Username must be at least 4 characters long");
            context.setTextString("usernameFormat");
            context.createLog();
        }  else {
            context.setTextString("valid");
            context.createLog();
        }
        
    }
    
}
