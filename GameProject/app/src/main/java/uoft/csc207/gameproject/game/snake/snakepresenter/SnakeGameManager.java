package uoft.csc207.gameproject.game.snake.snakepresenter;

import android.content.Context;
import android.graphics.Canvas;

import uoft.csc207.gameproject.game.GameView;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakefactories.SnakeGameGeneratorStrategyFactory;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeDrawStrategy;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameController;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameGeneratorStrategy;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameMoveStrategy;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameSaveStrategy;


public class SnakeGameManager {
    /**
     * the game state of the game.
     */
    private static SnakeGameState gameState = new SnakeGameState();
    private Context context;
    /**
     * strategy with methods that decides how the game will be draw. .
     */
    private SnakeDrawStrategy snakeDrawStrategy = new SnakeDrawStrategy();
    /**
     * strategy with methods that decides how the game will be saved or loaded. .
     */
    private SnakeGameSaveStrategy snakeGameSaveStrategy = new SnakeGameSaveStrategy();
    /**
     * strategy with methods that decides how the game will be draw. .
     */
    private SnakeGameMoveStrategy snakeGameMoveStrategy = new SnakeGameMoveStrategy();
    /**
     * strategy with methods that decides how the game will be controlled by player. .
     */
    private SnakeGameController snakeGameController = new SnakeGameController();
    /**
     * strategy with methods that decides how the game will be started. .
     */
    private SnakeGameGeneratorStrategy snakeGameGeneratorStrategy;
    /**
     * Initialize a new SnakeGameManager class.
     */
	public SnakeGameManager(Context context) {
        this.context = context;
    }

    /**
	 * continue the last unfinished game.
     */
	public void resumeGame() {
        gameState = snakeGameSaveStrategy.resumeGame(context);
    }

    /**
	 * save the game state file.
     */
	public void saveGame() {
        snakeGameSaveStrategy.saveGame(context,gameState);
    }

    /**
	 * draw the game on the screen.
     */
	public void draw(Canvas canvas, GameView view) {
        snakeDrawStrategy.draw(canvas,view,gameState);
    }

    /**
	 * create a new game
     */
	public void newGame(String level) {
        snakeGameGeneratorStrategy = (new SnakeGameGeneratorStrategyFactory()).createSnakeGameGeneratorStrategy(level);
        startGame();
    }
    /**
     * start the game with a new game with last level played.
     */
    private void startGame(){
        gameState = new SnakeGameState();
        snakeGameGeneratorStrategy.newGame(gameState);
        snakeGameMoveStrategy.shuffleFood(gameState);
    }

    /**
     * restart the game.
     */
	public void reconstruct() {
		startGame();
	}


    /**
	 * update the game state.
     */
	public void move() {
            snakeGameMoveStrategy.move(gameState);
        }

    /**
     * Responds to the touch event received from the phone.
     *
     * @param x The x coordinate of the touch event
     * @param y The y coordinate of the touch event
     */
	public void playerMove(float x, float y) {
        snakeGameController.playerMove(x,y,gameState);
    }


	/**
     * Get the score of the current snake game.
     *
     * @return The amount of foods eaten during the current game.
     */
	public int getScore() {
        return gameState.getSnake().getBodyLength() - 2;
    }
    /**
     * return whether the game is over..
     */
	public boolean isFailed() {
        return gameState.isFailed();
    }
}
