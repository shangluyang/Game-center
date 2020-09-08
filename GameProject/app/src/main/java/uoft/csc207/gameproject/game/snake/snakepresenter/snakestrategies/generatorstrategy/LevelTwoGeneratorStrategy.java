package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.generatorstrategy;

import java.util.List;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakefactories.SnakeGameComponentFactory;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameGeneratorStrategy;

/**
 * The Strategy of new game will be generated in snake game level "2".
 */
public class LevelTwoGeneratorStrategy extends SnakeGameGeneratorStrategy {
    /**
     * initialize a SnakeGameComponentFactory to create the components in new game.
     */
    private SnakeGameComponentFactory snakeGameComponentFactory = new SnakeGameComponentFactory();
    /**
     * create the components in the new game.
     */
    public void newGame(SnakeGameState gameState) {
        gameState.setLevel("2");
        List<SnakeGameComponent> walls = gameState.getWalls();
        int index = 0;
        while (index <= 40){
            walls.add(snakeGameComponentFactory.createSnakeGameComponent("wall", 30 , 28 + 50 * index));
            walls.add(snakeGameComponentFactory.createSnakeGameComponent("wall", 1030 , 28 + 50 * index));
            index++;
        }
        index = 0;
        while (index<=15) {
            walls.add(snakeGameComponentFactory.createSnakeGameComponent("wall", 30 + 50 * index , 28 + 50 * 10));
            walls.add(snakeGameComponentFactory.createSnakeGameComponent("wall", 30 + 50 * index , 28 + 50 * 30));
            walls.add(snakeGameComponentFactory.createSnakeGameComponent("wall", 30 + 50 * (20 - index ), 28 + 50 * 20));
            index++;
        }
    }
}
