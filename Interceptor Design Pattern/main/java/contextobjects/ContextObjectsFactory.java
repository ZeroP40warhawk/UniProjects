/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contextobjects;

/**
 *
 * @author danie
 */
public class ContextObjectsFactory {
    
    public IContextObjects getContextObject(String room, String text, String username, String eventType){
        if (eventType.equalsIgnoreCase("write")){
            return new ContextObject(room,text,username,eventType);
        } else if (eventType.equalsIgnoreCase("options")) {
            return new InterceptOptions(text);
        } else if (eventType.equalsIgnoreCase("Bold")){
            return new InterceptorBold(text);
        }
        return null;
    }
    
}
