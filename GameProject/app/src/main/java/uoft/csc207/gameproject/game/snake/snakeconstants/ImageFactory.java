package uoft.csc207.gameproject.game.snake.snakeconstants;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;

/**
 * ImageFactory contains all the Bitmap resources required by the snake game.
 */
public class ImageFactory {
    /**
     * load the images of snake game.
     */
    private static final Bitmap BODY  = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_body);
    private static final Bitmap UP = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_up);
    private static final Bitmap DOWN = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_down);
    private static final Bitmap RIGHT = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_right);
    private static final Bitmap LEFT = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_left);
    private static final Bitmap FOOD = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_food);
    private static final Bitmap ENEMY = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_enemy);
    private static final Bitmap WALL = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.snake_wall);
    /**
     * initialize a map of string(appearance) and image.
     */
    private HashMap<String, Bitmap> imageFactory = new HashMap<>();;

    /**
     * Construct a new ImageFactory object.
     */
    public ImageFactory() {
        createImage();
    }

    /**
     * Returns the HashMap that the keys are string of Bitmap and values are the Bitmaps.
     */
    public HashMap<String, Bitmap> getImageFactory() {
        return imageFactory;
    }

    /**
     * Constructs the HashMap of the Bitmaps.
     */
    private void createImage(){
        imageFactory.put("up", UP);
        imageFactory.put("body", BODY);
        imageFactory.put("down",DOWN);
        imageFactory.put("enemy", ENEMY);
        imageFactory.put("right", RIGHT);
        imageFactory.put("left", LEFT);
        imageFactory.put("wall", WALL);
        imageFactory.put("food", FOOD);
    }
}


