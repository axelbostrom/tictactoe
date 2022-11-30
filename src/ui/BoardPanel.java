package ui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controllers.IBoardController;
import models.Cell;
import models.CircleCell;
import models.CrossCell;
import tictactoe.Board;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674162700216707926L;
	private BoardButton[][] buttons;
	private int size;
	private IBoardController boardController;
	private int dim = 300;

	public BoardPanel(IBoardController boardController, int size) {
		this.boardController = boardController;
		this.size = size;
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(new Dimension(dim, dim));
		setBounds(10, 11, dim, dim);

		buttons = new BoardButton[size][size];
		addButtons();

	}

	private void addButtons() {
		for (int i = 0; i < size; i++) {

			JPanel subPanel = new JPanel();
			subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
			for (int j = 0; j < size; j++) {
				BoardButton newButton = new BoardButton(i, j);
				newButton.setMinimumSize(new Dimension(dim/size, dim/size));
				newButton.addActionListener(event -> {
					BoardButton sourceButton = (BoardButton) event.getSource();
					boardController.cellSelected(sourceButton.getRow(), sourceButton.getCol());
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
