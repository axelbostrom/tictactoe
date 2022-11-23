package tictactoe.states;

import models.Move;
import tictactoe.GameContext;
import validators.MoveValidator;
import validators.TieValidator;
import validators.WinValidator;

public class WinState implements State {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2478010770933178850L;

	public WinState() {
	}

	@Override
	public void makeMove(GameContext context, int row, int col) {
		
	}

}
