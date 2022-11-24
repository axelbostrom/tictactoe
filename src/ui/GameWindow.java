package ui;

import javax.swing.JFrame;

import controllers.GameController;
import tictactoe.Board;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {

	private GameController gameController;
	private JFrame frmTicTacToe;
	private BoardPanel boardContainer;
	private SavePanel savePanel;
	private HistoryPanel historyPanel;
	
	/**
	 * Create the application.
	 */
	public GameWindow(GameController gameController,SavePanel savePanel, HistoryPanel historyPanel) {
		this.gameController = gameController;
		this.savePanel = savePanel;
		this.historyPanel = historyPanel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 500, 400);
		frmTicTacToe.getContentPane().setLayout(null);
		
		boardContainer = new BoardPanel(3);
		boardContainer.setBounds(10, 11, 300, 300);
		boardContainer.setCallback((row,col) -> {
				gameController.cellSelected(row,col);
			});
		frmTicTacToe.getContentPane().add(boardContainer);
		
		
		frmTicTacToe.getContentPane().add(historyPanel);
		
		frmTicTacToe.getContentPane().add(savePanel);
		

		frmTicTacToe.setVisible(true);
	}

	public void setBoard(Board newBoard) {
		boardContainer.setBoard(newBoard);
	}
}
