package controllers;

import java.awt.Dimension;
import java.util.List;

import models.CircleCell;
import models.CrossCell;
import models.Move;
import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.GameStateHistory;
import tictactoe.Player;
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
		game.setGameState(new GameState(new Board(new Dimension(3, 3)), game.getPlayers().get(0)));
		view.setBoard(game.getGameState().getCurrBoard());
		gameStateHistory = new GameStateHistory(game.getGameState());
		moveValidator = new MoveValidator();
		winValidator = new WinValidator();
	}
	
	public void cellSelected(int row, int col) {
		
		if (moveValidator.test(game.getGameState().getCurrBoard(), new Move(row, col))) {
			Board newBoard = new Board(game.getGameState().getCurrBoard());
			newBoard.setCell(row, col, game.getGameState().getCurrPlayer().getCell());
			
			Player nextPlayer = game.getPlayers().get((game.getPlayers().indexOf(game.getGameState().getCurrPlayer()) + 1) % game.getPlayers().size());
			gameStateHistory.addGameState(new GameState(newBoard, nextPlayer));
			game.setGameState(gameStateHistory.getCurrentGameState());
			view.setBoard(newBoard);
		}
	}
	
	public void undo() {
		GameState prevGameState = gameStateHistory.getPreviousGameState();
		game.setGameState(prevGameState);
		view.setBoard(prevGameState.getCurrBoard());
	}
	
	public void redo() {
		GameState nextGameState = gameStateHistory.getNextGameState();
		game.setGameState(nextGameState);
		view.setBoard(nextGameState.getCurrBoard());
	}
	
	public void save(String filename) {
		savedGames.addSave(new GameSave(game, gameStateHistory, filename));
	}

	public List<GameSave> getSaves() throws ClassNotFoundException {
		return savedGames.getListOfSaves();
	}

	public void load(int index) throws ClassNotFoundException {
		GameSave gameSave = savedGames.getGameSave(index);
		
		this.game = gameSave.getGame();
		this.gameStateHistory = gameSave.getGameStateHistory();
		
		game.setGameState(gameSave.getGame().getGameState());
		view.setBoard(game.getGameState().getCurrBoard());
	}
 }
