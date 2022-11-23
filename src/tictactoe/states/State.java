package tictactoe.states;

import java.io.Serializable;

import tictactoe.GameContext;

public interface State extends Serializable{
	
	public void makeMove(GameContext context, int row, int col);

}
