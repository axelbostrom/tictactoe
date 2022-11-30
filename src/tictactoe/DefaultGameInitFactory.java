package tictactoe;

import java.awt.Dimension;
import java.util.List;

import models.Board;
import models.CircleCell;
import models.CrossCell;
import models.Player;
import tictactoe.states.MoveState;
import tictactoe.states.State;
import validators.IMoveValidator;
import validators.ITieValidator;
import validators.IWinValidator;
import validators.TieValidator;

public class DefaultGameInitFactory implements IAbstractGameInitFactory {

	private int boardSize;
	private IWinValidator winValidator;
	private ITieValidator tieValidator;
	private IMoveValidator moveValidator;
	
	public DefaultGameInitFactory(int boardSize, IWinValidator winValidator, ITieValidator tieValidator,
			IMoveValidator moveValidator) {
		super();
		this.boardSize = boardSize;
		this.winValidator = winValidator;
		this.tieValidator = tieValidator;
		this.moveValidator = moveValidator;
	}

	@Override
	public State createStartingState() {
		return new MoveState(tieValidator, winValidator, moveValidator);
	}

	@Override
	public Board createBoard() {
		return new Board(new Dimension(boardSize, boardSize));
	}

	@Override
	public List<Player> createPlayers() {
		return List.of(new Player("Cross player", new CrossCell()), new Player("Circle player", new CircleCell()));
	}

}
