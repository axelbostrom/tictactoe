package controllers;

import tictactoe.states.State;
import tictactoe.states.TieState;
import tictactoe.states.WinState;
import ui.GameWindowState;

public class StateMapper implements IStateMapper {

	@Override
	public GameWindowState map(State state) {
		if (state.getClass().equals(TieState.class)) {
			return GameWindowState.TIE;
		} else if (state.getClass().equals(WinState.class)) {
			return GameWindowState.WIN;
		}
		return GameWindowState.MOVE;
	}

}
