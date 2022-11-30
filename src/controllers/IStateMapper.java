package controllers;

import tictactoe.states.State;
import ui.GameWindowState;

public interface IStateMapper {
	GameWindowState map(State state);
}
