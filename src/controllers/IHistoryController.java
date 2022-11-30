package controllers;

import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observable;
import ui.HistoryPanel;

public interface IHistoryController extends Observable{

	HistoryPanel getView();

	void setView(HistoryPanel view);

	Game getGame();

	void setGame(Game game);

	GameStateHistory getGameStateHistory();

	void setGameStateHistory(GameStateHistory gameStateHistory);

	void undo();

	void redo();

	GameState getGameState();

	void setGameState(GameState gameState);

	void newGame();

}