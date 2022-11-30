package validators;

import java.io.Serializable;
import java.util.function.Predicate;

import models.Board;
import models.Cell;

public class WinValidator implements Predicate<Board>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -249275397516363198L;
	int winningChainSize = 3;

	@Override
	public boolean test(Board board) {
		return checkRows(board) || checkCols(board) || checkDiags(board);
	}

	private boolean checkRows(Board board) {
		int cols = board.getSize().width;
		int rows = board.getSize().height;
		boolean winningRow = false;

		for (int row = 0; row < rows && !winningRow; row++) {
			if (board.isEmpty(row, 0)) {
				continue;
			}
			Cell rowCellType = board.getCell(row, 0);
			winningRow = true;
			for (int col = 1; col < cols; col++) {
				if (!board.getCell(row, col).getClass().equals(rowCellType.getClass())) {
					winningRow = false;
					break;
				}
			}
		}
		return winningRow;
	}

	private boolean checkCols(Board board) {
		int cols = board.getSize().width;
		int rows = board.getSize().height;
		boolean winningCol = false;

		for (int col = 0; col < cols && !winningCol; col++) {
			if (board.isEmpty(0, col)) {
				continue;
			}
			Cell colCellType = board.getCell(0, col);
			winningCol = true;
			for (int row = 1; row < rows; row++) {
				if (!board.getCell(row, col).getClass().equals(colCellType.getClass())) {
					winningCol = false;
					continue;
				}
			}
		}
		return winningCol;
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
