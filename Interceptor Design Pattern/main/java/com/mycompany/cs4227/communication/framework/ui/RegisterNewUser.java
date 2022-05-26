/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.ui;

import contextobjects.ContextObjectsFactory;
import contextobjects.IContextObjects;
import dispatchers.Dispatcher;
import interceptors.ValidTextIntercepter;
import com.mycompany.cs4227.communication.framework.dbmanagers.DBGetAllUsers;
import com.mycompany.cs4227.communication.framework.dbmanagers.DBWriter;
import com.mycompany.cs4227.communication.framework.dbmanagers.DataBase;
import com.mycompany.cs4227.communication.framework.profile.LoggedInState;
import static com.mycompany.cs4227.communication.framework.ui.Main.USERSFILE;
import java.util.Arrays;
import com.mycompany.cs4227.communication.framework.models.MyProfile;
import com.mycompany.cs4227.communication.framework.models.UsersProfiles;
import com.mycompany.cs4227.communication.framework.profile.IProfileInterFace;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Rory More or less some function as login frame but this will add new
 * users to the database
 */
public class RegisterNewUser extends javax.swing.JFrame implements UIInterface {

    private ButtonGroup userTypeButtonGroup;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel confirmPassLabel;
    private JLabel acountTypeLabel;
    private JPasswordField passwordFieldOne;
    private JPasswordField passwordFieldTwo;
    private JRadioButton busniessButton;
    private JRadioButton socialButton;
    private JRadioButton gamerButton;
    private JTextField userNameField;

    private String accountType;
    private transient DataBase database;
    private transient Dispatcher dispatch;
    private transient IContextObjects context;

    public RegisterNewUser() {
        dispatch = new Dispatcher();
        dispatch.register(new ValidTextIntercepter(), 0);
        initComponents();
    }

    //this just sets up UI elements 
    private void initComponents() {

        userTypeButtonGroup = new ButtonGroup();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        confirmPassLabel = new JLabel();
        acountTypeLabel = new JLabel();
        busniessButton = new JRadioButton();
        socialButton = new JRadioButton();
        gamerButton = new JRadioButton();
        passwordFieldOne = new JPasswordField();
        passwordFieldTwo = new JPasswordField();
        userNameField = new JTextField();
        confirmButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New User");

        userNameLabel.setText("User Name");
        passwordLabel.setText("Password");
        confirmPassLabel.setText("Confirm Password");
        acountTypeLabel.setText("Account Type");

        userTypeButtonGroup.add(busniessButton);
        busniessButton.setText("Business");
        busniessButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            businessButtonAction(evt);
        });

        userTypeButtonGroup.add(socialButton);
        socialButton.setText("Social");
        socialButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            socialButtonAction(evt);
        });

        userTypeButtonGroup.add(gamerButton);
        gamerButton.setText("Gaming");
        gamerButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            gamerButtonAction(evt);
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            addUserAction(evt);
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            cancelButtonAction(evt);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(busniessButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gamerButton))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(confirmPassLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passwordFieldTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(80, 80, 80)
                                                        .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(passwordLabel)
                                                        .addGap(109, 109, 109)
                                                        .addComponent(passwordFieldOne, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(56, 56, 56))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(socialButton)
                                                .addComponent(acountTypeLabel))
                                        .addGap(160, 160, 160))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cancelButton)
                                        .addGap(86, 86, 86)
                                        .addComponent(confirmButton)
                                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(userNameLabel)
                                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordLabel)
                                .addComponent(passwordFieldOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmPassLabel)
                                .addComponent(passwordFieldTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(acountTypeLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(busniessButton)
                                .addComponent(socialButton)
                                .addComponent(gamerButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmButton)
                                .addComponent(cancelButton))
                        .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void businessButtonAction(ActionEvent evt) {
        accountType = "BUSINESS";
    }

    private void cancelButtonAction(ActionEvent evt) {
        this.dispose();
    }

    private void socialButtonAction(ActionEvent evt) {
        accountType = "SOCIAL";
    }

    private void gamerButtonAction(ActionEvent evt) {
        accountType = "GAMER";
    }

    private void addUserAction(java.awt.event.ActionEvent evt) {
        ContextObjectsFactory inceptFact = new ContextObjectsFactory();
        context = inceptFact.getContextObject("", userNameField.getText(), "", "options");
        UsersProfiles.getInstance().clearList();
        if ((Arrays.toString(passwordFieldOne.getPassword()).equals(Arrays.toString(passwordFieldTwo.getPassword())) && userNameField.getText() != null && isTypeChoosen())) {
            this.database = new DataBase(USERSFILE);
            this.database.setUserName(userNameField.getText());
            this.database.setPassword(Arrays.toString(passwordFieldOne.getPassword()));
            this.database.setUserType(accountType);
            if (!UsersProfiles.getInstance().isUserInDatabase(userNameField.getText(), Arrays.toString(passwordFieldOne.getPassword()))) {
                this.database.setStrategy(new DBWriter());
                if (!database.isValidOperation()) {
                    //context of user profile
                    database.setStrategy(new DBGetAllUsers());
                    database.isValidOperation();
                        // user found show valid 
                        dispatch.update(context, 0);
                        IProfileInterFace userProfile = UsersProfiles.getInstance().getCurrentUser(userNameField.getText());
                        //Our logged in state
                        LoggedInState login = new LoggedInState();
                        if (!userProfile.isLoggedIn()) {
                            userProfile.setState(login);
                            //just a simple class to keep track of who is currently signed in
                            MyProfile.getInstance(userProfile);
                            //this activate the Factory Method
                            userProfile.setActivateAccount();
                            this.dispose();
                        }
                }
            } else {
                dispatch.update(context, 0);
            }
        } else {
            dispatch.update(context, 0);
        }

    }

    // this is just to check that a user type has been selected
    private boolean isTypeChoosen() {
        return busniessButton.isSelected() || socialButton.isSelected() || gamerButton.isSelected();
    }

    @Override
    public void runUI() {
        new RegisterNewUser().setVisible(true);
    }

}
