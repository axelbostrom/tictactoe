package tictactoe;

import java.util.ArrayList;

public class GameCaretaker {

    ArrayList<GameMemento> savedArticles = new ArrayList<GameMemento>();

    public void addMemento(GameMemento m) {
        savedArticles.add(m);
    }

    public GameMemento getMemento(int index) {
        return savedArticles.get(index);
    }
}
