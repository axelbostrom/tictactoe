package controllers;

import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import ui.HistoryPanel;

public class HistoryController {

	private HistoryPanel view;
	private Game game;
	private GameStateHistory gameStateHistory;
	private GameController gameController; //dependency should be inverted
	
	public HistoryController(GameController parent) {
		gameController = parent;
	}
	
	public HistoryPanel getView() {
		return view;
	}

	public void setView(HistoryPanel view) {
		this.view = view;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameStateHistory getGameStateHistory() {
		return gameStateHistory;
	}

	public void setGameStateHistory(GameStateHistory gameStateHistory) {
		this.gameStateHistory = gameStateHistory;
	}

	public void undo() {
		GameState prevGameState = gameStateHistory.getPreviousGameState();
		game.restore(prevGameState);
		gameController.boardUpdated();
	}
	
	public void redo() {
		GameState nextGameState = gameStateHistory.getNextGameState();
		game.restore(nextGameState);
		gameController.boardUpdated();
	}
}
