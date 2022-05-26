package com.mycompany.cs4227.communication.framework.ui;

import contextobjects.ContextObjectsFactory;
import contextobjects.IContextObjects;
import dispatchers.Dispatcher;
import interceptors.ReadInterceptor;
import interceptors.ValidTextIntercepter;
import interceptors.WriteInterceptor;
import com.mycompany.cs4227.communication.framework.dbmanagers.DBGetAllUsers;
import com.mycompany.cs4227.communication.framework.dbmanagers.DataBase;
import com.mycompany.cs4227.communication.framework.profile.LoggedInState;
import static com.mycompany.cs4227.communication.framework.ui.Main.USERSFILE;
import java.util.Arrays;
import com.mycompany.cs4227.communication.framework.models.MyProfile;
import com.mycompany.cs4227.communication.framework.models.UsersProfiles;
import com.mycompany.cs4227.communication.framework.profile.IProfileInterFace;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Rory
 * Just standard login frame 
 * required fields are username and password
 * dispatch here is to test our intercepter/factory/display
 * The intercepter context object is now generated using the factory method 
 * the InterceptOptions is generated which intercepts when login in is pressed and 
 * checks for valid input which it then its context objects handles which dialog is to be displayed
 */
public class LoginFrame extends javax.swing.JFrame implements UIInterface {
    
    private transient Dispatcher dispatch;
    private transient IContextObjects context;
    private transient DataBase database;                     
    private JButton resetButton;
    private JButton loginButton;
    private JButton regButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JTextField userNameTextField;
    private final String loginString = "Login";
    /**
     * Creates new form LoginFrame
     * 
     */
    public LoginFrame() {
        dispatch = new Dispatcher();
        dispatch.register(new ValidTextIntercepter(), 0);
        initComponents();
    }
    
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        regButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(loginString);

        userNameLabel.setText("User Name");

        passwordLabel.setText("Password");

        resetButton.setText("Reset");
        resetButton.addActionListener((ActionEvent evt) -> {
            resetButtonAction(evt);
        });

        loginButton.setText(loginString);
        
        loginButton.addActionListener((ActionEvent evt) -> {
            loginAction(evt);
        });

        regButton.setText("Register");
        regButton.addActionListener((ActionEvent evt) -> {
            registerNewUserAction(evt);
        });

        passwordField.setName(loginString); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(loginButton)
                        .addGap(45, 45, 45)
                        .addComponent(regButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(userNameLabel))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userNameTextField)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(loginButton)
                    .addComponent(regButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }                        
    
    //this just launches the register screen
    private void registerNewUserAction(ActionEvent evt) {                                         
        //register new user as busniess user etc
        RegisterNewUser newUser = new RegisterNewUser();
        newUser.runUI();
        this.dispose();

    }                                        
    
    // I added this due to make testing easier 
    private void resetButtonAction(ActionEvent evt) {                                         
        // add your handling code here:
        if (userNameTextField.getText() != null) {
            userNameTextField.setText("");
        }
        if (passwordField.getPassword() != null) {
            this.passwordField.setText("");
        }
    }                                        

    private void loginAction(ActionEvent evt) {                                         
        ContextObjectsFactory inceptFact = new ContextObjectsFactory();
        context = inceptFact.getContextObject("",userNameTextField.getText(),"","options");
       
        if ((passwordField.getPassword() != null) && userNameTextField.getText() != null) {
            if (UsersProfiles.getInstance().isUserInDatabase(userNameTextField.getText(), Arrays.toString(passwordField.getPassword()))) {
                // user found show valid 
                 dispatch.update(context, 0);
                IProfileInterFace userProfile = UsersProfiles.getInstance().getCurrentUser(userNameTextField.getText());
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
            } else {
                // user not found notify user
                dispatch.update(context, 0);
            }
        } else {
            //password and text field is empty notify user
            dispatch.update(context, 0);
        }
    }                                        
                                               

    @Override
    public void runUI() {
        database = new DataBase(USERSFILE);
        database.setStrategy(new DBGetAllUsers());
        database.isValidOperation();
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }                   
}

