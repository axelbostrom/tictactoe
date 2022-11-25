package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controllers.SaveController;
import models.Cell;
import models.CircleCell;
import models.CrossCell;
import models.EmptyCell;
import tictactoe.Board;

public class SavePanel extends JPanel {

	private LoadPopup loadWindow;
	private SavePopup saveWindow;
	private SaveController saveController;

	public SavePanel(SaveController saveController) {
		this.saveController = saveController;
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(200, 60));
		setBounds(100, 300, 200, 60);

		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadWindow = new LoadPopup(saveController);
					loadWindow.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		loadBtn.setBounds(12, 22, 78, 23);
		this.add(loadBtn);

		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveWindow = new SavePopup(saveController);
				saveWindow.setVisible(true);
			}
		});
		saveBtn.setBounds(100, 22, 78, 23);
		this.add(saveBtn);

	}
}
