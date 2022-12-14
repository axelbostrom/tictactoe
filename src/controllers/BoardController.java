package controllers;

import tictactoe.RestorableObservableGameContext;
import ui.BoardPanel;

public class BoardController implements IBoardController {
	
	private BoardPanel view;
	private RestorableObservableGameContext game;
	
	public BoardController() {
	}
	
	@Override
	public void cellSelected(int row, int col) {
		game.makeMove(row, col);
	}

	@Override
	public void updateBoard() {
		view.setBoard(game.getBoard());
	}

	@Override
	public BoardPanel getView() {
		return view;
	}

	@Override
	public void setView(BoardPanel view) {
		this.view = view;
	}

	@Override
	public RestorableObservableGameContext getGame() {
		return game;
	}

	@Override
	public void setGame(RestorableObservableGameContext game) {
		this.game = game;
	}
}
