package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies;

import java.util.List;

import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
/**
 * strategy with methods that decides how the game component will be detected that they collided. .
 */
class SnakeGameCollisionStrategy {
    //detect whether the component meet something that will end the game.
    Boolean isCrash(SnakeGameComponent component, SnakeGameState gameState) {
        List<SnakeGameComponent> bodies = gameState.getSnake().getBody();
        List<SnakeGameComponent> walls = gameState.getWalls();
        List<SnakeGameComponent> enemies = gameState.getEnemies();
        return (isSamePosition(component, bodies, 1) ||isSamePosition(component, walls, 0) || isSamePosition(component, enemies,0));
    }

    //detect whether the component meet something in the componentList.
    private Boolean isSamePosition(SnakeGameComponent component, List<SnakeGameComponent> componentsList, int initialIndex){
        for (int index = initialIndex; index < componentsList.size(); index++) {
            if (component.getX() == componentsList.get(index).getX() && component.getY() == componentsList.get(index).getY()) {
                return true;
            }
        }
        return false;
    }

    //detect whether the component meet something in the componentList after it moved.
    Boolean isOverlapped(SnakeGameComponent component, List<SnakeGameComponent> componentsList){
        int overlapNum = 0;
        for (int index = 0; index < componentsList.size(); index++) {
            if (component.getX() == componentsList.get(index).getX() && component.getY() == componentsList.get(index).getY()) {
                overlapNum++;
            }
        }
        return (overlapNum > 1);
    }
}
