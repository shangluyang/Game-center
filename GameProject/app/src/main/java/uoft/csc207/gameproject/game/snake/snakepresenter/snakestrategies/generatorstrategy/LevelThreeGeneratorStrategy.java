package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.generatorstrategy;

import java.util.List;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakefactories.SnakeGameComponentFactory;
import uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies.SnakeGameGeneratorStrategy;
/**
 * The Strategy of new game will be generated in snake game level "3".
 */
public class LevelThreeGeneratorStrategy extends SnakeGameGeneratorStrategy {
    /**
     * initialize a SnakeGameComponentFactory to create the components in new game.
     */
    private SnakeGameComponentFactory snakeGameComponentFactory = new SnakeGameComponentFactory();
    /**
     * create the components in the new game.
     */
	public void newGame(SnakeGameState gameState) {
        gameState.setLevel("3");
        List<SnakeGameComponent> enemies = gameState.getEnemies();
        enemies.add(snakeGameComponentFactory.createSnakeGameComponent("enemy", 730+50,828+50));
        enemies.add(snakeGameComponentFactory.createSnakeGameComponent("enemy",530+50,528+50));
        enemies.add(snakeGameComponentFactory.createSnakeGameComponent("enemy",630+50,628+50));
        enemies.add(snakeGameComponentFactory.createSnakeGameComponent("enemy",1030+50,1028+50));
	}
}

