package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies;

import android.content.Context;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.game.GameFileHandler;
import uoft.csc207.gameproject.game.GameState;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
/**
 * strategy with methods that decides how the game will be save and loaded. .
 */
public class SnakeGameSaveStrategy {
	private static final String SUFFIX = "-snake-sav";
	private GameFileHandler fileHandler = new GameFileHandler();
	private static final String FILE = ".dat";

	/**
	 * continue the last unfinished game.
	 */
	public SnakeGameState resumeGame(Context context) {
		return loadGame(GameApplication.getInstance().getUserManager().getCurrentUser().getUsername() + SUFFIX + FILE, context);
	}

	/**
	 * load the game state file that saved.
	 */
	private SnakeGameState loadGame(String filename, Context context) {
		fileHandler.loadGame(filename, context);
		return (SnakeGameState) fileHandler.getGameState();
	}

	/**
	 * save the game state file.
	 */
	public void saveGame(Context context, GameState gameState) {
		fileHandler.saveGame(GameApplication.getInstance().getUserManager().getCurrentUser().getUsername() + SUFFIX + FILE, context, gameState);
	}
}
