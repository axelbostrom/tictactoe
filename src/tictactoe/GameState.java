package tictactoe;

import java.io.Serializable;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758190585875527115L;
	Board currBoard;
    Player currPlayer;
    //Winvalidator
    
    public GameState(Board currBoard, Player currPlayer) {
        this.currBoard = currBoard;
        this.currPlayer = currPlayer;
    }

    public Board getCurrBoard() {
        return currBoard;
    }
    public void setCurrBoard(Board currBoard) {
        this.currBoard = currBoard;
    }
    public Player getCurrPlayer() {
        return currPlayer;
    }
    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

}
