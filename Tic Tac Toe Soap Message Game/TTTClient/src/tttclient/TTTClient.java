/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttclient;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ajjam_000
 * references from the labs and sample code given in them.
 */
public class TTTClient extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    
    
    private JPanel gameBoard; //panel for the 9 buttons that make up the board
    private JButton [] squares;//buttons represent the individual squares for the board
    private String board [][];//a local array of the board that is on the server
    private JTextArea noticeBoard;//a noticeboard that appears under the game board and displays messages from the server
    private String mark;// the mark the player is using for their game
    private String ipAdd;// ip address for the server
    private int player;// player number
    private int playerTurn;
    private int portNum;// port number for the server
    private Socket socket;// socket object for connection to server
    private PrintWriter out;// printwriter to write info to the server
    private BufferedReader in;// buffered reader to read data from the server
    private boolean GameOver;
    
    //Constructor for the game client, setups the board and Gui when launched
   public TTTClient()
    {
        this.setTitle("Tic Tac Toe");
        this.setBounds(100,100,315,400);
        //this.setPreferredSize(new Dimension(300,500));
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameBoard = new JPanel();
        gameBoard.setBounds(new Rectangle(300, 300));
        gameBoard.setLayout(new GridLayout(3,3));
        squares = new JButton[9];
        mark = " ";
        for(int i=0;i<9;i++) {
            squares[i] = new JButton(mark);
            squares[i].addActionListener(this);
            gameBoard.add(squares[i]);
        }
        noticeBoard = new JTextArea(5,30);
        noticeBoard.setEditable(false);
        this.add(gameBoard);
        this.add(noticeBoard);
        this.setVisible(true);
        board = new String [3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = "null";
        player = 0;
        playerTurn = 1;
        GameOver = false;
        ipAdd = "10.52.243.190"; //"192.168.0.2";
        portNum = 4444; 
        noticeBoard.setText("Connecting to Server:");
        connectToServer();
        setPlayer();
        while(!GameOver)
        {
            checkForBoardUpdate();
        }
        /*if(GameOver)
            System.exit(0);*/
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TTTClient newGUI = new TTTClient();
    }
    //Creates the initial connection between the client and server
    public void connectToServer()
    {
        //tries to setup the socket connection with the server, throws errors if the connection fails
        try {
            socket = new Socket(ipAdd, portNum);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: kq6py.eng");
            System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
            System.exit(1);
        }
        noticeBoard.setText("Connected To Server");
    }
    //after initial connection is made the server sends the players their respective marks
    public void setPlayer()
    {
        try{
            String line = in.readLine();
            mark = line;
            if(mark.equals("X"))
            {
                player = 1;
                noticeBoard.setText("Player 1 you start");
            }
            else if(mark.equals("O"))
            {
                player = 2;
                noticeBoard.setText("Player 2 your turn is next");
            }
        }
        catch (IOException e) {
                System.out.println("Read failed");
                System.exit(1);
        }
    }
    //updateBoard
    public void checkForBoardUpdate()
    {
        int count = 0;
        try{
            String line = in.readLine();
            String [] temp = line.split(" ");
            if(temp[0].equals("UPDATE"))
            {
                if(temp[1].equals("X")){
                    count = 0;
                    for(int i = 0; i < 3; i++)
                        for(int j = 0; j < 3; j++){
                            board[i][j] = temp[count + 2];
                            count++;
                        }
                    
                    if(player == playerTurn)
                        noticeBoard.setText("Its player " + (player == 1 ? 2 : 1) + "'s turn" );
                    else
                        noticeBoard.setText("Its your turn");
                    if(playerTurn == 1)
                        playerTurn = 2;
                    else
                        playerTurn = 1;
                    count = 0;
                    for(int i = 0; i < 3; i++)
                    {
                         for(int j = 0; j < 3; j++)
                         {
                             if(board[i][j].equals("X"))
                                 squares[count].setText("X");
                             else if(board[i][j].equals("O"))
                                 squares[count].setText("O");
                             else if(board[i][j].equals("null"))
                                 squares[count].setText("");
                             count++;
                         }
                    }
                    GameOver = checkBoard();
                    
                }
                else if(temp[1].equals("O")){
                    count = 0;
                    for(int i = 0; i < 3; i++)
                        for(int j = 0; j < 3; j++){
                            board[i][j] = temp[count + 2];
                            count++;
                        }
                    
                    if(player == playerTurn)
                        noticeBoard.setText("Its player " + (player == 1 ? 2 : 1) + "'s turn" );
                    else
                        noticeBoard.setText("Its your turn");
                    
                    if(playerTurn == 1)
                        playerTurn = 2;
                    else
                        playerTurn = 1;
                    
                    count = 0;
                    for(int i = 0; i < 3; i++)
                    {
                         for(int j = 0; j < 3; j++)
                         {
                             if(board[i][j].equals("X"))
                                 squares[count].setText("X");
                             else if(board[i][j].equals("O"))
                                 squares[count].setText("O");
                             else if(board[i][j].equals("null"))
                                 squares[count].setText("");
                             count++;
                         }
                    }
                    GameOver = checkBoard();
                }
            }
        }
        catch (IOException e) {
                System.out.println("Read failed");
                System.exit(1);
        }
    }
    public boolean checkBoard(){
        String player1Mark = "X", player2Mark = "O", space = " ";
        if( player1Mark.equals(board[0][0]) && player1Mark.equals(board[0][1]) && player1Mark.equals(board[0][2]) ||
            player1Mark.equals(board[1][0]) && player1Mark.equals(board[1][1]) && player1Mark.equals(board[1][2]) ||
            player1Mark.equals(board[2][0]) && player1Mark.equals(board[2][1]) && player1Mark.equals(board[2][2]) ||
            player1Mark.equals(board[0][0]) && player1Mark.equals(board[1][0]) && player1Mark.equals(board[2][0]) ||
            player1Mark.equals(board[0][1]) && player1Mark.equals(board[1][1]) && player1Mark.equals(board[2][1]) ||
            player1Mark.equals(board[0][2]) && player1Mark.equals(board[1][2]) && player1Mark.equals(board[2][2]) ||
            player1Mark.equals(board[0][0]) && player1Mark.equals(board[1][1]) && player1Mark.equals(board[2][2]) ||
            player1Mark.equals(board[0][2]) && player1Mark.equals(board[1][1]) && player1Mark.equals(board[2][0])){
            noticeBoard.setText("Player 1 Wins");
            return true;
        }
        
        else if(player2Mark.equals(board[0][0]) && player2Mark.equals(board[0][1]) && player2Mark.equals(board[0][2]) ||
                player2Mark.equals(board[1][0]) && player2Mark.equals(board[1][1]) && player2Mark.equals(board[1][2]) ||
                player2Mark.equals(board[2][0]) && player2Mark.equals(board[2][1]) && player2Mark.equals(board[2][2]) ||
                player2Mark.equals(board[0][0]) && player2Mark.equals(board[1][0]) && player2Mark.equals(board[2][0]) ||
                player2Mark.equals(board[0][1]) && player2Mark.equals(board[1][1]) && player2Mark.equals(board[2][1]) ||
                player2Mark.equals(board[0][2]) && player2Mark.equals(board[1][2]) && player2Mark.equals(board[2][2]) ||
                player2Mark.equals(board[0][0]) && player2Mark.equals(board[1][1]) && player2Mark.equals(board[2][2]) ||
                player2Mark.equals(board[0][2]) && player2Mark.equals(board[1][1]) && player2Mark.equals(board[2][0])){
            noticeBoard.setText("Player 2 Wins");
            return true;
        }
        else {
            boolean foundSpace = true;
            for(int i = 0; i < 3 && foundSpace; i++){
                for(int j = 0; j < 3 && foundSpace; j++){
                    if(board[i][j].equals("null")){
                        foundSpace = false;
                    }
                    }
                }
           if(foundSpace == true){
                noticeBoard.setText("It's a Draw");
                return foundSpace;
            }
        }
        return false;
     }              
    //called when a button is pressed sends the info to the server and updates the local board
    public void makeMove(int player ,int row , int col)
    {
        if(player != playerTurn)
        {
            noticeBoard.setText("It's not your turn");            
        }
        else
        {
            if(board[row][col].equals("X") || board[row][col].equals("O"))
            {
                noticeBoard.setText("Square Taken");
            }
            else 
            {
                String line = row + " " + col;
                out.println(line);
                if(player == 1){
                    board[row][col] = "X";   
                }
                else if(player == 2){
                    board[row][col] = "O";
                }
                
                int count = 0;
                for(int i = 0; i < 3; i++)
                    {
                         for(int j = 0; j < 3; j++)
                         {
                             if(board[i][j].equals("X"))
                                 squares[count].setText("X");
                             else if(board[i][j].equals("O"))
                                 squares[count].setText("O");
                             else if(board[i][j].equals("null"))
                                 squares[count].setText("");
                             count++;
                         }
                    }
            }
    }
}

    //actionlistener for the buttons calls the make move method when buttons are pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source.equals(squares[0])) {
            makeMove(player, 0, 0);
        }
        
        if(source.equals(squares[1])) {
            makeMove(player, 0, 1);
        }

        if(source.equals(squares[2])) {
            makeMove(player, 0, 2);
        }

        if(source.equals(squares[3])) {
            makeMove(player, 1, 0);
        }

        if(source.equals(squares[4])) {
            makeMove(player, 1, 1);
        }

        if(source.equals(squares[5])) {
            makeMove(player, 1, 2);
        }

        if(source.equals(squares[6])) {
            makeMove(player, 2, 0);
        }

        if(source.equals(squares[7])) {
            makeMove(player, 2, 1);
        }

        if(source.equals(squares[8])) {
            makeMove(player, 2, 2);
        }
    }
    
}
