package uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;

/**
 * Food is a child class of SnakeGameComponent, which represents a food in the game.
 * Eating a food elongates the snake by one unit.
 */
public class Food extends SnakeGameComponent {
    /**
     * Constructs the food on the screen at the location specified by the parameters.
     */
    public Food(int x, int y) {
        super(x, y);
        setAppearance("food");
    }
}
