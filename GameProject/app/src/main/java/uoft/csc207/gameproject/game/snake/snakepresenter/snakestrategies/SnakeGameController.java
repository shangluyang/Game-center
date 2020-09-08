package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeHead;
/**
 * strategy with methods that decides how the game will be controlled. .
 */
public class SnakeGameController {
	/**
	 * Responds to the touch event received from the phone.
	 *
	 * @param x         The x coordinate of the touch event
	 * @param y         The y coordinate of the touch event
	 * @param gameState The game state that the touch event will affect on.
	 */
	public void playerMove(float x, float y, SnakeGameState gameState) {
		if (((SnakeHead) gameState.getSnake().getHead()).getDirection().equals("left") || ((SnakeHead) gameState.getSnake().getHead()).getDirection().equals("right")) {
			moveVertical(y, gameState);
		} else if (((SnakeHead) gameState.getSnake().getHead()).getDirection().equals("up")) {
			if (gameState.getSnake().getHead().getX() > x) gameState.setDirection("left");
			else gameState.setDirection("right");
		} else {
			moveHorizontal(x, gameState);
		}
	}

	/**
	 * set the direction of snake into a vertical direction.
	 */
	private void moveVertical(float y, SnakeGameState gameState) {
		if (gameState.getSnake().getHead().getY() > y) gameState.setDirection("up");
		else gameState.setDirection("down");
	}

	/**
	 * set the direction of snake into a horizontal direction.
	 */
	private void moveHorizontal(float x, SnakeGameState gameState) {
		if (gameState.getSnake().getHead().getX() > x) gameState.setDirection("left");
		else gameState.setDirection("right");
	}
}
