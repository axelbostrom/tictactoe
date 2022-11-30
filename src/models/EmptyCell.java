package models;

import java.io.Serializable;

public class EmptyCell implements Cell, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8400458713388640421L;

	@Override
	public boolean isEmpty() {
		return true;
	}

}
