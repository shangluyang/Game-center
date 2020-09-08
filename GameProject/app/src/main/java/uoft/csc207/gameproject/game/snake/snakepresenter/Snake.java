package uoft.csc207.gameproject.game.snake.snakepresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeBody;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeHead;

/**
 * Represents the  in the snake game.
 */
public class Snake implements Serializable {
	/**
	 * List of bodies in this snake.
	 */
	private List<SnakeGameComponent> bodies;
	/**
	 * length of bodies in this snake.
	 */
	private int bodyLength = 2;
	/**
	 * snake head object in this Snake.
	 */
	private SnakeHead head = new SnakeHead();
	/**
	 * initialize the snake object.
	 */
	public Snake() {
		bodies = new ArrayList<>();
		bodies.add(head);
		bodies.add(new SnakeBody(30, 128));
	}
	/**
	 * set the direction of head of the snake.
	 */
	public void setDirection(String direction) {
		head.setDirection(direction);
	}
	/**
	 * return the length of the snake body.
	 */
	public int getBodyLength() {
		return bodyLength;
	}
	/**
	 * set the length of the snake body.
	 */
	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}
	/**
	 * return the head of the snake.
	 */
	public SnakeGameComponent getHead() {
		return head;
	}
	/**
	 * return the list of bodies of the snake.
	 */
	public List<SnakeGameComponent> getBody() {
		return bodies;
	}
}
