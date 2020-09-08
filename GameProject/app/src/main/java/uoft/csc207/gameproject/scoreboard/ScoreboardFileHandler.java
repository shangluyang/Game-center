package uoft.csc207.gameproject.scoreboard;

import android.os.Environment;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uoft.csc207.gameproject.GameApplication;

/**
 * Handles the saving and loading of scoreboard file.
 */
class ScoreboardFileHandler {
	private static final String FILE_NAME = "Scoreboards.json";
	private Map<String, Scoreboard> scoreboards;

	/**
	 * Construct a new ScoreboardFileHandler.
	 */
	ScoreboardFileHandler() {
		scoreboards = new HashMap<String, Scoreboard>();
	}

	/**
	 * Return the scoreboards of the games.
	 */
	Map<String, Scoreboard> getScoreboards() {
		return scoreboards;
	}

	/**
	 * Set the scoreboards to the input parameter.
	 */
	void setScoreboards(Map<String, Scoreboard> scoreboards) {
		this.scoreboards = scoreboards;
	}

	/**
	 * Load all the scoreboards from the file.
	 */
	void loadFromFile() {
		try {
			File directory = GameApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
			File source = new File(directory, FILE_NAME);
			Map<String, Scoreboard> scoreboards = new HashMap<String, Scoreboard>();
			if (source.exists()) {
				JsonReader reader = new JsonReader(new FileReader(source));
				reader.beginArray();
				while (reader.hasNext()) {
					Scoreboard scoreboard = readScoreboard(reader);
					scoreboards.put(scoreboard.getName(), scoreboard);
				}
				reader.endArray();
				reader.close();
			} else {
				source.createNewFile();
			}
			this.scoreboards = scoreboards;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save the scoreboards to the file.
	 */
	void saveToFile() {
		try {
			File directory = GameApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
			File target = new File(directory, FILE_NAME);
			if (!target.exists()) {
				target.createNewFile();
			}
			JsonWriter writer = new JsonWriter(new FileWriter(target));
			writer.setIndent("    ");
			writer.beginArray();
			for (Scoreboard scoreboard : scoreboards.values()) {
				writeScoreboard(writer, scoreboard);
			}
			writer.endArray();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads a scoreboard from the JsonReader and returns the scoreboard. Can cause IOException
	 * while using the JsonReader.
	 */
	private Scoreboard readScoreboard(JsonReader reader) throws IOException {
		String scoreboardName = null;
		List<Score> scores = null;
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("Name")) {
				scoreboardName = reader.nextString();
			} else if (name.equals("Scores") && reader.peek() != JsonToken.NULL) {
				scores = readScoreList(reader);
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return new Scoreboard(scoreboardName, scores);
	}

	/**
	 * Read the list of scores for a scoreboard from the JsonReader. Can cause IOException
	 * while using the JsonReader.
	 */
	private List<Score> readScoreList(JsonReader reader) throws IOException {
		List<Score> scores = new ArrayList<Score>();
		reader.beginArray();
		while (reader.hasNext()) {
			Score score = readScore(reader);
			scores.add(score);
		}
		reader.endArray();
		return scores;
	}

	/**
	 * Read a single score entry from the JsonReader. Can cause IOException while using
	 * the JsonReader.
	 */
	private Score readScore(JsonReader reader) throws IOException {
		String user = null;
		int score = -1;
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("Name")) {
				user = reader.nextString();
			} else if (name.equals("Score")) {
				score = reader.nextInt();
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();
		return new Score(user, score);
	}

	/**
	 * Write the scoreboard in the input parameter to file using the JsonWriter.
	 */
	private void writeScoreboard(JsonWriter writer, Scoreboard scoreboard) throws IOException {
		writer.beginObject();
		writer.name("Name").value(scoreboard.getName());
		if (scoreboard.getScoreList() != null) {
			writer.name("Scores");
			writeScoresList(writer, scoreboard.getScoreList());
		} else {
			writer.name("Scores").nullValue();
		}
		writer.endObject();
	}

	/**
	 * Write the list of scores in the input parameter to file using the JsonWriter.
	 */
	private void writeScoresList(JsonWriter writer, List<Score> scoreList) throws IOException {
		writer.beginArray();
		for (Score score : scoreList) {
			writer.beginObject();
			writer.name("Name").value(score.getName());
			writer.name("Score").value(score.getScore());
			writer.endObject();
		}
		writer.endArray();
	}
}
