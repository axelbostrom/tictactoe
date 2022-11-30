package tictactoe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import memento.GameMemento;
import models.Board;
import models.Player;
import observer.Observer;
import tictactoe.states.State;

public class Game implements Serializable, RestorableObservableGameContext {

	private static final long serialVersionUID = -53498677702210278L;
	private List<Player> players;
	private State state;
	private Board board;
	private Player player;
	private transient List<Observer> subscribers;

	public Game() {
		subscribers = new ArrayList<>();
	}

	@Override
	public GameMemento createMemento() {
		return new GameMemento(board, player, state);
	}

	@Override
	public void restore(GameMemento memento) {
		this.board = memento.getCurrBoard();
		this.player = memento.getCurrPlayer();
		this.state = memento.getCurrState();
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
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

	@Override
	public void makeMove(int row, int col) {
		state.makeMove(this, row, col);
	}

	private void notifySubscribers() {
		subscribers.forEach(observer -> observer.update());
	}

	@Override
	public void addSubscriber(Observer observer) {
		subscribers.add(observer);
	}

	@Override
	public void removeSubscriber(Observer observer) {
		subscribers.remove(observer);
	}

	@Override
	public State getState() {
		return state;
	}

}
