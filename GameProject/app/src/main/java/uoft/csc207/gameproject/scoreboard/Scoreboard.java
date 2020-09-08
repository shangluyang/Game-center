package uoft.csc207.gameproject.scoreboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the scoreboard of a game.
 */
public class Scoreboard {
	/**
	 * Represents the size of each scoreboard, i.e. the number of entries (username, score)
	 * allowed in one scoreboard.
	 */
	private static final int SCOREBOARD_SIZE = 5;

	private String name;
	private List<Score> scoreList;

	/**
	 * Construct a new scoreboard with name only. The list of scores will be an empty arraylist.
	 */
	Scoreboard(String name) {
		this(name, null);
	}

	/**
	 * Construct a new scoreboard with name and list of scores.
	 */
	Scoreboard(String name, List<Score> scoreList) {
		this.name = name;
		if (scoreList == null) {
			this.scoreList = new ArrayList<>();
		} else {
			this.scoreList = scoreList;
		}
	}

	/**
	 * Return the name of the scoreboard.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the scoreboard to the desired name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the list of scores shown on the scoreboard.
	 */
	public List<Score> getScoreList() {
		return scoreList;
	}

	/**
	 * Update the scoreboard by adding a new score entry to the scoreboard. Maintain the size
	 * of the scoreboard within the allowed size.
	 */
	void update(Score score) {
		if (score.getScore() < 0) {
			return;
		}
		int index = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			Score item = scoreList.get(i);
			if (score.getScore() >= item.getScore()) {
				index = i;
			}
		}
		scoreList.add(index, score);
		if (scoreList.size() > SCOREBOARD_SIZE) {
			scoreList.remove(scoreList.size() - 1);
		}
	}
}
