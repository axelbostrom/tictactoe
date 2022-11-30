package validators;

import java.util.function.BiPredicate;

import models.Board;
import models.Move;

public interface IMoveValidator extends BiPredicate<Board, Move> {

}