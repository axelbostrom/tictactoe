package tictactoe;

import java.util.List;

import memento.GameState;
import tictactoe.states.State;

public interface RestorableObservableGameContext extends ObservableGameContext{

	GameState createMemento();

	void restore(GameState gameState);

}