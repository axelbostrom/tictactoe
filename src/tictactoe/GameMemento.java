package tictactoe;

import java.util.List;

public class GameMemento {

    private GameState gameState;
    private List<Player> players;
    
    public GameMemento(GameState gameState, List<Player> players) {
        this.gameState = gameState;
        this.players = players;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
