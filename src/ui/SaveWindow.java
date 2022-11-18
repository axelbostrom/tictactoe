package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.GameController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;

public class SaveWindow extends JFrame {

	private JPanel contentPane;
	private String saveFileName;
	private JTextField textField;
	private GameController gameController;

	/**
	 * Create the frame.
	 */
	public SaveWindow(GameController gc) {
		gameController = gc;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 75);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Savefile name:");
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton saveBtn = new JButton("Save");
		contentPane.add(saveBtn);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFileName = textField.getText();
				gameController.save(saveFileName);
				setVisible(false);
			}
		});
	}
}
