package uoft.csc207.gameproject.scoreboard;

import java.util.Comparator;

/**
 * Represents an entry of score on the Scoreboard.
 */
public class Score {
	private String name;
	private int score;

	/**
	 * Constructs a new Score with name and score.
	 */
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * Returns the name of the user who achieved the score.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the score of the record.
	 */
	public int getScore() {
		return score;
	}

	public static class SortByScore implements Comparator<Score> {
		@Override
		public int compare(Score o1, Score o2) {
			return o1.getScore() - o2.getScore();
		}
	}
}
