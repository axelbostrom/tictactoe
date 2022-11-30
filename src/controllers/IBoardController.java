package controllers;

import tictactoe.RestorableObservableGameContext;
import ui.BoardPanel;

public interface IBoardController {

	void cellSelected(int row, int col);

	void updateBoard();

	BoardPanel getView();

	void setView(BoardPanel view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

}