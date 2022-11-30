package saving;

import java.util.List;

public interface IGameSaveRepository {

	void addSave(GameSave g);

	GameSave getGameSave(int i) throws ClassNotFoundException;

	List<GameSave> getListOfSaves() throws ClassNotFoundException;

}