package tictactoe;

public interface ObservableGame {
	public void addSubscriber(GameObserver observer);
	public void removeSubscriber(GameObserver observer);
}
