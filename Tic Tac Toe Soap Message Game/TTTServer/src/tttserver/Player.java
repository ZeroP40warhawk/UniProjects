package tttserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

 

public class Player implements Runnable {
	private final Socket socket;//creates local socket object for the player
	private final BufferedReader in;//creates local reader and writer for the player ensuring all their data passes through this object
	private final PrintWriter out;
	private final String mark;//players mark for the game
	private final TicTacToe game;//creates local game object that links both players to the one board
	private Player opponent;//sets the players opponent

        //constructs the initial player object and returns to the client the mark the player will be using
	public Player(Socket socket, String mark, TicTacToe game) throws IOException {
		this.socket = socket;
		this.mark = mark;
		this.game = game;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
                out.println(mark);
	}

        //sets up the thread and what it will be doing for the duration of the game. 
        //the thread will constantly listen for inputs and handle those requests based on the input and respond accordingly
        //any errors are thrown and and caught 
	@Override
	public void run() {
		String input;
		try {
			while ((input = in.readLine()) != null) {
				if (game.isOnTurn(this))
					handleRequest(input);
			}
		} 
                catch (IOException e) {
			e.printStackTrace();
		} 
                finally {
			try { socket.close(); } catch (IOException e) {}
		}
		
	}

        //takes the input from the player and checks whether the move is valid and checks the state of the board
        //returns the state of the board and whether either player has won lost or drew the match
	private void handleRequest(String input) {
		String pos[] = new String [2];
                pos = input.split(" ");
     
                int row = Integer.parseInt(pos[0]);
                int col = Integer.parseInt(pos[1]);
		
		if (game.makeMove(row, col, this)) {
			getOpponent().printBoard();
                        
			printBoard();
			if (game.isWinning(this)) {
				winning();
				getOpponent().loosing();
			} else {
				if (game.tie()) {
					tie();
					getOpponent().tie();
				} else {
					game.setOnTurn(getOpponent());
				}
			}
		}
	}
	//if there is a tie message sent to both clients and new game is started
	private void tie() {
		out.println("DRAW");
		newGame();
	}
        //if the player looses client is notified
	private void loosing() {
		out.println("LOSE");
		newGame();
	}
        //if the player wins the client is notified
	private void winning() {
		out.println("WIN");
		newGame();
	}
        //starts a new game 
	private void newGame() {
		game.reset();
		letsPlay();
	}
        // sends out the initial board to each player
	private void letsPlay() {
		out.println("");
		printBoard();
		/*if (game.isOnTurn(this)) {
			out.println("You are on turn! Enter box number:");
		} else {
			out.println("It's opponent's turn. Please, wait!");
		}*/
	}
	//returns the mark the player is using
	public String getMark() {
		return mark;
	}
	
	public synchronized PrintWriter getOut() {
		return out;
	}
	//returns the players opponent
	public synchronized Player getOpponent() {
		return opponent;
	}
	//sets the players opponent for the game
	public synchronized void setOpponent(Player player) {
		this.opponent = player;
	}
        //prints the board and outputs it to the client
	private void printBoard() {
		out.println("UPDATE " + (getMark()) + " " + game.printBoard());
	}


}

