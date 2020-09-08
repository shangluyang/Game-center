package uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;

/**
 * Enemy is a child class of the SnakeGameComponent, which represents an enemy of the snake.
 * The game ends if an enemy runs into the snake, i.e. move to the same location on the screen.
 */
public class Enemy extends SnakeGameComponent {
    /**
     * Construct a new Enemy Object on the screen at the location specified by the parameters.
     */
    public Enemy(int x, int y) {
        super(x, y);
        setAppearance("enemy");
    }
}
