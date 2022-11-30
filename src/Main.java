

import controllers.GameController;
import controllers.HistoryController;
import controllers.SaveController;
import tictactoe.Game;
import tictactoe.GameSaveRepository;
import tictactoe.GameStateHistory;
import ui.GameWindow;
import ui.HistoryPanel;
import ui.SavePanel;

public class Main {

	public static void main(String[] args) {
		

		Game game = new Game();
		GameStateHistory gameStateHistory = new GameStateHistory();
		
		SaveController saveController = new SaveController();

		HistoryController historyController = new HistoryController();

		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		

		saveController.setView(savePanel);
		historyController.setView(historyPanel);

		historyController.setGame(game);
		historyController.setGameStateHistory(gameStateHistory);

		saveController.setGame(game);
		saveController.setGameStateHistory(gameStateHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());
		
		GameController gameController = new GameController();
		
		GameWindow mainWindow = new GameWindow(gameController, savePanel, historyPanel);
		
		gameController.setGame(game);
		gameController.setGameStateHistory(gameStateHistory);
		gameController.setHistoryController(historyController);
		gameController.setSaveController(saveController);
		gameController.setView(mainWindow);
		
		gameController.play();
		
	}

}
