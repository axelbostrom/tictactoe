package tictactoe.states;

import models.Move;
import tictactoe.Board;
import tictactoe.GameContext;
import validators.MoveValidator;
import validators.TieValidator;
import validators.WinValidator;

public class MoveState implements State {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8357350819011989051L;
	
	private TieValidator tieValidator;
	private WinValidator winValidator;
	private MoveValidator moveValidator;
	
	public MoveState() {
		this.tieValidator = new TieValidator();
		this.winValidator = new WinValidator();
		this.moveValidator = new MoveValidator();
	}

	@Override
	public void makeMove(GameContext context, int row, int col) {
		if (moveValidator.test(context.getBoard(), new Move(row, col))) {
			Board newBoard = new Board(context.getBoard());
			newBoard.setCell(row, col, context.getCurrentPlayer().getCell());

			context.setBoard(newBoard);
			
			if (winValidator.test(newBoard)) {
				handleWin(context);
			} else {
				if (tieValidator.test(newBoard)) {
					handleTie(context);
				} else {
					context.setCurrentPlayer(context.getNextPlayer());
					context.setState(new MoveState());
				}
			}
		}
	}
	
	private void handleWin(GameContext context) {
		context.setState(new WinState());
	}
	
	private void handleTie(GameContext context) {
		context.setState(new TieState());
	}
	

}
