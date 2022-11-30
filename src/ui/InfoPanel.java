package ui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tictactoe.Player;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1895792502596588154L;
	private JLabel info;
	private Player player;
	private GameWindowState state;

	public InfoPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(new Dimension(200, 60));
		setBounds(250, 0, 200, 60);

		info = new JLabel();
		this.add(info);

	}

	public void setPlayer(Player player) {
		this.player = player;
		updateText();
	}
	
	public void setState(GameWindowState state) {
		this.state = state;
		updateText();
	}
	
	private void updateText() {
		SwingUtilities.invokeLater(() -> {
			String text = "";
			switch (state) {
			case MOVE:
				text = player.getName() + "'s turn!";
				break;
			case WIN:
				text = player.getName() + " won!";
				break;
			case TIE:
				text = "It's a tie!";
				break;
			}
			
			info.setText(text);
		});
	}

}
