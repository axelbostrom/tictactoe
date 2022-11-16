package tictactoe;
import java.util.List;

public class Game {	
	
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
	
