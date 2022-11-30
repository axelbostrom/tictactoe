package validators;

import java.io.Serializable;

import models.Board;
import models.Cell;

public class WinValidator implements Serializable, IWinValidator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -249275397516363198L;
	int winningChainSize;

	public WinValidator(int winningChainSize) {
		this.winningChainSize = winningChainSize;
	}

	@Override
	public boolean test(Board board) {
		return checkRows(board) || checkCols(board) || checkDiags(board);
	}

	private boolean checkRows(Board board) {
		int cols = board.getSize().width;
		int rows = board.getSize().height;
		Cell currCellType;
		int chainSize = 1;

		for (int row = 0; row < rows && chainSize < winningChainSize; row++) {
			currCellType = board.getCell(row, 0);
			chainSize = 1;
			for (int col = 1; col < cols && (chainSize < winningChainSize); col++) {
				if (!board.isEmpty(row, col) && board.getCell(row, col).getClass().equals(currCellType.getClass())) {
					chainSize++;
				} else {
					chainSize = 1;
					currCellType = board.getCell(row, col);
				}
			}
		}
		return chainSize >= winningChainSize;
	}

	private boolean checkCols(Board board) {
		int cols = board.getSize().width;
		int rows = board.getSize().height;
		Cell currCellType;
		int chainSize = 1;

		for (int col = 0; col < cols && chainSize < winningChainSize; col++) {
			currCellType = board.getCell(0, col);
			chainSize = 1;
			for (int row = 1; row < rows && (chainSize < winningChainSize); row++) {
				if (!board.isEmpty(row, col) && board.getCell(row, col).getClass().equals(currCellType.getClass())) {
					chainSize++;
				} else {
					chainSize = 1;
					currCellType = board.getCell(row, col);
				}
			}
		}
		return chainSize >= winningChainSize;
	}

	private boolean checkDiags(Board board) {
		int cols = board.getSize().width;
		int rows = board.getSize().height;
		Cell currCellType;
		int chainSize = 1;

		for (int row = 0; row < rows && chainSize < winningChainSize; row++) {
			currCellType = board.getCell(row, 0);
			chainSize = 1;
			for (int col = 1; (col < cols) && (row + col < rows) && (chainSize < winningChainSize); col++) {
				if (!board.isEmpty(row + col, col)
						&& board.getCell(row + col, col).getClass().equals(currCellType.getClass())) {
					chainSize++;
				} else {
					chainSize = 1;
					currCellType = board.getCell(row + col, col);
				}
			}

			currCellType = board.getCell(row, 0);

			for (int col = 1; (col < cols) && (row - col >= 0) && (chainSize < winningChainSize); col++) {
				if (!board.isEmpty(row - col, col)
						&& board.getCell(row - col, col).getClass().equals(currCellType.getClass())) {
					chainSize++;
				} else {
					chainSize = 1;
					currCellType = board.getCell(row - col, col);
				}
			}
		}
		return chainSize >= winningChainSize;
	}

}
