package memento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameStateHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5235180427689906260L;
	private List<GameState> gameStates;
	private int currentIndex;

	public GameStateHistory() {
		clear();
	}
	
	public GameStateHistory(GameState initialGameState) {
		clear();
		addGameState(initialGameState);
	}

	public void load(GameStateHistory other) {
		this.gameStates = other.gameStates;
		this.currentIndex = other.currentIndex;
	}

	public GameState getCurrentGameState() {
		return gameStates.get(currentIndex);
	}
	
	public void clear() {
		gameStates = new ArrayList<>();
		currentIndex = -1;
	}

	public void addGameState(GameState gameState) {

		if (currentIndex < gameStates.size() - 1) {
			gameStates.removeAll(gameStates.subList(currentIndex + 1, gameStates.size()));
		}
		gameStates.add(gameState);
		currentIndex++;
	}

	public GameState getNextGameState() {
		if (currentIndex < gameStates.size() - 1) {
			currentIndex++;
			return getCurrentGameState();
		} else {
			return getCurrentGameState();
		}
	}

	public GameState getPreviousGameState() {
		if (currentIndex > 0) {
			currentIndex--;
			return getCurrentGameState();
		} else {
			return getCurrentGameState();
		}
	}

}
