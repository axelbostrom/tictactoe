package tictactoe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tictactoe.states.State;

public class Game implements GameContext, Observable, Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -53498677702210278L;
    private List<Player> players;
    private State state;
    private Board board;
    private Player player;
    private transient List<Observer> subscribers;
    
    public Game() {
    	subscribers = new ArrayList<>();
    }

    public GameState createMemento() {
        return new GameState(board, player, state);
    }

    public void restore(GameState gameState) {
        this.board = gameState.getCurrBoard();
        this.player = gameState.getCurrPlayer();
        this.state = gameState.getCurrState();
    }

    public List<Player> getPlayers() {
        return players;
    }


    public void setPlayers(List<Player> list) {
        this.players = list;
    }


	@Override
	public void setState(State newState) {
		state = newState;
		notifySubscribers();
	}


	@Override
	public Board getBoard() {
		return board;
	}


	@Override
	public void setBoard(Board board) {
		this.board = board;
	}


	@Override
	public Player getCurrentPlayer() {
		return player;
	}


	@Override
	public Player getNextPlayer() {
		return players.get((players.indexOf(player) + 1) % players.size());
	}


	@Override
	public void setCurrentPlayer(Player newPlayer) {
		player = newPlayer;
	}

	public void makeMove(int row, int col) {
		state.makeMove(this, row, col);
	}

	@Override
	public void notifySubscribers() {
		subscribers.forEach(observer -> observer.update(this));
	}

	@Override
	public void addSubscriber(Observer observer) {
		subscribers.add(observer);
	}


	@Override
	public void removeSubscriber(Observer observer) {
		subscribers.remove(observer);
	}
	
	
}
	
