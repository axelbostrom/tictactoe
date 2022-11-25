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

public class GameWindow implements Observable {

	private JFrame frmTicTacToe;
	private BoardPanel boardContainer;
	private SavePanel savePanel;
	private HistoryPanel historyPanel;
	private List<Observer> subscribers;
	private InfoPanel infoPanel;
	private int row;
	private int col;

	/**
	 * Create the application.
	 */
	public GameWindow(SavePanel savePanel, HistoryPanel historyPanel) {
		subscribers = new ArrayList<Observer>();
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
			this.row = row;
			this.col = col;
			notifySubscribers("move");
		});

		frmTicTacToe.getContentPane().add(infoPanel);

		frmTicTacToe.getContentPane().add(boardContainer);

		frmTicTacToe.getContentPane().add(historyPanel);

		frmTicTacToe.getContentPane().add(savePanel);

		frmTicTacToe.setVisible(true);
	}

	public void setBoard(Board newBoard, String playerName) {
		boardContainer.setBoard(newBoard);
		infoPanel.setPlayerName(playerName);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void notifySubscribers(String string) {
		subscribers.forEach(observer -> observer.update(string, this));
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
