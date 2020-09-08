package uoft.csc207.gameproject.game.snake.snakepresenter.snakestrategies;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.List;

import uoft.csc207.gameproject.game.GameView;
import uoft.csc207.gameproject.game.snake.snakeconstants.ImageFactory;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameComponent;
import uoft.csc207.gameproject.game.snake.snakemodel.SnakeGameState;
import uoft.csc207.gameproject.game.snake.snakemodel.gamecomponent.Food;
/**
 * The SnakeDrawStrategy is the strategy that decides how the components of the game will be draw.
 */
public class SnakeDrawStrategy {
    /**
     * initialize the ImageFactory to load the image according to the appearance of the game component.
     */
    private ImageFactory images = new ImageFactory();

    public void draw(Canvas canvas, GameView view, SnakeGameState gameState) {
        SnakeGameComponent head = gameState.getSnake().getHead();
        Food food = gameState.getFood();
        List<SnakeGameComponent> bodies = gameState.getSnake().getBody();
        List<SnakeGameComponent> walls = gameState.getWalls();
        List<SnakeGameComponent> enemies = gameState.getEnemies();
        drawComponent(canvas, food);
        drawComponent(canvas, head);
        drawSet(canvas, view, bodies);
        drawSet(canvas, view, walls);
        drawSet(canvas, view, enemies);
    }

    //draw the list of component on the screen.
    private void drawSet(Canvas canvas, GameView view, List<SnakeGameComponent> componentList) {
        int index = 0;
        while (index < componentList.size()){
            drawComponent(canvas, componentList.get(index));
            index++;
        }
    }

    //draw the component on the screen.
    private void drawComponent(Canvas canvas, SnakeGameComponent component) {
        Bitmap bitmap = images.getImageFactory().get(component.getAppearance());
        Rect rect = new Rect(component.getX(), component.getY(), component.getX() + 50, component.getY() + 50);
        if(bitmap != null) {
            canvas.drawBitmap(bitmap, null, rect, new Paint());
        }
    }
}
