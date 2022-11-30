package controllers;

import tictactoe.Game;
import tictactoe.GameStateHistory;
import ui.GameWindow;

public interface IGameController {

	void play();

	GameWindow getView();

	void setView(GameWindow view);

	Game getGame();

	void setGame(Game game);

	GameStateHistory getGameStateHistory();

	void setGameStateHistory(GameStateHistory gameStateHistory);

	ISaveController getSaveController();

	void setSaveController(SaveController saveController);

	IHistoryController getHistoryController();

	void setHistoryController(HistoryController historyController);

	IBoardController getBoardController();

	void setBoardController(IBoardController boardController);

}