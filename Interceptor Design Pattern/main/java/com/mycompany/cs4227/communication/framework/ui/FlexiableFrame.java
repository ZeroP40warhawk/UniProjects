/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cs4227.communication.framework.ui;

/**
 *
 * @author Rory
 * This is the main UI
 */
import contextobjects.ContextObjectsFactory;
import contextobjects.IContextObjects;
import dispatchers.Dispatcher;
import interceptors.ReadInterceptor;
import interceptors.WriteInterceptor;
import com.mycompany.cs4227.communication.framework.dbmanagers.DBChannelReader;
import com.mycompany.cs4227.communication.framework.dbmanagers.DataBase;
import com.mycompany.cs4227.communication.framework.profile.LoggedOutState;
import com.mycompany.cs4227.communication.framework.channel.Channel;
import com.mycompany.cs4227.communication.framework.channel.ChannelControl;
import com.mycompany.cs4227.communication.framework.channel.ChannelButton;
import com.mycompany.cs4227.communication.framework.channel.MuteChannel;
import com.mycompany.cs4227.communication.framework.channel.UnmuteChannel;
import com.mycompany.cs4227.communication.framework.models.ChannelSingleton;
import static com.mycompany.cs4227.communication.framework.ui.Main.FILEPATH;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import com.mycompany.cs4227.communication.framework.models.MyProfile;
import com.mycompany.cs4227.communication.framework.models.UsersProfiles;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Rory
 */
public class FlexiableFrame extends javax.swing.JFrame implements UIInterface{
                     
    private JButton addNewChannelButton;
    private JButton sendMessageButton;
    private JButton updateTextButton;
    private JLabel channelTypeLabel;
    private JLabel onlineListLabel;
    private JList<String> channelList;
    private JList<String> onlineUsersList;
    private JScrollPane channelScrollPanel;
    private JScrollPane onLineScrollPanel;
    private JScrollPane largeTextAreaPane;
    private JScrollPane textEditPane;
    private JTextArea largeTextArea;
    private JTextPane editableTextField;
           
    private transient Dispatcher dispatch;
    
    public FlexiableFrame() {
        //Creating dispatcher and registering interceptors with it
        dispatch = new Dispatcher();
        dispatch.register(new WriteInterceptor(), 0);
        dispatch.register(new ReadInterceptor(), 1);
        //initialize components
        initComponents();
    }

    public void refresh() {
        this.validate();
    }

    public void setFrameTitle(String title) {
        setTitle(title);
    }

    public void setUsersList() {
        onlineUsersList = new javax.swing.JList<>();

        onlineUsersList.setModel(new javax.swing.AbstractListModel<String>() {
            String [] test = UsersProfiles.getInstance().getOnlineUsers(MyProfile.getInstance().getMyAccount().getUserType());;

            @Override
            public int getSize() {
                return UsersProfiles.getInstance().getOnlineUsers(MyProfile.getInstance().getMyAccount().getUserType()).length;
            }

            @Override
            public String getElementAt(int i) {
                return test[i];
            }
        });
        channelScrollPanel.setViewportView(onlineUsersList);
        this.validate();
    }

