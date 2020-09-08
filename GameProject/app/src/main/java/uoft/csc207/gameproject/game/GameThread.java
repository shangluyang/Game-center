package uoft.csc207.gameproject.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	/**
	 * indicate whether the thread is running
	 */
	private boolean isRunning;

	private long deltaTime;

	private SurfaceHolder surfaceHolder;

	private GameView gameView;

	GameThread(GameView gameView, long deltaTime) {
		super();
		this.deltaTime = deltaTime;
		this.surfaceHolder = gameView.getHolder();
		this.gameView = gameView;
	}

	/**
	 * setter for isRunning.
	 */
	void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	/**
	 * start thread
	 */
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		Canvas canvas;
		while (isRunning) {
			canvas = null;
			try {
				canvas = surfaceHolder.lockCanvas();
				synchronized (surfaceHolder) {
					gameView.update();
					gameView.draw(canvas);
				}
			} finally {
				if (canvas != null) {
					try {
						surfaceHolder.unlockCanvasAndPost(canvas);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			long finishTime = System.currentTimeMillis();
			long updateTime = finishTime - startTime;
			try {
				sleep(Math.max(deltaTime - updateTime, 50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			startTime = System.currentTimeMillis();
		}
	}
}
