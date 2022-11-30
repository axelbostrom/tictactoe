package tictactoe;

import memento.GameState;

public interface RestorableObservableGameContext extends ObservableGameContext {

	GameState createMemento();

	void restore(GameState gameState);

}