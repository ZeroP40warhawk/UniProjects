/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.models;

import contextobjects.ContextObjectsFactory;
import contextobjects.IContextObjects;
import dispatchers.Dispatcher;
import interceptors.Interceptor;
import interceptors.ReadInterceptor;

/**
 *
 * @author Rory
 */
public class ChannelModel {
    
    private String channelName;
    private String channelContent;
    private Dispatcher dispatch;
    private Interceptor incept;
    
    
    public ChannelModel(String channelName,String channelContent){
        this.channelName = channelName;
        this.channelContent = channelContent;
        dispatch = new Dispatcher();
        incept = new ReadInterceptor();
        dispatch.register(incept, 0);
    }
    
    public void setChannelContent(String channelContent){
        ContextObjectsFactory inceptFact = new ContextObjectsFactory();
                IContextObjects context = inceptFact.getContextObject(this.getChannelName(), /**databasetext**/ channelContent,"", "Bold");
                dispatch.update(context, 0);
        this.channelContent = context.getTextString();
    }
    
    public String getChannelName(){
        return this.channelName;
    }
    
    public String getChannelContext(){
        return this.channelContent;
    }
    
}
