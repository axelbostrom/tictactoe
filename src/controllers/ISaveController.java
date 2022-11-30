package controllers;

import java.util.List;

import tictactoe.Game;
import tictactoe.GameSave;
import tictactoe.GameSaveRepository;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Observable;
import ui.SavePanel;

public interface ISaveController extends Observable{

	SavePanel getView();

	void setView(SavePanel view);

	GameState getGameState();

	void setGame(GameState gameState);

	Game getGame();

	void setGame(Game game);

	GameStateHistory getGameStateHistory();

	void setGameStateHistory(GameStateHistory gameStateHistory);

	GameSaveRepository getGameSaveRepository();

	void setGameSaveRepository(GameSaveRepository gameSaveRepository);

	void save(String filename);

	List<GameSave> getSaves() throws ClassNotFoundException;

	void load(int index) throws ClassNotFoundException;

}