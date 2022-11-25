package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controllers.HistoryController;
import controllers.SaveController;
import models.Cell;
import models.CircleCell;
import models.CrossCell;
import models.EmptyCell;
import tictactoe.Board;

public class HistoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7766253202207226342L;
	private HistoryController historyController;

	public HistoryPanel(HistoryController historyController) {
		this.historyController = historyController;
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		// setSize(new Dimension(200,60));
		setBounds(250, 300, 225, 60);

		JButton undoBtn = new JButton("Undo");
		undoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historyController.undo();
			}
		});
		undoBtn.setBounds(100, 22, 78, 23);
		this.add(undoBtn);

		JButton redoBtn = new JButton("Redo");
		redoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historyController.redo();
			}
		});
		redoBtn.setBounds(100, 22, 78, 23);
		this.add(redoBtn);

		JButton newBtn = new JButton("New Game");
		newBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historyController.newGame();
			}
		});
		newBtn.setBounds(100, 22, 78, 23);
		this.add(newBtn);

	}
}
