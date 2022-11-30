package controllers;

import tictactoe.Game;
import ui.BoardPanel;

public interface IBoardController {

	void cellSelected(int row, int col);

	void updateBoard();

	BoardPanel getView();

	void setView(BoardPanel view);

	Game getGame();

	void setGame(Game game);

}