package ui;

import java.awt.Dimension;
import java.util.function.BiConsumer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import models.Cell;
import models.CircleCell;
import models.CrossCell;
import models.EmptyCell;
import tictactoe.Board;
import tictactoe.Player;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674162700216707926L;
	private BoardButton[][] buttons;
	private int size = 3;
	private BiConsumer<Integer, Integer> handler;

	public BoardPanel(int size) {
		this.size = size;
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(new Dimension(300, 300));

		buttons = new BoardButton[size][size];
		addButtons();

	}

	private void addButtons() {
		for (int i = 0; i < size; i++) {

			JPanel subPanel = new JPanel();
			subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
			for (int j = 0; j < size; j++) {
				BoardButton newButton = new BoardButton(i, j);
				newButton.setMinimumSize(new Dimension(100, 100));
				newButton.addActionListener(event -> {
					BoardButton sourceButton = (BoardButton) event.getSource();
					handler.accept(sourceButton.getRow(), sourceButton.getCol());
				});
				buttons[i][j] = newButton;
				subPanel.add(buttons[i][j]);
			}
			add(subPanel);
		}
	}

	public void setButtonText(int row, int col, String text) {

		if (row >= 0 && row < size && col >= 0 && col < size) {
			SwingUtilities.invokeLater(() -> {
				buttons[row][col].setText(text);
			});
		}
	}

	public void setCallback(BiConsumer<Integer, Integer> handler) {
		this.handler = handler;
	}

	public void setBoard(Board newBoard) {
		SwingUtilities.invokeLater(() -> {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					Cell cell = newBoard.getCell(i, j);
					if (cell.getClass().equals(CrossCell.class)) {
						buttons[i][j].setText("X");
					} else if (cell.getClass().equals(CircleCell.class)) {
						buttons[i][j].setText("O");
					} else {
						buttons[i][j].setText(" ");
					}
				}
			}
		});
	}
}
