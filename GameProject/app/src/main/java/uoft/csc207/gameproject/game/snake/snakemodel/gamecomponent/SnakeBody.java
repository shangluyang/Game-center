package uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;

/**
 * SnakeBody is a child class of SnakeGameComponent, which represents one part of the snake's body.
 */
public class SnakeBody extends SnakeGameComponent {
    /**
     * Constructs the SnakeBody object on the screen at the location specified by the parameters.
     */
    public SnakeBody(int x, int y) {
        super(x, y);
        setAppearance("body");
    }
}
