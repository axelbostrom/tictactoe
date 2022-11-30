package models;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.Arrays;

public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1396681406300551565L;
	private Cell[] cells;
	private Dimension size;

	public Board(Dimension size) {

		if (size.width <= 0 || size.height <= 0) {
			throw new IllegalArgumentException("Size needs to be non-zero and positive!");
		}

		this.size = new Dimension(size);
		cells = new Cell[size.height * size.width];
		Arrays.fill(cells, new EmptyCell());
	}

	public Board(Board other) {

		size = new Dimension(other.size);
		cells = other.cells.clone();
	}

	private int getIdx(int row, int col) {
		return row * size.width + col;
	}

	public void setCell(int row, int col, Cell cell) {
		cells[getIdx(row, col)] = cell;
	}

	public Cell getCell(int row, int col) {
		return cells[getIdx(row, col)];
	}

	public Dimension getSize() {
		return new Dimension(size);
	}

	public boolean isEmpty(int row, int col) {
		return cells[getIdx(row, col)].isEmpty();
	}
}
