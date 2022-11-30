package controllers;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import models.CircleCell;
import models.CrossCell;
import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observable;
import tictactoe.Observer;
import tictactoe.Player;
import tictactoe.states.MoveState;
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
		game.restore(getGameState());
		notifySubscribers();
	}

	public void redo() {
		setGameState(gameStateHistory.getNextGameState());
		game.restore(getGameState());
		notifySubscribers();
	}

	public GameState getGameState() {
		return gameState;
	}

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

	public void newGame() {
		initializeNewGame();
		notifySubscribers();
	}

	private void notifySubscribers() {
		subscribers.forEach(observer -> observer.update());
	}
	
	private void initializeNewGame() {
		game.setPlayers(
				List.of(new Player("Cross player", new CrossCell()), new Player("Circle player", new CircleCell())));
		game.restore(new GameState(new Board(new Dimension(3, 3)), game.getPlayers().get(0), new MoveState()));

		gameStateHistory.clear();
		gameStateHistory.addGameState(game.createMemento());
	}
}