    private void initComponents() {
        //this just captures the close button so with can change the users state and update the database
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                MyProfile.getInstance().getMyAccount().setState(new LoggedOutState());
                MyProfile.getInstance().getMyAccount().getState().login(MyProfile.getInstance().getMyAccount());
            }
        });
        channelTypeLabel = new javax.swing.JLabel();
        channelScrollPanel = new javax.swing.JScrollPane();
        channelList = new javax.swing.JList<>();
        onlineListLabel = new javax.swing.JLabel();
        onLineScrollPanel = new javax.swing.JScrollPane();
        onlineUsersList = new javax.swing.JList<>();
        addNewChannelButton = new javax.swing.JButton();
        largeTextAreaPane = new javax.swing.JScrollPane();
        largeTextArea = new javax.swing.JTextArea();
        textEditPane = new javax.swing.JScrollPane();
        editableTextField = new javax.swing.JTextPane();
        sendMessageButton = new javax.swing.JButton();
        updateTextButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(MyProfile.getInstance().getMyAccount().getUserType() + " Channel");

        channelTypeLabel.setText(MyProfile.getInstance().getMyAccount().getUserType() + " Channels");

        //Channel List
        channelList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = MyProfile.getInstance().getMyAccount().getChannels();

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        channelScrollPanel.setViewportView(channelList);

        String[] amountOfChannels = MyProfile.getInstance().getMyAccount().getChannels();
        Channel[] channels = new Channel[amountOfChannels.length];
        for (int i = 0; i < amountOfChannels.length; i++) {
            channels[i] = ChannelControl.getChannel();
            System.out.println(i + ". Created Channel: " + amountOfChannels[i]);
        }

        JMenuItem muteChannelPopup = new JMenuItem("Mute Channel");
        muteChannelPopup.addActionListener((ActionEvent e) -> {
            int channelNum = channelList.getSelectedIndex();
            if (channelNum == -1) {
                channelNum = 0;
            }
            MuteChannel muteCommand = new MuteChannel(channels[channelNum]);
            System.out.println("Channel : " + channelNum);
            ChannelButton muteButton = new ChannelButton(muteCommand);
            muteButton.press();
        });

        JMenuItem unmuteChannelPopup = new JMenuItem("Unmute Channel");
        unmuteChannelPopup.addActionListener((ActionEvent e) -> {
            int channelNum = channelList.getSelectedIndex();
            if (channelNum == -1) {
                channelNum = 0;
            }
            UnmuteChannel unmuteCommand = new UnmuteChannel(channels[channelNum]);
            System.out.println("Channel : " + channelNum);
            ChannelButton muteButton = new ChannelButton(unmuteCommand);
            muteButton.press();
        });
        
        largeTextArea.setColumns(20);
        largeTextArea.setRows(5);
        largeTextAreaPane.setViewportView(largeTextArea);
        
        String initPass[]  = MyProfile.getInstance().getMyAccount().getChannels();
        DataBase database = new DataBase(FILEPATH + initPass[0]+".txt",
        MyProfile.getInstance().getMyAccount().getUserName(),initPass[0],new DBChannelReader());
        database.isValidOperation();
        largeTextArea.setText(ChannelSingleton.getInstance().getChannelText(initPass[0]));
        
        channelList.addMouseListener(new MouseAdapter() { // Edited by GT
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu channelPopup = new JPopupMenu();
                    channelPopup.add(muteChannelPopup);
                    channelPopup.add(unmuteChannelPopup);
                    channelPopup.show(e.getComponent(), e.getX(), e.getY());
                } else{
                   DataBase database = new DataBase(FILEPATH + initPass[channelList.getSelectedIndex()]+".txt",
                   MyProfile.getInstance().getMyAccount().getUserName(),initPass[channelList.getSelectedIndex()],new DBChannelReader());
                   database.isValidOperation();
                    largeTextArea.setText(ChannelSingleton.getInstance().getChannelText(initPass[channelList.getSelectedIndex()]));
                }
            }
        });

        onlineListLabel.setText("Who's Online");

        onlineUsersList.setModel(new javax.swing.AbstractListModel<String>() {
            String test[] = UsersProfiles.getInstance().getOnlineUsers(MyProfile.getInstance().getMyAccount().getUserType());

            @Override
            public int getSize() {
                return UsersProfiles.getInstance().getOnlineUsers(MyProfile.getInstance().getMyAccount().getUserType()).length;
            }

            @Override
            public String getElementAt(int i) {
                return test[i];
            }
        });

        onLineScrollPanel.setViewportView(onlineUsersList);

        addNewChannelButton.setText("Create Channel");
        
        addNewChannelButton.addActionListener((ActionEvent e) -> {
            //add facade option pane to this action listener
        });

       

        textEditPane.setViewportView(editableTextField);

        sendMessageButton.setText("Send Message");

        String currentUser = MyProfile.getInstance().getMyAccount().getUserName();

        sendMessageButton.addActionListener((ActionEvent e) -> {
            String currentChannel;
            //pass it to Dispatcher
            if (channelList.getSelectedIndex() == -1) {
                currentChannel = initPass[0];
            } else {
                currentChannel = initPass[channelList.getSelectedIndex()];
            }
            if (!editableTextField.getText().equals("")) {
                ContextObjectsFactory inceptFact = new ContextObjectsFactory();
                IContextObjects context = inceptFact.getContextObject(currentChannel, editableTextField.getText(), currentUser, "Write");
                dispatch.update(context, 0);
                editableTextField.setText("");
                //change text in the main text field
            }
            //Add a Facade error handling "Trying to Send an empty message"
        });

        updateTextButton.setText("Update Chat");
        
        updateTextButton.addActionListener((ActionEvent e) -> {
                String currentChannel;
                //pass it to Dispatcher
                if (channelList.getSelectedIndex() == -1) {
                    currentChannel = initPass[0];
                } else {
                    currentChannel = initPass[channelList.getSelectedIndex()];
                }
                DataBase databaseUpdate = new DataBase(FILEPATH + currentChannel +".txt",
                MyProfile.getInstance().getMyAccount().getUserName(),currentChannel,new DBChannelReader());
                databaseUpdate.isValidOperation();
                largeTextArea.setText((ChannelSingleton.getInstance().getChannelText(currentChannel)));
                
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(channelScrollPanel)
                                .addComponent(channelTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(onlineListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(onLineScrollPanel)
                                .addComponent(addNewChannelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(largeTextAreaPane)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(textEditPane, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(sendMessageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(updateTextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(channelTypeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(channelScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(onlineListLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(onLineScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addNewChannelButton))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(largeTextAreaPane, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textEditPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(sendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(updateTextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>                        

    @Override
    public void runUI() {
        java.awt.EventQueue.invokeLater(() -> {
            new FlexiableFrame().setVisible(true);
    });
    }

}
