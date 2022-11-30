package controllers;

import tictactoe.Game;
import tictactoe.GameStateHistory;
import tictactoe.states.MoveState;
import tictactoe.states.TieState;
import tictactoe.states.WinState;
import ui.GameWindow;
import ui.GameWindowState;

public class GameController implements IGameController {

	private GameWindow view;
	private Game game;
	private GameStateHistory gameStateHistory;
	private ISaveController saveController;
	private HistoryController historyController;
	private IBoardController boardController;

	public GameController() {
	}
	
	@Override
	public void play() {
		historyController.newGame();
	}

	private void moveMade() {
		gameStateHistory.addGameState(game.createMemento());
		updateUI();
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
	private void updateUI() {
		boardController.updateBoard();
		view.setPlayer(game.getCurrentPlayer());
		updateUiState();
	}

	@Override
	public GameWindow getView() {
		return view;
	}

	@Override
	public void setView(GameWindow view) {
		this.view = view;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
		game.addSubscriber(this::moveMade);
	}

	@Override
	public GameStateHistory getGameStateHistory() {
		return gameStateHistory;
	}

	@Override
	public void setGameStateHistory(GameStateHistory gameStateHistory) {
		this.gameStateHistory = gameStateHistory;
	}

	@Override
	public ISaveController getSaveController() {
		return saveController;
	}

	@Override
	public void setSaveController(SaveController saveController) {
		this.saveController = saveController;
		saveController.addSubscriber(this::updateUI);
	}

	@Override
	public IHistoryController getHistoryController() {
		return historyController;
	}

	@Override
	public void setHistoryController(HistoryController historyController) {
		this.historyController = historyController;
		historyController.addSubscriber(this::updateUI);
	}

	@Override
	public IBoardController getBoardController() {
		return boardController;
	}

	@Override
	public void setBoardController(IBoardController boardController) {
		this.boardController = boardController;
		historyController.addSubscriber(this::updateUI);
	}

	
	
}
