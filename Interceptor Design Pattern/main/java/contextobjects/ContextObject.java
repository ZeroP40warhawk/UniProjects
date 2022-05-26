/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contextobjects;

import com.mycompany.cs4227.communication.framework.dbmanagers.DBWriter;
import com.mycompany.cs4227.communication.framework.dbmanagers.DataBase;
import static com.mycompany.cs4227.communication.framework.ui.Main.FILEPATH;

/**
 *
 * @author Rory
 */
public class ContextObject implements IContextObjects {
    private String contextUsername;
    private String contextText;
    private String contextRoom;
    private String eventType;

    public ContextObject (String room, String text, String username, String eventType){
        this.contextRoom = room;
        this.contextText = text;
        this.contextUsername = username;
        this.eventType = eventType;
    }
    
    @Override
    public void createLog() {
        System.out.println("Intercepted Data: " +this.contextRoom +","+ this.contextText+","+this.contextUsername+","+this.eventType);
        DataBase database = new DataBase(FILEPATH+this.contextRoom+".txt");
        database.setPassword(this.contextText);
        database.setUserName(this.contextUsername);
        database.setUserType(eventType);
        
        database.setStrategy(new DBWriter());
        database.isValidOperation();
    }
    
    @Override
     public void setTextString(String newText){
        contextText = newText;
    }

    @Override
    public String getTextString() {
        return contextText;
    }
}
