package tictactoe;

import models.Cell;

public class Player {
    
    String name;
    Cell cell;

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
