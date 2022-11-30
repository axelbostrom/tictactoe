package controllers;

import java.util.List;

import memento.GameState;
import memento.GameHistory;
import observer.Observable;
import saving.GameSave;
import saving.IGameSaveRepository;
import tictactoe.RestorableObservableGameContext;
import ui.SavePanel;

public interface ISaveController extends Observable {

	SavePanel getView();

	void setView(SavePanel view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

	GameHistory getGameHistory();

	void setGameHistory(GameHistory gameHistory);

	IGameSaveRepository getGameSaveRepository();

	void setGameSaveRepository(IGameSaveRepository gameSaveRepository);

	void save(String filename);

	List<GameSave> getSaves() throws ClassNotFoundException;

	void load(int index) throws ClassNotFoundException;

}