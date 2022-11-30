package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ISaveController;
import saving.GameSave;

public class LoadPopup extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3948050961117403051L;
	private JPanel contentPane;
	private String[] fileNameList;

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */

	public LoadPopup(ISaveController saveController) throws ClassNotFoundException {
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

		JLabel infoText = new JLabel();
		infoText.setText("Select a save to load:");
		infoText.setBounds(10, 11, 120, 20);
		contentPane.add(infoText);

		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (loadList.getSelectedIndex() >= 0)
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
