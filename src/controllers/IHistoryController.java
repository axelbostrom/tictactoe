package controllers;

import memento.GameMemento;
import memento.GameHistory;
import observer.Observable;
import tictactoe.IAbstractGameInitFactory;
import tictactoe.RestorableObservableGameContext;
import ui.HistoryPanel;

public interface IHistoryController extends Observable {

	HistoryPanel getView();

	void setView(HistoryPanel view);

	RestorableObservableGameContext getGame();

	void setGame(RestorableObservableGameContext game);

	GameHistory getGameHistory();

	void setGameHistory(GameHistory gameHistory);

	void undo();

	void redo();

	void newGame();

	IAbstractGameInitFactory getGameInitFactory();

	void setGameInitFactory(IAbstractGameInitFactory gameInitFactory);

}