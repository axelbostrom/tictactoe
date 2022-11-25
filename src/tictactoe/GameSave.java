package tictactoe;

import java.io.Serializable;
import java.util.List;

public class GameSave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3122331854231061791L;
	private List<Player> players;
	private GameStateHistory gameStateHistory;
	private String filename;

	public GameSave(List<Player> players, GameStateHistory gameStateHistory, String filename) {
		this.setPlayers(players);
		this.setGameStateHistory(gameStateHistory);
		this.setFilename(filename);

	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
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
