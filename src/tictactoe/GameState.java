package tictactoe;

import java.io.Serializable;

import tictactoe.states.State;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1758190585875527115L;
	private Board currBoard;
	private Player currPlayer;
	private State currState;

	public GameState(Board currBoard, Player currPlayer, State currState) {
		this.currBoard = currBoard;
		this.currPlayer = currPlayer;
		this.currState = currState;
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

	public State getCurrState() {
		return currState;
	}

	public void setCurrState(State currState) {
		this.currState = currState;
	}

}
