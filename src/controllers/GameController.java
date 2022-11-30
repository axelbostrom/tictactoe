package controllers;

import memento.GameStateHistory;
import tictactoe.Game;
import tictactoe.RestorableObservableGameContext;
import ui.GameWindow;

public class GameController implements IGameController {

	private GameWindow view;
	private RestorableObservableGameContext game;
	private GameStateHistory gameStateHistory;
	private ISaveController saveController;
	private IHistoryController historyController;
	private IBoardController boardController;
	private IStateMapper stateMapper;

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
		view.setState(stateMapper.map(game.getState()));
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
	public RestorableObservableGameContext getGame() {
		return game;
	}

	@Override
	public void setGame(RestorableObservableGameContext game) {
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
	public void setSaveController(ISaveController saveController) {
		this.saveController = saveController;
		saveController.addSubscriber(this::updateUI);
	}

	@Override
	public IHistoryController getHistoryController() {
		return historyController;
	}

	@Override
	public void setHistoryController(IHistoryController historyController) {
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

	public IStateMapper getStateMapper() {
		return stateMapper;
	}

	public void setStateMapper(IStateMapper stateMapper) {
		this.stateMapper = stateMapper;
	}
	
}
