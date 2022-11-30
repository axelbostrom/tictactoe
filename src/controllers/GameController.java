package controllers;

import java.awt.Dimension;
import java.util.List;

import models.CircleCell;
import models.CrossCell;
import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Player;
import tictactoe.states.MoveState;
import tictactoe.states.TieState;
import tictactoe.states.WinState;
import ui.GameWindow;
import ui.GameWindowState;
import ui.HistoryPanel;
import ui.SavePanel;
import tictactoe.GameSaveRepository;

public class GameController {

	private GameWindow view;
	private Game game;
	private GameStateHistory gameStateHistory;
	private SaveController saveController;
	private HistoryController historyController;

	public GameController() {
		/*saveController = new SaveController();

		historyController = new HistoryController();

		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		view = new GameWindow(savePanel, historyPanel);
		
		game = new Game();
		gameStateHistory = new GameStateHistory();

		saveController.setView(savePanel);
		historyController.setView(historyPanel);

		historyController.setGame(game);
		historyController.setGameStateHistory(gameStateHistory);

		saveController.setGame(game);
		saveController.setGameStateHistory(gameStateHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());

		historyController.addSubscriber(this::updateBoard);
		game.addSubscriber(this::moveMade);
		saveController.addSubscriber(this::updateBoard);
		
		historyController.newGame();*/
	}
	
	public void play() {
		historyController.newGame();
	}

	public void cellSelected(int row, int col) {
		game.makeMove(row, col);
	}

	private void moveMade() {
		gameStateHistory.addGameState(game.createMemento());
		view.setBoard(game.getBoard());
		view.setPlayer(game.getCurrentPlayer());
		updateUiState();
	}
	
	private void updateUiState() {
		if (game.getState().getClass().equals(MoveState.class)) {
			view.setState(GameWindowState.MOVE);
		} else if (game.getState().getClass().equals(TieState.class)) {
			view.setState(GameWindowState.TIE);
		} else if (game.getState().getClass().equals(WinState.class)) {
			view.setState(GameWindowState.WIN);
		}
	}
	private void updateBoard() {
			
		view.setBoard(game.getBoard());
		view.setPlayer(game.getCurrentPlayer());
		
		updateUiState();
	}

	public GameWindow getView() {
		return view;
	}

	public void setView(GameWindow view) {
		this.view = view;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
		game.addSubscriber(this::moveMade);
	}

	public GameStateHistory getGameStateHistory() {
		return gameStateHistory;
	}

	public void setGameStateHistory(GameStateHistory gameStateHistory) {
		this.gameStateHistory = gameStateHistory;
	}

	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
		saveController.addSubscriber(this::updateBoard);
	}

	public HistoryController getHistoryController() {
		return historyController;
	}

	public void setHistoryController(HistoryController historyController) {
		this.historyController = historyController;
		historyController.addSubscriber(this::updateBoard);
	}

	
}
