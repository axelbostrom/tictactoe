package controllers;

import java.util.ArrayList;
import java.util.List;

import memento.GameMemento;
import memento.GameHistory;
import observer.Observer;
import tictactoe.IAbstractGameInitFactory;
import tictactoe.RestorableObservableGameContext;
import ui.HistoryPanel;

public class HistoryController implements IHistoryController {

	private HistoryPanel view;
	private RestorableObservableGameContext game;
	private GameHistory gameHistory;
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
	public GameHistory getGameHistory() {
		return gameHistory;
	}

	@Override
	public void setGameHistory(GameHistory gameHistory) {
		this.gameHistory = gameHistory;
	}

	@Override
	public void undo() {
		game.restore(gameHistory.getPreviousSnapshot());
		notifySubscribers();
	}

	@Override
	public void redo() {
		game.restore(gameHistory.getNextSnapshot());
		notifySubscribers();
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
		GameMemento startMemento = new GameMemento(gameInitFactory.createBoard(), game.getPlayers().get(0),
				gameInitFactory.createStartingState());
		game.restore(startMemento);

		gameHistory.clear();
		gameHistory.addSnapshot(game.createMemento());
	}

	public IAbstractGameInitFactory getGameInitFactory() {
		return gameInitFactory;
	}

	public void setGameInitFactory(IAbstractGameInitFactory gameInitFactory) {
		this.gameInitFactory = gameInitFactory;
	}

}
