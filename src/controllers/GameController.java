package controllers;

import java.awt.Dimension;
import java.util.List;
import java.util.Observable;

import models.CircleCell;
import models.CrossCell;
import models.Move;
import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.ObservableGame;
import tictactoe.Player;
import tictactoe.states.MoveState;
import ui.GameWindow;
import ui.HistoryPanel;
import ui.SavePanel;
import validators.MoveValidator;
import validators.WinValidator;
import tictactoe.GameSave;
import tictactoe.GameSaveRepository;

public class GameController {
	
	private GameWindow view;
	private Game game;
	private GameStateHistory gameStateHistory;
	private SaveController saveController;
	private HistoryController historyController;
	
	public GameController() {
		saveController = new SaveController(this);
		
		historyController = new HistoryController(this);
		
		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		view = new GameWindow(this, savePanel, historyPanel);
		game = new Game();
		
		saveController.setView(savePanel);
		historyController.setView(historyPanel);
		
		game.setPlayers(List.of(new Player("Player 1", new CrossCell()), new Player("Player 2", new CircleCell())));
		game.restore(new GameState(new Board(new Dimension(3, 3)), game.getPlayers().get(0), new MoveState()));
		view.setBoard(game.getBoard());
		gameStateHistory = new GameStateHistory(game.createMemento());
		
		historyController.setGame(game);
		historyController.setGameStateHistory(gameStateHistory);

		saveController.setGame(game);
		saveController.setGameStateHistory(gameStateHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());
		
		game.addSubscriber(this::moveMade);
	}
	
	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
	}

	public void cellSelected(int row, int col) {
		game.makeMove(row, col);
	}
	
	private void moveMade(Game game) {
		gameStateHistory.addGameState(game.createMemento());
		view.setBoard(game.getBoard());
	}
	
	public void boardUpdated() {
		view.setBoard(game.getBoard());
	}
	
	
 }
