package ui;

import javax.swing.JButton;

public class BoardButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7973036443826317319L;
	private int row;
	private int col;

	public BoardButton(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}
