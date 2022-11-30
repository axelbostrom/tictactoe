package controllers;

import memento.GameStateHistory;
import tictactoe.Game;
import tictactoe.RestorableObservableGameContext;
import ui.GameWindow;

public interface IGameController {

	void play();

	GameWindow getView();

	void setView(GameWindow view);

	RestorableObservableGameContext getGame();

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