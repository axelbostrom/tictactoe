package saving;

import java.io.Serializable;
import java.util.List;

import memento.GameHistory;
import models.Player;

public class GameSave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3122331854231061791L;
	private List<Player> players;
	private GameHistory gameHistory;
	private String filename;

	public GameSave(List<Player> players, GameHistory gameHistory, String filename) {
		this.setPlayers(players);
		this.setGameHistory(gameHistory);
		this.setFilename(filename);

	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public GameHistory getGameHistory() {
		return gameHistory;
	}

	public void setGameHistory(GameHistory gameHistory) {
		this.gameHistory = gameHistory;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}
