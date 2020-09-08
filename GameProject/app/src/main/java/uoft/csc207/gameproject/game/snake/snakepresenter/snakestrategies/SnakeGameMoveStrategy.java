package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies;

import java.util.List;
import java.util.Random;

import uoft.csc207.gameproject.game.snake.snakeconstants.Direction;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Food;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeBody;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeHead;

import static java.lang.Math.abs;
/**
 * strategy with methods that decides how the game will be run. .
 */
public class SnakeGameMoveStrategy {
	private Direction directions = new Direction();
	private SnakeGameCollisionStrategy snakeGameCollisionStrategy = new SnakeGameCollisionStrategy();

	public void move(SnakeGameState gameState) {
		List<SnakeGameComponent> enemies = gameState.getEnemies();
		int index = 0;
		while (index < enemies.size() && !gameState.isFailed()) {
			chaseSnake(enemies.get(index), gameState);
			while (snakeGameCollisionStrategy.isOverlapped(enemies.get(index), enemies)) {
				chaseSnake(enemies.get(index), gameState);
			}
			index++;
			gameState.setFailed(snakeGameCollisionStrategy.isCrash(gameState.getSnake().getHead(), gameState));
		}
		if (gameState.getSnake().getHead().getX() == gameState.getFood().getX() & gameState.getSnake().getHead().getY() == gameState.getFood().getY()) {
			shuffleFood(gameState);
			gameState.setExtendBody(true);
		}
		if (gameState.isExtendBody()) {
			int bodyLength = gameState.getSnake().getBodyLength();
			List<SnakeGameComponent> bodies = gameState.getSnake().getBody();
			bodies.add(new SnakeBody(bodies.get(0).getX(), bodies.get(0).getY()));
			gameState.getSnake().setBodyLength(bodyLength + 1);
			gameState.setExtendBody(!gameState.isExtendBody());
		}
		if (!gameState.isFailed()) {
			moveSnake(gameState);
			gameState.setFailed(snakeGameCollisionStrategy.isCrash(gameState.getSnake().getHead(), gameState));
		}
	}

	//move the component towards the snake.
	private void chaseSnake(SnakeGameComponent component, SnakeGameState gameState) {
		int xDistance = gameState.getSnake().getHead().getX() - component.getX();
		int yDistance = gameState.getSnake().getHead().getY() - component.getY();
		if (abs(xDistance) > abs(yDistance)) {
			if (xDistance > 0) {
				component.setX(component.getX() + 50);
			} else {
				component.setX(component.getX() - 50);
			}
		} else if (!(xDistance == 0 && yDistance == 0)) {
			if (yDistance > 0) {
				component.setY(component.getY() + 50);
			} else {
				component.setY(component.getY() - 50);
			}
		}
	}

	// move snake
	private void moveSnake(SnakeGameState gameState) {
		int bodyLength = gameState.getSnake().getBodyLength();
		List<SnakeGameComponent> bodies = gameState.getSnake().getBody();
		SnakeHead head = (SnakeHead) gameState.getSnake().getHead();
		for (int index = bodyLength - 1; index > 0; index--) {
			SnakeGameComponent previousBody = bodies.get(index - 1);
			//set body coordinate to previous body cooridinates
			bodies.get(index).setX(previousBody.getX());
			bodies.get(index).setY(previousBody.getY());
		}
		int[] direction = directions.getDirectionCoordinate(head.getDirection());
		moveComponent(head, direction[0], direction[1]);
		teleportComponent(head);
	}

	//move the game component.
	private void moveComponent(SnakeGameComponent component, int xVelocity, int yVelocity) {
		component.setX(component.getX() + xVelocity);
		component.setY(component.getY() + yVelocity);
	}

	//teleport the component to another side of the screen when it goes out of the screen.
	private void teleportComponent(SnakeGameComponent component) {
		if (component.getX() < 30) {
			component.setX(980);
		} else if (component.getX() > 980) {
			component.setX(30);
		} else if (component.getY() < 28) {
			component.setY(1978);
		} else if (component.getY() > 1978) {
			component.setY(28);
		}
	}

	public void shuffleFood(SnakeGameState gameState) {
		Food food = gameState.getFood();
		Random random = new Random();
		food.setX(30 + 50 * random.nextInt(20));
		food.setY(28 + 50 * random.nextInt(40));
		while (snakeGameCollisionStrategy.isCrash(food, gameState)) {
			food.setX(30 + 50 * random.nextInt(20));
			food.setY(28 + 50 * random.nextInt(40));
		}
	}

	public SnakeGameCollisionStrategy getSnakeGameCollisionStrategy() {
		return snakeGameCollisionStrategy;
	}

	public void setSnakeGameCollisionStrategy(SnakeGameCollisionStrategy snakeGameCollisionStrategy) {
		this.snakeGameCollisionStrategy = snakeGameCollisionStrategy;
	}
}
