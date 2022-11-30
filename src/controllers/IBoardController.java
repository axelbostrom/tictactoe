package controllers;

import tictactoe.Game;
import tictactoe.RestorableObservableGameContext;
import ui.BoardPanel;

public interface IBoardController {

	void cellSelected(int row, int col);

	void updateBoard();

	BoardPanel getView();

	void setView(BoardPanel view);

	RestorableObservableGameContext getGame();

	void setGame(Game game);

}