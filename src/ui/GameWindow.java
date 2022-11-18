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
	BoardPanel boardContainer;
	private SaveWindow saveWindow;
	private LoadWindow loadWindow;
	
	/**
	 * Create the application.
	 */
	public GameWindow(GameController gameController) {
		this.gameController = gameController;
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
		
		
		JButton undoBtn = new JButton("Undo");
		undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameController.undo();
			}
		});
		undoBtn.setBounds(77, 322, 78, 23);
		frmTicTacToe.getContentPane().add(undoBtn);
		
		JButton redoBtn = new JButton("Redo");
		redoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameController.redo();
			}
		});
		redoBtn.setBounds(165, 322, 78, 23);
		frmTicTacToe.getContentPane().add(redoBtn);
		
		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
;				try {
					loadWindow = new LoadWindow(gameController);
					loadWindow.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		loadBtn.setBounds(312, 322, 78, 23);
		frmTicTacToe.getContentPane().add(loadBtn);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveWindow = new SaveWindow(gameController);
				saveWindow.setVisible(true);
			}
		});
		saveBtn.setBounds(400, 322, 78, 23);
		frmTicTacToe.getContentPane().add(saveBtn);

		frmTicTacToe.setVisible(true);
	}

	public void setBoard(Board newBoard) {
		boardContainer.setBoard(newBoard);
	}
}
