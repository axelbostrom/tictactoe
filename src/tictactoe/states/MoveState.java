package tictactoe.states;

import models.Board;
import models.Move;
import tictactoe.GameContext;
import validators.IMoveValidator;
import validators.ITieValidator;
import validators.IWinValidator;

public class MoveState implements State {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8357350819011989051L;

	private ITieValidator tieValidator;
	private IWinValidator winValidator;
	private IMoveValidator moveValidator;

	public MoveState(ITieValidator tieValidator, IWinValidator winValidator, IMoveValidator moveValidator) {
		super();
		this.tieValidator = tieValidator;
		this.winValidator = winValidator;
		this.moveValidator = moveValidator;
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
					context.setState(new MoveState(tieValidator, winValidator, moveValidator));
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
