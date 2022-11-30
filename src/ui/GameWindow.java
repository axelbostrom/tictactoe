package ui;

import javax.swing.JFrame;

import controllers.GameController;
import tictactoe.Board;
import tictactoe.Observable;
import tictactoe.Observer;
import tictactoe.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class GameWindow {

	private JFrame frmTicTacToe;
	private GameController gameController;
	private BoardPanel boardContainer;
	private SavePanel savePanel;
	private HistoryPanel historyPanel;
	private List<Observer> subscribers;
	private InfoPanel infoPanel;

	/**
	 * Create the application.
	 */
	public GameWindow(GameController gameController, SavePanel savePanel, HistoryPanel historyPanel) {
		this.gameController = gameController;
		this.savePanel = savePanel;
		this.historyPanel = historyPanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		infoPanel = new InfoPanel();
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 500, 400);
		frmTicTacToe.getContentPane().setLayout(null);

		boardContainer = new BoardPanel(3);
		boardContainer.setBounds(10, 11, 300, 300);
		boardContainer.setCallback((row, col) -> {
			gameController.cellSelected(row, col);
		});

		frmTicTacToe.getContentPane().add(infoPanel);

		frmTicTacToe.getContentPane().add(boardContainer);

		frmTicTacToe.getContentPane().add(historyPanel);

		frmTicTacToe.getContentPane().add(savePanel);

		frmTicTacToe.setVisible(true);
	}

	public void setBoard(Board newBoard) {
		boardContainer.setBoard(newBoard);
		
	}
	
	public void setPlayer(Player player) {
		infoPanel.setPlayer(player);
	}
	
	public void setState(GameWindowState state) {
		
		infoPanel.setState(state);
	}
	

}
