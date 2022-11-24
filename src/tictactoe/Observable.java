package tictactoe;

public interface Observable {
	public void notifySubscribers();

	public void addSubscriber(Observer observer);

	public void removeSubscriber(Observer observer);
}
