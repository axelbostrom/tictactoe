package controllers;

import memento.GameState;
import memento.GameStateHistory;
import observer.Observable;
import tictactoe.RestorableObservableGameContext;
import ui.HistoryPanel;

public interface IHistoryController extends Observable{

	HistoryPanel getView();

	void setView(HistoryPanel view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

	GameStateHistory getGameStateHistory();

	void setGameStateHistory(GameStateHistory gameStateHistory);

	void undo();

	void redo();

	GameState getGameState();

	void setGameState(GameState gameState);

	void newGame();

}