package validators;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import models.Move;
import tictactoe.Board;

public class MoveValidator implements BiPredicate<Board,Move>{

	@Override
	public boolean test(Board board, Move move) {
		return board.isEmpty(move.getRow(), move.getCol());
	}

}
