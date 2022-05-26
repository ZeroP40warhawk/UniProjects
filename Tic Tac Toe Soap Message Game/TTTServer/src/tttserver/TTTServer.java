/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author ajjam_000
 * https://github.com/ivailozd/TicTacToe
 * code referenced from this site for the 3 classes in TTTServer package
 * 
 */
public class TTTServer {

    /**
     * @param args the command line arguments
     */
    private ServerSocket server = null;//server socket object that creates the initial server
    private final String ON_START_MESSAGE;// start message when server first starts
    private final int port = 4444;//port number the server is listening on

    
    public static void main(String[] args) {
        // TODO code application logic here
        new TTTServer().start();//new server object created and started
        
    }
    //server constructor displays message to which port it listens on
    public TTTServer() {
        this.ON_START_MESSAGE = "TicTacToeServer is listening on port " + port + "...";
    }
    
    private void start() {
		try {
			server = new ServerSocket(port);
			System.out.println(ON_START_MESSAGE);
			while (true) {
				TicTacToe game = new TicTacToe();// object of type game created to maintain a board between two players
				Player player1 = new Player(server.accept(), "X", game);//threaded player object created
				Player player2 = new Player(server.accept(), "O", game);//second threaded player object created both take game object which maintains a board between those two players
				player1.setOpponent(player2);//sets each players opponents
				player2.setOpponent(player1);
				game.setOnTurn(player1);//sets which player starts in the game object
				new Thread(player1).start();// starts the thread for each player
				new Thread(player2).start();
			}
		} catch (IOException e) { 
			e.printStackTrace(); 
		} finally {
			try { server.close(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
    
}