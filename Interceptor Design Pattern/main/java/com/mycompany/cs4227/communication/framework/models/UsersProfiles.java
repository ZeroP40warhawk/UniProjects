/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.models;

import com.mycompany.cs4227.communication.framework.profile.IProfileInterFace;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rory
 */
public class UsersProfiles {
    private ArrayList <IProfileInterFace> allUser;
    private ArrayList <IProfileInterFace> allBusinessUsers;
    private ArrayList <IProfileInterFace> allSocialUsers;
    private ArrayList <IProfileInterFace> allGamerUsers;
    private static UsersProfiles instance = null;
    private static final String business = "BUSINESS";
    private static final String social = "SOCIAL";
    
     protected UsersProfiles(){
        //BEST PATTERN EVER!!!!!!!!
        allUser = new ArrayList<>();
        allBusinessUsers = new ArrayList<>();
        allSocialUsers = new ArrayList<>();
        allGamerUsers = new ArrayList<>();
    }
     
     public static UsersProfiles getInstance(){
        if (instance == null){
            instance = new UsersProfiles();
        }
        return instance;
    }
    
    public IProfileInterFace getCurrentUser(String userName){
        for (int i = 0 ; i < allUser.size(); i++){
            if (allUser.get(i).getUserName().equalsIgnoreCase(userName)){
                return allUser.get(i);
            }
        }
        return null;
    }
     
    public List<IProfileInterFace> getUsers(String type){
        switch (type) {
            case business:
                return allBusinessUsers;
            case social:
                return allSocialUsers;
            default:
                return allGamerUsers;
        }
    }
    
    public boolean isUserInDatabase(String userName, String password){
        for (int i = 0 ; i < allUser.size(); i++){
            if (allUser.get(i).getUserName().equalsIgnoreCase(userName) && allUser.get(i).getPassword().equalsIgnoreCase(password)){
                return true;
            }
        }
        return false;
    }
    
    public String [] getOnlineUsers(String type){
        String [] onLineUsers;
        ArrayList<String> onlineUsersArray = new ArrayList<>();
        switch (type) {
            case business:
                for (int i = 0 ; i < allBusinessUsers.size(); i++){
                    if (allBusinessUsers.get(i).isLoggedIn()){
                        onlineUsersArray.add((allBusinessUsers.get(i).getUserName()));
                    }
                }       break;
            case social:
                for (int i = 0 ; i < allSocialUsers.size(); i++){
                    if (allSocialUsers.get(i).isLoggedIn()){
                        onlineUsersArray.add((allSocialUsers.get(i).getUserName()));
                    }
                }       break;
            default:
                for (int i = 0 ; i < allGamerUsers.size(); i++){
                    if (allGamerUsers.get(i).isLoggedIn()){
                        onlineUsersArray.add((allGamerUsers.get(i).getUserName()));
                    }
                }       break;
        }
        
        onLineUsers = new String[onlineUsersArray.size()];
        for(int i = 0; i < onlineUsersArray.size();i++){
            onLineUsers[i] = onlineUsersArray.get(i);
        }
        
        SortAlgorithm test = new SortAscending();
        test.sortAlgo(onLineUsers);
        return onLineUsers;
    } 
     
    public void addUser(IProfileInterFace user){
        this.allUser.add(user);
        switch (user.getUserType()) {
            case business:
                allBusinessUsers.add(user);
                break;
            case social:
                allSocialUsers.add(user);
                break;
            default:
                allGamerUsers.add(user);
                break;
        }
        
    }
    public void clearList(){
        allBusinessUsers.clear();
        allSocialUsers.clear();
        allGamerUsers.clear();
        allUser.clear();
    }
    public List<IProfileInterFace> getAllUsers(){
        return allUser;
    }
}
