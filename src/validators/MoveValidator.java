package validators;

import java.io.Serializable;

import models.Board;
import models.Move;

public class MoveValidator implements Serializable, IMoveValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8309834764616601605L;

	@Override
	public boolean test(Board board, Move move) {
		return board.isEmpty(move.getRow(), move.getCol());
	}

}
