package uoft.csc207.gameproject.game;

import android.content.Context;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * The class used to save and load file for games..
 */
public class GameFileHandler {
	/**
	 * the game state loaded from file.
	 */
	private Object gameState;
	/**
	 * load the game state from file.
	 */
	public void loadGame(String filename, Context context) {
		try {
			InputStream inputStream = context.openFileInput(filename);
			if (inputStream != null) {
				ObjectInputStream input = new ObjectInputStream(inputStream);
				gameState = input.readObject();
				inputStream.close();
			}
		} catch (FileNotFoundException e) {
			Log.e("GameState", "FileNotFoundException");

		} catch (IOException e) {
			Log.e("GameState", "IOException");

		} catch (ClassNotFoundException e) {
			Log.e("GameState", "ClassNotFoundException");
		}
	}
	/**
	 * save the game state to the file.
	 */
	public void saveGame(String filename, Context context, GameState gameState) {
		try {
			ObjectOutputStream outputStream = new ObjectOutputStream(
					context.openFileOutput(filename, context.MODE_PRIVATE));
			outputStream.writeObject(gameState);
			outputStream.close();
		} catch (IOException e) {
			Log.e("Exception", "File write failed: " + e.toString());
		}
	}
	/**
	 * return the game state loaded.
	 */
	public Object getGameState() {
		return gameState;
	}
}
