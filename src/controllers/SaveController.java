package controllers;

import java.util.List;

import tictactoe.Game;
import tictactoe.GameSave;
import tictactoe.GameSaveRepository;
import tictactoe.GameStateHistory;
import ui.GameWindow;
import ui.SavePanel;

public class SaveController {

	private SavePanel view;
	private GameSaveRepository gameSaveRepository;
	private Game game;
	private GameStateHistory gameStateHistory;
	private GameController gameController; //dependency should be inverted
	
	public SaveController(GameController parent) {
		gameController = parent;
	}
	
	public SavePanel getView() {
		return view;
	}

	public void setView(SavePanel view) {
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
		
		this.game.setPlayers(gameSave.getPlayers());;
		this.gameStateHistory.copy(gameSave.getGameStateHistory());
		
		game.restore(gameStateHistory.getCurrentGameState());
		gameController.boardUpdated();
	}
}
