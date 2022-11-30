package ui;

import javax.swing.JFrame;

import models.Player;

public class GameWindow {

	private JFrame frmTicTacToe;
	private BoardPanel boardPanel;
	private SavePanel savePanel;
	private HistoryPanel historyPanel;
	private InfoPanel infoPanel;

	/**
	 * Create the application.
	 */
	public GameWindow(BoardPanel boardPanel, SavePanel savePanel, HistoryPanel historyPanel) {
		this.boardPanel = boardPanel;
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

		frmTicTacToe.getContentPane().add(infoPanel);

		frmTicTacToe.getContentPane().add(boardPanel);

		frmTicTacToe.getContentPane().add(historyPanel);

		frmTicTacToe.getContentPane().add(savePanel);

		frmTicTacToe.setVisible(true);
	}
	
	public void setPlayer(Player player) {
		infoPanel.setPlayer(player);
	}
	
	public void setState(GameWindowState state) {
		
		infoPanel.setState(state);
	}
	

}
