package tictactoe;

import tictactoe.states.State;

public interface GameContext {
	public void setState(State newState);

	public void makeMove(int row, int col);

	public Board getBoard();

	public void setBoard(Board board);

	public Player getCurrentPlayer();

	public Player getNextPlayer();

	public void setCurrentPlayer(Player newPlayer);
}
