package controllers;

import memento.GameHistory;
import tictactoe.RestorableObservableGameContext;
import ui.GameWindow;

public interface IGameController {

	void play();

	GameWindow getView();

	void setView(GameWindow view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

	GameHistory getGameHistory();

	void setGameHistory(GameHistory gameHistory);

	ISaveController getSaveController();

	void setSaveController(ISaveController saveController);

	IHistoryController getHistoryController();

	void setHistoryController(IHistoryController historyController);

	IBoardController getBoardController();

	void setBoardController(IBoardController boardController);

	IStateMapper getStateMapper();

	void setStateMapper(IStateMapper stateMapper);

}