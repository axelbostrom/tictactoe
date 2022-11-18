package tictactoe;
import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -53498677702210278L;
	private GameState gameState;
    private List<Player> players;

    public GameState getGameState() {
        return gameState;
    }


    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public List<Player> getPlayers() {
        return players;
    }


    public void setPlayers(List<Player> list) {
        this.players = list;
    }
}
	
