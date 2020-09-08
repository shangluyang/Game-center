package uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
/**
 * Wall is a child class of SnakeGameComponent, which represents wall that if snake head meets it, then game over.
 */
public class Wall extends SnakeGameComponent {
	/**
	 * Construct a new Wall object on the screen at the location specified by the parameters.
	 */
	public Wall(int x, int y) {
		super(x, y);
		setAppearance("wall");
	}
}
