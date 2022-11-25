package tictactoe.states;

import models.Move;
import tictactoe.GameContext;
import validators.MoveValidator;
import validators.TieValidator;
import validators.WinValidator;

public class TieState implements State {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3001329675062934185L;

	public TieState() {
	}

	@Override
	public void makeMove(GameContext context, int row, int col) {

	}

}
