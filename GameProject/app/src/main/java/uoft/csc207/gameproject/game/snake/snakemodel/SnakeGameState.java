package uoft.csc207.gameproject.game.snake.snakemodel;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uoft.csc207.gameproject.game.GameState;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Food;
import uoft.csc207.gameproject.game.snake.snakepresenter.Snake;
/**
 * the state of the game.
 */
public class SnakeGameState extends GameState implements Serializable {
	/**
	 * the current snake object of the game.
	 */
	private Snake snake = new Snake();

	/**
	 * the current food object of the game .
	 */
	private Food food = new Food(30, 28);

	/**
	 * the current level of the game.
	 */
	private String level = "1";

	/**
	 * the boolean shows that whether game is over.
	 */
	private boolean isFailed = false;

	/**
	 * the boolean shows that whether snake is going to increase size.
	 */
	private boolean isExtendBody = false;

	/**
	 * list of wall game components in the current game.
	 */
	private List<SnakeGameComponent> walls = new ArrayList<>();

	/**
	 * list of enemy game components in the current game.
	 */
	private List<SnakeGameComponent> enemies = new ArrayList<>();

	/**
	 * return the list of wall component of the current game.
	 */
	public List<SnakeGameComponent> getWalls() {
		return walls;
	}

	/**
	 * return the list of enemy component of the current game.
	 */
	public List<SnakeGameComponent> getEnemies() {
		return enemies;
	}

	/**
	 * return the level name of the current game.
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * set the level name of the current game.
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * return snake object of the current game.
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * set the snake object of the current game.
	 */
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	/**
	 * return food component of the current game.
	 */
	public Food getFood() {
		return food;
	}

	/**
	 * return the isFailed of this SnakeGameState.
	 */
	public boolean isFailed() {
		return isFailed;
	}

	/**
	 * set the isFailed of this SnakeGameState.
	 */
	public void setFailed(boolean failed) {
		isFailed = failed;
	}

	/**
	 * return the isExtendBody of this SnakeGameState.
	 */
	public boolean isExtendBody() {
		return isExtendBody;
	}

	/**
	 * set the isExtendBody of this SnakeGameState.
	 */
	public void setExtendBody(boolean extendBody) {
		isExtendBody = extendBody;
	}

	/**
	 * set the direction of snake object in this SnakeGameState.
	 */
	public void setDirection(String direction) {
		snake.setDirection(direction);
	}
}
