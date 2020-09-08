package uoft.csc207.gameproject.game.catchcat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * draw each game cell based on game status.
 */

class CatchCatDrawStrategy {


    private ImageFactory images = new ImageFactory();

    void draw(Canvas canvas, CatchCatGameState gameState) {
        int mapLength = 10;
        Paint paint = new Paint();
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                CatchCatGameComponent component = gameState.getMap().getCell(i, j);
                // calculate cell coordinate to decide where to draw.
                int interval = 0;
                if (component.getY() % 2 != 0) {
                    interval = 100 / 2;
                }
                RectF rect = new RectF(component.getX() * 100 + interval, component.getY() * 100,
                        component.getX() * 100 + 100 + interval, component.getY() * 100 + 100);
                // draw cell based on each cell's status.
                if (component.getStatus().equals(Status.ON)) {
                        paint.setColor(Color.GRAY);
                        canvas.drawOval(rect, paint);
                }
                else{
                    drawComponent(canvas, component, rect);
                }
            }
        }
    }

    /**
     * draw the gameComponent based on each component's status
     */
    private void drawComponent(Canvas canvas, CatchCatGameComponent component, RectF rect) {
        Bitmap bitmap = images.getImageFactory().get(component.getStatus());
        if(bitmap != null) {
            canvas.drawBitmap(bitmap, null, rect, new Paint());
        }
    }
}

