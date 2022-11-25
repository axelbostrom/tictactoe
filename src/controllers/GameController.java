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
import ui.GameWindow;
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
		saveController = new SaveController();

		historyController = new HistoryController();

		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		view = new GameWindow(savePanel, historyPanel);

		saveController.setView(savePanel);
		historyController.setView(historyPanel);

		initializeNewGame();

		historyController.addSubscriber(this::updateBoard);
		game.addSubscriber(this::moveMade);
		saveController.addSubscriber(this::loadOldGame);
		view.addSubscriber(this::cellSelected);
	}

	public SaveController getSaveController() {
		return saveController;
	}

	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
	}

	public void cellSelected(String string, Object o) {
		game.makeMove(view.getRow(), view.getCol());
	}

	private void moveMade(String string, Object o) {
		gameStateHistory.addGameState(game.createMemento());
		view.setBoard(game.getBoard(), game.getCurrentPlayer().getName());
	}

	private void loadOldGame(String string, Object o) {
		game.restore(saveController.getGameState());
		game.setPlayers(saveController.getGame().getPlayers());
		view.setBoard(game.getBoard(), game.getCurrentPlayer().getName());
	}

	private void updateBoard(String string, Object object) {
		if (string == "redo" || string == "undo") {
			game.restore(historyController.getGameState());
			view.setBoard(game.getBoard(), game.getCurrentPlayer().getName());
		} else if (string == "newGame") {
			initializeNewGame();
		}
	}

	private void initializeNewGame() {
		game = new Game();

		game.setPlayers(
				List.of(new Player("Cross player", new CrossCell()), new Player("Circle player", new CircleCell())));
		game.restore(new GameState(new Board(new Dimension(3, 3)), game.getPlayers().get(0), new MoveState()));

		gameStateHistory = new GameStateHistory(game.createMemento());

		view.setBoard(game.getBoard(), game.getCurrentPlayer().getName());

		historyController.setGame(game);
		historyController.setGameStateHistory(gameStateHistory);

		saveController.setGame(game);
		saveController.setGameStateHistory(gameStateHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());

	}

}
