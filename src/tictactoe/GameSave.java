package tictactoe;

import java.io.Serializable;

public class GameSave implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3122331854231061791L;
	private Game game;
	private GameStateHistory gameStateHistory;
	private String filename;

	public GameSave(Game game, GameStateHistory gameStateHistory, String filename) {
		this.setGame(game);
		this.setGameStateHistory(gameStateHistory);
		this.setFilename(filename);
		
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
