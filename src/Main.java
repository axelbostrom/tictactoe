
import controllers.BoardController;
import controllers.GameController;
import controllers.HistoryController;
import controllers.IBoardController;
import controllers.IGameController;
import controllers.IHistoryController;
import controllers.ISaveController;
import controllers.SaveController;
import controllers.StateMapper;
import memento.GameHistory;
import saving.GameSaveRepository;
import tictactoe.DefaultGameInitFactory;
import tictactoe.Game;
import tictactoe.IAbstractGameInitFactory;
import ui.BoardPanel;
import ui.GameWindow;
import ui.HistoryPanel;
import ui.SavePanel;
import validators.IMoveValidator;
import validators.ITieValidator;
import validators.IWinValidator;
import validators.MoveValidator;
import validators.TieValidator;
import validators.WinValidator;

public class Main {

	public static void main(String[] args) {

		Game game = new Game();
		GameHistory gameHistory = new GameHistory();

		int numberOfCellsInARowToWin = 3;

		IWinValidator winValidator = new WinValidator(numberOfCellsInARowToWin);
		ITieValidator tieValidator = new TieValidator();
		IMoveValidator moveValidator = new MoveValidator();
		IAbstractGameInitFactory gameInitFactory = new DefaultGameInitFactory(3, winValidator, tieValidator,
				moveValidator);

		ISaveController saveController = new SaveController();
		IHistoryController historyController = new HistoryController();
		IBoardController boardController = new BoardController();

		SavePanel savePanel = new SavePanel(saveController);
		HistoryPanel historyPanel = new HistoryPanel(historyController);
		BoardPanel boardPanel = new BoardPanel(boardController, 3);

		saveController.setView(savePanel);
		historyController.setView(historyPanel);

		boardController.setGame(game);
		boardController.setView(boardPanel);

		historyController.setGame(game);
		historyController.setGameHistory(gameHistory);
		historyController.setView(historyPanel);
		historyController.setGameInitFactory(gameInitFactory);

		saveController.setGame(game);
		saveController.setGameHistory(gameHistory);
		saveController.setGameSaveRepository(new GameSaveRepository());

		IGameController gameController = new GameController();

		GameWindow mainWindow = new GameWindow(boardPanel, savePanel, historyPanel);

		gameController.setGame(game);
		gameController.setGameHistory(gameHistory);
		gameController.setHistoryController(historyController);
		gameController.setSaveController(saveController);
		gameController.setBoardController(boardController);
		gameController.setView(mainWindow);
		gameController.setStateMapper(new StateMapper());

		gameController.play();

	}

}
