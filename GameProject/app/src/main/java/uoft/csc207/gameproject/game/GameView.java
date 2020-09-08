package uoft.csc207.gameproject.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.List;

public abstract class GameView extends SurfaceView implements SurfaceHolder.Callback {

	/**
	 * game manager
	 */
	private GameManager manager;

	/**
	 * game thread
	 */
	private GameThread thread;

	/**
	 * paint for this game
	 */
	private Paint paint;

	/**
	 * Initialize the gameView
	 */
	public GameView(Context context) {
		super(context);
		int deltaTime = 200;
		setFocusable(true);
		getHolder().addCallback(this);

		paint = new Paint();
		thread = new GameThread(this, deltaTime);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				thread.setRunning(false);
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
	}

	public void endGame() {
		thread.setRunning(false);
	}

	public Paint getPaint() {
		return paint;
	}

	public abstract void update();

	/**
	 * create new game based on each level
	 */
	public void newGame(String level) {
	}

	/**
	 * save game
	 */
	public void saveGame() {
		manager.saveGame();
	}

	/**
	 * load game
	 */
	public void loadGame() {
		manager.resumeGame();
	}


}
