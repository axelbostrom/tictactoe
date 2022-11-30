

import controllers.BoardController;
import controllers.GameController;
import controllers.HistoryController;
import controllers.IBoardController;
import controllers.IGameController;
import controllers.SaveController;
import memento.GameStateHistory;
import saving.GameSaveRepository;
import tictactoe.Game;
import ui.BoardPanel;
import ui.GameWindow;
import ui.HistoryPanel;
import ui.SavePanel;

public class Main {

	public static void main(String[] args) {
		

		Game game = new Game();
		GameStateHistory gameStateHistory = new GameStateHistory();
		
		SaveController saveController = new SaveController();
		HistoryController historyController = new HistoryController();
		IBoardController boardController = new BoardController();

		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		BoardPanel boardPanel = new BoardPanel(boardController, 3);
		

		saveController.setView(savePanel);
		historyController.setView(historyPanel);

		boardController.setGame(game);
		boardController.setView(boardPanel);
		
		historyController.setGame(game);
		historyController.setGameStateHistory(gameStateHistory);
		historyController.setView(historyPanel);

		saveController.setGame(game);
		saveController.setGameStateHistory(gameStateHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());
		
		IGameController gameController = new GameController();
		
		GameWindow mainWindow = new GameWindow(boardPanel, savePanel, historyPanel);
		
		gameController.setGame(game);
		gameController.setGameStateHistory(gameStateHistory);
		gameController.setHistoryController(historyController);
		gameController.setSaveController(saveController);
		gameController.setBoardController(boardController);
		gameController.setView(mainWindow);
		
		gameController.play();
		
	}

}
