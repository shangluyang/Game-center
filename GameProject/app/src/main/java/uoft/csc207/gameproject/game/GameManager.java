package uoft.csc207.gameproject.game;
/**
 * Abstract class of manager of games of snake and cat.
 */
public abstract class GameManager {
	/**
	 * game state of this game.
	 */
	private GameState gameState;

	/**
	 * return the game state.
	 */
	public GameState getGameState() {
		return gameState;
	}
	/**
	 * continue the game from last played condition.
	 */
	void resumeGame(){};
	/**
	 * set the game state of this GameManager.
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	/**
	 * save the game state to file.
	 */
	void saveGame(){};
}
