package uoft.csc207.gameproject.game.catchcat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;

/**
 * Store all possible images for each game component, used for draw method
 */
class ImageFactory {

    private static final Bitmap Cat  = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.cat);
    private static final Bitmap Dumbbell   = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.weight);
    private static final Bitmap Food   = BitmapFactory.decodeResource(GameApplication.getInstance().getResources(), R.drawable.food);

    /**
     * initialize a map of Status and image.
     */
    private HashMap<Status, Bitmap> imageFactory = new HashMap<>();

    /**
     * Construct a new ImageFactory object.
     */
    ImageFactory() {
        createImage();
    }

    /**
     * Returns the HashMap that the keys are string of Bitmap and values are the Bitmaps.
     */
    HashMap<Status, Bitmap> getImageFactory() {
        return imageFactory;
    }

    /**
     * Constructs the HashMap of the Bitmaps.
     */
    private void createImage(){
        imageFactory.put(Status.TARGET, Cat);
        imageFactory.put(Status.OFF, Dumbbell);
        imageFactory.put(Status.FOOD, Food);
    }
}
