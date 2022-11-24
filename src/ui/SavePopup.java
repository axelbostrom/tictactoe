package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.SaveController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
public class SavePopup extends JFrame {

	private JPanel contentPane;
	private String saveFileName;
	private JTextField textField;
	private SaveController saveController;

	/**
	 * Create the frame.
	 */
	public SavePopup(SaveController gc) {
		saveController = gc;
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
				saveController.save(saveFileName);
				setVisible(false);
			}
		});
	}
}
