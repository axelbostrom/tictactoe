package controllers;

import java.util.ArrayList;
import java.util.List;

import memento.GameMemento;
import memento.GameHistory;
import observer.Observer;
import saving.GameSave;
import saving.IGameSaveRepository;
import tictactoe.RestorableObservableGameContext;
import ui.SavePanel;

public class SaveController implements ISaveController {

	private SavePanel view;
	private IGameSaveRepository gameSaveRepository;
	private RestorableObservableGameContext game;
	private GameHistory gameHistory;
	private List<Observer> subscribers;

	public SaveController() {
		subscribers = new ArrayList<Observer>();
	}

	@Override
	public SavePanel getView() {
		return view;
	}

	@Override
	public void setView(SavePanel view) {
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
	public IGameSaveRepository getGameSaveRepository() {
		return gameSaveRepository;
	}

	@Override
	public void setGameSaveRepository(IGameSaveRepository gameSaveRepository) {
		this.gameSaveRepository = gameSaveRepository;
	}

	@Override
	public void save(String filename) {
		gameSaveRepository.addSave(new GameSave(game.getPlayers(), gameHistory, filename));
	}

	@Override
	public List<GameSave> getSaves() throws ClassNotFoundException {
		return gameSaveRepository.getListOfSaves();
	}

	@Override
	public void load(int index) throws ClassNotFoundException {
		GameSave gameSave = gameSaveRepository.getGameSave(index);

		this.game.setPlayers(gameSave.getPlayers());
		this.gameHistory.loadOtherHistory(gameSave.getGameHistory());
		GameMemento memento = gameHistory.getCurrentSnapshot();

		game.restore(memento);
		notifySubscribers();
	}

	private void notifySubscribers() {
		subscribers.forEach(observer -> observer.update());
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
