package uoft.csc207.gameproject.game.snake.snakemodel;

import java.io.Serializable;
/**
 * SnakeGameComponent is a superclass of object that will affect snake game and appear one the screen.
 */
public class SnakeGameComponent implements Serializable {
	/**
	 * the coordinate of this component
	 */
	private int x;
	private int y;
	/**
	 * the appearance of this component
	 */
	private String appearance;

	/**
	 * Construct a new SnakeGameComponent object.
	 */
	public SnakeGameComponent(int xCoordinate, int yCoordinate) {
		this.x = xCoordinate;
		this.y = yCoordinate;
	}

	/**
	 * return the x-coordinate of this SnakeGameComponent.
	 */
	public int getX() {
		return x;
	}

	/**
	 * return the y-coordinate of this SnakeGameComponent.
	 */
	public int getY() {
		return y;
	}

	/**
	 * set the x-coordinate of this SnakeGameComponent.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * set the y-coordinate of this SnakeGameComponent.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * set the appearance of this SnakeGameComponent.
	 */
	protected void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	/**
	 * return the appearance of this SnakeGameComponent.
	 */
	public String getAppearance() {
		return appearance;
	}
}

