package ui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1895792502596588154L;
	private JLabel info;
	private String playerName = "";

	public InfoPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(200, 60));
		setBounds(250, 0, 200, 60);

		info = new JLabel(playerName);
		this.add(info);

	}

	public void setPlayerName(String playerName) {
		info.setText(playerName + "'s turn!");
	}

}
