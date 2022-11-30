package controllers;

import memento.GameStateHistory;
import tictactoe.RestorableObservableGameContext;
import ui.GameWindow;

public interface IGameController {

	void play();

	GameWindow getView();

	void setView(GameWindow view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

	GameStateHistory getGameStateHistory();

	void setGameStateHistory(GameStateHistory gameStateHistory);

	ISaveController getSaveController();

	void setSaveController(ISaveController saveController);

	IHistoryController getHistoryController();

	void setHistoryController(IHistoryController historyController);

	IBoardController getBoardController();

	void setBoardController(IBoardController boardController);

	IStateMapper getStateMapper();

	void setStateMapper(IStateMapper stateMapper);

}