package uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
/**
 * SnakeHead is a child class of SnakeGameComponent, which represents snake's head.
 */
public class SnakeHead extends SnakeGameComponent {
    //initialize the direction with "right"
    private String direction = "right";
    /**
     * Constructs the SnakeHead object at (80,128).
     */
    public SnakeHead() {
        super(80, 128);
        setAppearance("right");
    }

    /**
     * return the direction of this SnakeHead object.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * set the direction of this SnakeHead object.
     */
    public void setDirection(String direction) {
            this.direction = direction;
            this.setAppearance(direction);
    }
}
