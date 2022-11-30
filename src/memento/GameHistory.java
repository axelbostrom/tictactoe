package memento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5235180427689906260L;
	private List<GameMemento> mementos;
	private int currentIndex;

	public GameHistory() {
		clear();
	}

	public GameHistory(GameMemento initialSnapshot) {
		clear();
		addSnapshot(initialSnapshot);
	}

	public void loadOtherHistory(GameHistory other) {
		this.mementos = other.mementos;
		this.currentIndex = other.currentIndex;
	}

	public GameMemento getCurrentSnapshot() {
		return mementos.get(currentIndex);
	}

	public void clear() {
		mementos = new ArrayList<>();
		currentIndex = -1;
	}

	public void addSnapshot(GameMemento memento) {

		if (currentIndex < mementos.size() - 1) {
			mementos.removeAll(mementos.subList(currentIndex + 1, mementos.size()));
		}
		mementos.add(memento);
		currentIndex++;
	}

	public GameMemento getNextSnapshot() {
		if (currentIndex < mementos.size() - 1) {
			currentIndex++;
			return getCurrentSnapshot();
		} else {
			return getCurrentSnapshot();
		}
	}

	public GameMemento getPreviousSnapshot() {
		if (currentIndex > 0) {
			currentIndex--;
			return getCurrentSnapshot();
		} else {
			return getCurrentSnapshot();
		}
	}

}
