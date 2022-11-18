package tictactoe;

import java.io.Serializable;

import models.Cell;

public class Player implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 5226483868420288476L;
	private String name;
    private Cell cell;

    public Player(String name, Cell cell) {
        this.name = name;
        this.cell = cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}
    
    

}
