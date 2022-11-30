package controllers;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import memento.GameState;
import memento.GameStateHistory;
import models.Board;
import models.CircleCell;
import models.CrossCell;
import models.Player;
import observer.Observer;
import tictactoe.IAbstractGameInitFactory;
import tictactoe.RestorableObservableGameContext;
import tictactoe.states.MoveState;
import ui.HistoryPanel;

public class HistoryController implements IHistoryController {

	private HistoryPanel view;
	private RestorableObservableGameContext game;
	private GameStateHistory gameStateHistory;
	private GameState gameState;
	private List<Observer> subscribers;
	private IAbstractGameInitFactory gameInitFactory;

	public HistoryController() {
		subscribers = new ArrayList<Observer>();
	}

	@Override
	public HistoryPanel getView() {
		return view;
	}

	@Override
	public void setView(HistoryPanel view) {
		this.view = view;
	}

	@Override
	public RestorableObservableGameContext getGame() {
		return game;
	}

	@Override
	public void setGame(RestorableObservableGameContext game) {
		this.game = game;
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
	public void undo() {
		setGameState(gameStateHistory.getPreviousGameState());
		game.restore(getGameState());
		notifySubscribers();
	}

	@Override
	public void redo() {
		setGameState(gameStateHistory.getNextGameState());
		game.restore(getGameState());
		notifySubscribers();
	}

	@Override
	public GameState getGameState() {
		return gameState;
	}

	@Override
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void addSubscriber(Observer observer) {
		subscribers.add(observer);

	}

	@Override
	public void removeSubscriber(Observer observer) {
		subscribers.remove(observer);

	}

	@Override
	public void newGame() {
		initializeNewGame();
		notifySubscribers();
	}

	private void notifySubscribers() {
		subscribers.forEach(observer -> observer.update());
	}
	
	private void initializeNewGame() {
		game.setPlayers(gameInitFactory.createPlayers());
		GameState startGameState = new GameState(gameInitFactory.createBoard(), game.getPlayers().get(0), gameInitFactory.createStartingState());
		game.restore(startGameState);

		gameStateHistory.clear();
		gameStateHistory.addGameState(game.createMemento());
	}

	public IAbstractGameInitFactory getGameInitFactory() {
		return gameInitFactory;
	}

	public void setGameInitFactory(IAbstractGameInitFactory gameInitFactory) {
		this.gameInitFactory = gameInitFactory;
	}
	
	
}
