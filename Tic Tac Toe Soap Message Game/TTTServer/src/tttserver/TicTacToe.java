/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttserver;

/**
 *
 * @author ajjam_000
 */
public class TicTacToe {
    
private final String[][] board = new String[3][3];//string array used to keep track of used and unused spaces on the board
	private Player currentPlayer;//current player that is allowed to use the board

        //returns the boards current state 
	public String printBoard() {
            String line = "";
		for(int i = 0; i < 3; i++)
                    for(int j = 0; j < 3;j++)
                        line += board[i][j] + " ";
		return line;
	}
        //allows a player to make their move providing they are the current player
        //synchronized used to lock the board variable so no other thread can change it while its in use
	public boolean makeMove(int row, int col, Player player) {
		synchronized (this) {
			if (player != currentPlayer)
				return false;
		}
		synchronized (board) {
			if (board[row][col] == null) {
				board[row][col] = player.getMark();
				return true;
			}
		}
			
		return false;
	}
	//checks if the player is winning and returns true or false
	public boolean isWinning(Player player) {
		String mark = player.getMark();
		boolean isWinning = false;
                //checks the state of the board
		synchronized (board) {
			isWinning = 
					mark.equals(board[0][0]) && mark.equals(board[0][1]) && mark.equals(board[0][2]) ||
					mark.equals(board[1][0]) && mark.equals(board[1][1]) && mark.equals(board[1][2]) ||
					mark.equals(board[2][0]) && mark.equals(board[2][1]) && mark.equals(board[2][2]) ||
					mark.equals(board[0][0]) && mark.equals(board[1][0]) && mark.equals(board[2][0]) ||
					mark.equals(board[0][1]) && mark.equals(board[1][1]) && mark.equals(board[2][1]) ||
					mark.equals(board[0][2]) && mark.equals(board[1][2]) && mark.equals(board[2][2]) ||
					mark.equals(board[0][0]) && mark.equals(board[1][1]) && mark.equals(board[2][2]) ||
					mark.equals(board[0][2]) && mark.equals(board[1][1]) && mark.equals(board[2][0]);
		}
		
		return isWinning;
				
	}
        //checks if the player accessing the method, if its their turn
	public synchronized boolean isOnTurn(Player player) {
		if (currentPlayer == player)
			return true;
			
		return false;
	}
	//sets the starting player for the game
	public synchronized void setOnTurn(Player player) {
		if (currentPlayer != null) {
			currentPlayer.getOut().println("Nice! Now waiting for the opponent's turn...");
			this.currentPlayer = player;
			currentPlayer.getOut().println("You are on turn! Enter box number:");
		} else {
			currentPlayer = player;
		}
	}
        //resets the board for both players
	public void reset() {
		synchronized (board) {
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board.length; j++) {
					board[i][j] = null;
				}
			}
		}
		
	}
        //checks if there is a tie on the board
	public boolean tie() {
		synchronized (board) {
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == null) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

}