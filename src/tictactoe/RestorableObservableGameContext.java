package tictactoe;

import memento.GameMemento;

public interface RestorableObservableGameContext extends ObservableGameContext {

	GameMemento createMemento();

	void restore(GameMemento memento);

}