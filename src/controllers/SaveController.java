package controllers;

import java.util.ArrayList;
import java.util.List;

import tictactoe.Game;
import tictactoe.GameSave;
import tictactoe.GameSaveRepository;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observer;
import ui.SavePanel;

public class SaveController implements ISaveController {

	private SavePanel view;
	private GameSaveRepository gameSaveRepository;
	private GameState gameState;
	private Game game;
	private GameStateHistory gameStateHistory;
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
	public GameState getGameState() {
		return gameState;
	}

	@Override
	public void setGame(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
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
	public GameSaveRepository getGameSaveRepository() {
		return gameSaveRepository;
	}

	@Override
	public void setGameSaveRepository(GameSaveRepository gameSaveRepository) {
		this.gameSaveRepository = gameSaveRepository;
	}

	@Override
	public void save(String filename) {
		gameSaveRepository.addSave(new GameSave(game.getPlayers(), gameStateHistory, filename));
	}

	@Override
	public List<GameSave> getSaves() throws ClassNotFoundException {
		return gameSaveRepository.getListOfSaves();
	}

	@Override
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
