package saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameSaveRepository implements Serializable, IGameSaveRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5880274844391104904L;
	private List<GameSave> gameSaves;
	private static String folder = "playerdata\\savedgames";
	private File file;

	@Override
	public void addSave(GameSave g) {
		writeToFile(g);
	}

	private void writeToFile(GameSave gs) {
		new File(folder).mkdirs();
		file = new File(folder + "\\" + gs.getFilename() + ".txt");

		try {
			file.createNewFile();
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fs);

			out.writeObject(gs);

			fs.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GameSave getGameSave(int i) throws ClassNotFoundException {
		loadFromFile();
		return gameSaves.get(i);
	}

	@Override
	public List<GameSave> getListOfSaves() throws ClassNotFoundException {
		loadFromFile();
		return gameSaves;
	}

	private void loadFromFile() throws ClassNotFoundException {
		file = new File(folder);
		File[] files = file.listFiles();
		gameSaves = new ArrayList<GameSave>();

		try {
			FileInputStream fi;
			ObjectInputStream in;
			for (File f : files) {
				fi = new FileInputStream(f);
				in = new ObjectInputStream(fi);

				gameSaves.add((GameSave) in.readObject());

				fi.close();
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
