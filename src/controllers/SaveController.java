package controllers;

import java.util.ArrayList;
import java.util.List;

import tictactoe.Game;
import tictactoe.GameSave;
import tictactoe.GameSaveRepository;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observable;
import tictactoe.Observer;
import ui.SavePanel;

public class SaveController implements Observable {

	private SavePanel view;
	private GameSaveRepository gameSaveRepository;
	private GameState gameState;
	private Game game;
	private GameStateHistory gameStateHistory;
	private List<Observer> subscribers;

	public SaveController() {
		subscribers = new ArrayList<Observer>();
	}

	public SavePanel getView() {
		return view;
	}

	public void setView(SavePanel view) {
		this.view = view;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGame(GameState gameState) {
		this.gameState = gameState;
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

	public GameSaveRepository getGameSaveRepository() {
		return gameSaveRepository;
	}

	public void setGameSaveRepository(GameSaveRepository gameSaveRepository) {
		this.gameSaveRepository = gameSaveRepository;
	}

	public void save(String filename) {
		gameSaveRepository.addSave(new GameSave(game.getPlayers(), gameStateHistory, filename));
	}

	public List<GameSave> getSaves() throws ClassNotFoundException {
		return gameSaveRepository.getListOfSaves();
	}

	public void load(int index) throws ClassNotFoundException {
		GameSave gameSave = gameSaveRepository.getGameSave(index);
		

		this.game.setPlayers(gameSave.getPlayers());
		this.gameStateHistory.load(gameSave.getGameStateHistory());
		this.gameState = gameStateHistory.getCurrentGameState();

		game.restore(getGameState());
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
