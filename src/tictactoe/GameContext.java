package tictactoe;

import java.util.List;

import tictactoe.states.State;

public interface GameContext {
	public void setState(State newState);

	public Board getBoard();

	public void setBoard(Board board);

	public Player getCurrentPlayer();

	public Player getNextPlayer();

	public void setCurrentPlayer(Player newPlayer);
}
