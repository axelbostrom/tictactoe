package tictactoe;

public class GameState {

    Board currBoard;
    Player currPlayer;
    //Winvalidator
    
    public GameState(Board currBoard, Player currPlayer) {
        this.currBoard = currBoard;
        this.currPlayer = currPlayer;
    }

    public Board getCurrBoard() {
        return currBoard;
    }
    public void setCurrBoard(Board currBoard) {
        this.currBoard = currBoard;
    }
    public Player getCurrPlayer() {
        return currPlayer;
    }
    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

}
