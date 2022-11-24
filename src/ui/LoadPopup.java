package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.SaveController;
import tictactoe.GameSave;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class LoadPopup extends JFrame {

	private JPanel contentPane;
	private String[] fileNameList;
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	
	public LoadPopup(SaveController saveController) throws ClassNotFoundException {
		List<GameSave> gameSave = saveController.getSaves();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		fileNameList = new String[gameSave.size()];

		setContentPane(contentPane);
		contentPane.setLayout(null);
		for (int i = 0; i < gameSave.size(); i++) {
			fileNameList[i] = gameSave.get(i).getFilename();
		}
		
		JList<String> loadList = new JList<String>(fileNameList);
		loadList.setBounds(10, 29, 418, 190);
		contentPane.add(loadList);
		
		JTextPane infoText = new JTextPane();
		infoText.setText("Select a save to load:");
		infoText.setBounds(10, 11, 120, 20);
		contentPane.add(infoText);
		
		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveController.load(loadList.getSelectedIndex());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		loadBtn.setBounds(176, 231, 89, 23);
		contentPane.add(loadBtn);
	}
	
}
