package tictactoe;
import java.util.ArrayList;
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


    public GameMemento createMemento() {  
        System.out.println("Originator: storeMemento " + gameState + ", " + players);
        return new GameMemento(gameState, players);
    }

    public void restore(GameMemento m) {
        System.out.println("Originator: restoreMemento " + m.getGameState() + ", " + m.getPlayers());
        this.gameState = m.getGameState();
        this.players = m.getPlayers();
    }

}
	
