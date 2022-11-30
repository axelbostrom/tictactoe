package validators;

import java.awt.Dimension;
import java.io.Serializable;

import models.Board;

public class TieValidator implements Serializable, ITieValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8309834764616601605L;

	@Override
	public boolean test(Board board) {
		Dimension size = board.getSize();
		boolean movesAvailable = false;

		for (int row = 0; row < size.height; row++) {
			for (int col = 0; col < size.width; col++) {
				movesAvailable |= board.isEmpty(row, col);
			}
		}
		return !movesAvailable;
	}

}
