package uoft.csc207.gameproject.game.snake.snakepresenter.snakefactories;

import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameGeneratorStrategy;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.generatorstrategy.LevelThreeGeneratorStrategy;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.generatorstrategy.LevelTwoGeneratorStrategy;

/**
 * SnakeGameGeneratorStrategyFactory implesments the Factory design pattern, which returns
 * a SnakeGameGeneratorStrategy based on the input parameter.
 */
public class SnakeGameGeneratorStrategyFactory {
    /**
     * return a new SnakeGameComponent with required type, return null if type is unknown.
     */
    public SnakeGameGeneratorStrategy createSnakeGameGeneratorStrategy(String level){
        switch (level){
            case "2":
                return new LevelTwoGeneratorStrategy();
            case "3":
                return new LevelThreeGeneratorStrategy();
            default:
                return new SnakeGameGeneratorStrategy();
        }
    }
}
