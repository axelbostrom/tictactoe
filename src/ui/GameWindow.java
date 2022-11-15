package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tictactoe.Board;
import tictactoe.Game;
import tictactoe.GameCaretaker;
import tictactoe.GameMemento;
import tictactoe.GameState;
import tictactoe.Player;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class GameWindow {

	public JFrame frmTicTacToe;
	private SaveHandler saveHandler;
	private UndoHandler undoHandler;
	private Game game;
	private GameState gameState;
	private GameMemento gameMemento;
	private GameCaretaker gameCaretaker;
	private ArrayList<Player> players;
	private Board board;
	private Board board1;
	private Board board2;
	
	int currentGameIterator = 0;
	
	
	/**
	 * Create the application.
	 */
	public GameWindow() {
		runGame();
		initialize();
	}

	/**
	 * Initialize all necessary Game items
	 */
	private void runGame() {
//		game = new Game();
//		Player player = new Player("test");
//		Player player2 = new Player("test");
//		players = new ArrayList<Player>();
//		players.add(player);
//		players.add(player2);
//		
//		board = new Board();
//		board1 = new Board();
//		board2 = new Board();
//		
//		gameState = new GameState(board, player);
//		
//		//gameMemento = new GameMemento(gameState, players);
//		
//		game.setGameState(gameState);
//		game.setPlayers(players);
//		gameCaretaker.addMemento(game.storeMemento());
//		currentGameIterator++;
//		
//		game.setGameState(new GameState(board2, player2));
//		gameCaretaker.addMemento(game.storeMemento());
//		currentGameIterator++;
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 500, 400);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.getContentPane().setLayout(null);
		
		JPanel boardContainer = new JPanel();
		boardContainer.setBounds(10, 11, 300, 300);
		frmTicTacToe.getContentPane().add(boardContainer);
		
		JButton undoBtn = new JButton("Undo");
		undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undoHandler.undo();
			}
		});
		undoBtn.setBounds(77, 322, 78, 23);
		frmTicTacToe.getContentPane().add(undoBtn);
		
		JButton redoBtn = new JButton("Redo");
		redoBtn.setBounds(165, 322, 78, 23);
		frmTicTacToe.getContentPane().add(redoBtn);
		
		JButton loadBtn = new JButton("Load");
		loadBtn.setBounds(312, 322, 78, 23);
		frmTicTacToe.getContentPane().add(loadBtn);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveHandler.save();
			}
		});
		saveBtn.setBounds(400, 322, 78, 23);
		frmTicTacToe.getContentPane().add(saveBtn);
	}
	
	
}
