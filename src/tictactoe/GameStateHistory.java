package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameStateHistory {
	List<GameState> gameStates;
	int currentIndex;
	
	public GameStateHistory(GameState initialGameState) {
		gameStates = new ArrayList<>();
		currentIndex = -1;
		addGameState(initialGameState);
	}
	
	public GameState getCurrentGameState() {
		return gameStates.get(currentIndex);
	}
	
	public void addGameState(GameState gameState) {
		
		if (currentIndex < gameStates.size() - 1) {
			gameStates.removeAll(gameStates.subList(currentIndex+1, gameStates.size()));
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
