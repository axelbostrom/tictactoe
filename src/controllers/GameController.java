package controllers;

import java.awt.Dimension;
import java.util.List;
import java.util.Observable;

import models.CircleCell;
import models.CrossCell;
import models.Move;
import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.ObservableGame;
import tictactoe.Player;
import tictactoe.states.MoveState;
import ui.GameWindow;
import validators.MoveValidator;
import validators.WinValidator;
import tictactoe.GameSave;
import tictactoe.GameSaveHandler;

public class GameController {
	
	private GameWindow view;
	private Game game;
	private WinValidator winValidator;
	private MoveValidator moveValidator;
	private GameStateHistory gameStateHistory;
	private GameSaveHandler savedGames;
	
	public GameController() {
		view = new GameWindow(this);
		game = new Game();
		savedGames = new GameSaveHandler();
		
		game.setPlayers(List.of(new Player("Player 1", new CrossCell()), new Player("Player 2", new CircleCell())));
		game.restore(new GameState(new Board(new Dimension(3, 3)), game.getPlayers().get(0), new MoveState()));
		view.setBoard(game.getBoard());
		gameStateHistory = new GameStateHistory(game.createMemento());
		moveValidator = new MoveValidator();
		winValidator = new WinValidator();
		
		game.addSubscriber(this::moveMade);
	}
	
	public void cellSelected(int row, int col) {
		game.makeMove(row, col);
	}
	
	private void moveMade(Game game) {
		gameStateHistory.addGameState(game.createMemento());
		view.setBoard(game.getBoard());
	}
	
	public void undo() {
		GameState prevGameState = gameStateHistory.getPreviousGameState();
		game.restore(prevGameState);
		view.setBoard(prevGameState.getCurrBoard());
	}
	
	public void redo() {
		GameState nextGameState = gameStateHistory.getNextGameState();
		game.restore(nextGameState);
		view.setBoard(nextGameState.getCurrBoard());
	}
	
	public void save(String filename) {
		savedGames.addSave(new GameSave(game.getPlayers(), gameStateHistory, filename));
	}

	public List<GameSave> getSaves() throws ClassNotFoundException {
		return savedGames.getListOfSaves();
	}

	public void load(int index) throws ClassNotFoundException {
		GameSave gameSave = savedGames.getGameSave(index);
		
		this.game.setPlayers(gameSave.getPlayers());;
		this.gameStateHistory = gameSave.getGameStateHistory();
		
		game.restore(gameStateHistory.getCurrentGameState());
		view.setBoard(game.getBoard());
	}
 }
