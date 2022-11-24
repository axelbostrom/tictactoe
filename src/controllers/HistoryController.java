package controllers;

import java.util.ArrayList;
import java.util.List;

import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observable;
import tictactoe.Observer;
import ui.HistoryPanel;

public class HistoryController implements Observable {

	private HistoryPanel view;
	private Game game;
	private GameStateHistory gameStateHistory;
	private GameState gameState;
	private List<Observer> subscribers;

	public HistoryController() {
		subscribers = new ArrayList<Observer>();
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
		setGameState(gameStateHistory.getPreviousGameState());
	}

	public void redo() {
		setGameState(gameStateHistory.getNextGameState());
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
		notifySubscribers();
	}

	@Override
	public void notifySubscribers() {
		subscribers.forEach(observer -> observer.update(this));

	}

	@Override
	public void addSubscriber(Observer observer) {
		subscribers.add(observer);

	}

	@Override
	public void removeSubscriber(Observer observer) {
		subscribers.remove(observer);

	}
}
