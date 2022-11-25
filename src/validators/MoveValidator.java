package validators;

import java.io.Serializable;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import models.Move;
import tictactoe.Board;

public class MoveValidator implements BiPredicate<Board, Move>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8309834764616601605L;

	@Override
	public boolean test(Board board, Move move) {
		return board.isEmpty(move.getRow(), move.getCol());
	}

}
