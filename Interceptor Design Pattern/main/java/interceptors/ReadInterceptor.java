/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import contextobjects.IContextObjects;
import java.util.ArrayList;

/**
 *
 * @author ajjam_000
 */
public class ReadInterceptor implements Interceptor{


    @Override
    public void update(IContextObjects context) {
        String [] temp;
        String tempStr;
        temp = context.getTextString().split(" ");
        
        ArrayList<String> messageText = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            messageText.add(temp[i]);
        }
        //check for formatting
        for(int i = 0; i < messageText.size(); i++){
            if(messageText.get(i).toLowerCase().contains("@bold")){
                tempStr = "This will be bold "+messageText.get(i+1);
                messageText.set(i+1, tempStr);
                messageText.remove(i);
            }
        }
        
        tempStr = "";
        for(int i = 0; i < messageText.size(); i++){
             tempStr += messageText.get(i) + " ";
        }
        context.setTextString(tempStr);
    }
    
}
