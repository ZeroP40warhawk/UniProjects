/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.dbmanagers;

import com.mycompany.cs4227.communication.framework.plug.Adapter;
import com.mycompany.cs4227.communication.framework.plug.IPlugInterface;
import com.mycompany.cs4227.communication.framework.plug.OnlineServer;
import com.mycompany.cs4227.communication.framework.plug.LocalServer;

/**
 *
 * @author Rory
 * This is the Database class getting a instance of this will allow the user to visit each function of the database
 * class with out having to implement all functions just ones that are needed
 */
public class DataBase {
   
    private String fileName;
    private String userName;
    private String userType;
    private String password;
    private ValidaterDatabaseStrategy strategy;
    
    public DataBase(String fileName){
        this.fileName = fileName;
        this.userName = "";
        this.userType = "";
        setConnectionType();
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword (String password){
        this.password = password;
    }
    // regular operation on the database
    public DataBase(String fileName,String userName,String userType, final ValidaterDatabaseStrategy strategy){
        this.fileName = fileName;
        this.userName = userName;
        this.userType = userType;
        this.strategy = strategy;
        setConnectionType();
    }
    
    private void setConnectionType(){
        IPlugInterface adapter = new Adapter(new OnlineServer());
        if (adapter.requestDelegate())
        {
            /**
             * this is faux adapter
             */
        } 
        else {
            adapter.setDelegate(new LocalServer());
            adapter.requestDelegate();
        }
    }
    
    public void setUserType(String userType){
        this.userType = userType;
    }
    //used when a new user is being added
    public DataBase(String fileName,String userName,String userType,String password, final ValidaterDatabaseStrategy strategy){
        this.fileName = fileName;
        this.userName = userName;
        this.userType = userType;
        this.password = password;
        this.strategy = strategy;
    }
    
    public boolean isValidOperation(){
        return strategy.performAction(fileName, userName,userType,password);
    }
     // Set Strategy
    public void setStrategy(final ValidaterDatabaseStrategy strategy) {
        this.strategy = strategy;
    }
    
}
