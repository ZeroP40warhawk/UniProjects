/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import contextobjects.IContextObjects;

/**
 *
 * @author Alan
 */
public class WriteInterceptor implements Interceptor {

    @Override
    public void update(IContextObjects context) {
        System.out.println("Update called on LI.");  //observer
        String userInput = context.getTextString();
        System.out.println(userInput);
        if (userInput.toLowerCase().contains("mega class")) {
            System.out.println("Bad word detected in text: " + userInput);
            context.setTextString(userInput.replaceAll("(?i)mega class", "****"));
        }
        context.createLog();
    }
    
}
