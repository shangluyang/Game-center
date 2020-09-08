package uoft.csc207.gameproject.game.snake.snakepresenter.snakefactories;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Enemy;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Food;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeBody;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.SnakeHead;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Wall;

/**
 * SnakeGameComponentFactory implements the Factory design pattern, which takes the information
 * of the desired component as parameters and returns a SnakeGameComponent.
 */
public class SnakeGameComponentFactory {
    /**
     * return a new SnakeGameComponent with required type, return null if type is unknown.
     */
    public SnakeGameComponent createSnakeGameComponent(String type, int x, int y){
        switch (type){
            case "body":
                return new SnakeBody(x, y);
            case "head":
                return new SnakeHead();
            case "enemy":
                return new Enemy(x, y);
            case "wall":
                return new Wall(x,y);
            case "food":
                return new Food(x,y);
            default:
                return null;
        }
    }
}


