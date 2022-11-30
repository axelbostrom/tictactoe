package tictactoe;

import java.util.List;

import models.Board;
import models.Player;
import tictactoe.states.State;

public interface IAbstractGameInitFactory {
	State createStartingState();

	Board createBoard();

	List<Player> createPlayers();
}
