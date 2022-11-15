package validators;

import java.util.function.Predicate;

import models.Cell;
import tictactoe.Board;

public class WinValidator implements Predicate<Board>{

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
			Cell rowCellType = board.getCell(row, 0);
			winningRow = true;
			for (int col = 1; col < cols; col++) {
				if (! board.getCell(row, col).getClass().equals(rowCellType.getClass()) ) {
					winningRow = false;
					continue;
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
			Cell colCellType = board.getCell(0, col);
			winningCol = true;
			for (int row = 1; row < rows; row++) {
				if (! board.getCell(row, col).getClass().equals(colCellType.getClass()) ) {
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
				if (board.getCell(row + col, col).getClass().equals(currCellType.getClass())) {
					chainSize++;
				} else {
					chainSize = 1;
					currCellType = board.getCell(row + col, col);
				}
			}
			
			for (int col = 1; (col < cols) && (row - col > 0) && (chainSize < winningChainSize); col++) {
				if (board.getCell(row - col, col).getClass().equals(currCellType.getClass())) {
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
