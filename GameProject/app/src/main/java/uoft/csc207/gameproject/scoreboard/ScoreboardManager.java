package uoft.csc207.gameproject.scoreboard;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the scoreboards of the games.
 */
public class ScoreboardManager {
	private Map<String, Scoreboard> scoreboards;
	private ScoreboardFileHandler fileHandler;

	/**
	 * Constructs a new ScoreboardManager. Creates the scoreboards for the games if it is the
	 * first time the application runs on the device.
	 */
	public ScoreboardManager() {
		scoreboards = new HashMap<String, Scoreboard>();
		fileHandler = new ScoreboardFileHandler();
		loadFromFile();
		if (scoreboards.size() == 0) {
			createScoreboard("Snake");
			createScoreboard("CatchCat");
			createScoreboard("Gamble");
			saveToFile();
		}
	}

	/**
	 * Create a new scoreboard with its name same as the input parameter.
	 */
	private boolean createScoreboard(String name) {
		if (scoreboards.containsKey(name)) {
			return false;
		} else {
			Scoreboard scoreboard = new Scoreboard(name);
			scoreboards.put(name, scoreboard);
			return true;
		}
	}

	/**
	 * Get the corresponding scoreboard with the name.
	 */
	public Scoreboard getScoreboard(String name) {
		return scoreboards.get(name);
	}

	/**
	 * Update the corresponding scoreboard with the name using the input score.
	 */
	public boolean updateScoreboard(String name, Score score) {
		if (scoreboards.containsKey(name)) {
			scoreboards.get(name).update(score);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Loads the scoreboards from file.
	 */
	private void loadFromFile() {
		fileHandler.loadFromFile();
		scoreboards = fileHandler.getScoreboards();
	}

	/**
	 * Saves the scoreboards to file.
	 */
	public void saveToFile() {
		fileHandler.setScoreboards(scoreboards);
		fileHandler.saveToFile();
	}
}
