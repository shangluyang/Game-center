package uoft.csc207.gameproject.game.snake.snakeview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import uoft.csc207.gameproject.activity.SaveScoreActivity;
import uoft.csc207.gameproject.game.GameView;
import uoft.csc207.gameproject.game.snake.snakepresenter.SnakeGameManager;
/**
 * strategy with methods that decides how the game will be draw. .
 */
public class SnakeGameView extends GameView implements View.OnTouchListener {
	/**
	 * the game manager of this GameView
	 */
	private SnakeGameManager manager;
	private Context context;
	/**
	 * Initialize a new SnakeGameView object..
	 */
	public SnakeGameView(Context context) {
		super(context);
		this.context = context;
		manager = new SnakeGameManager(context);
	}
	/**
	 * start a new game with given level string.
	 */
	@Override
	public void newGame(String level) {
		manager.newGame(level);
	}
	/**
	 * save the current game state.
	 */
	public void saveGame() {
		manager.saveGame();
	}
	/**
	 * load the last game state that user saved
	 */
	public void loadGame() {
		manager.resumeGame();
	}
	/**
	 * update the game state. .
	 */
	@Override
	public void update() {
		if(isSaveScore()){
			saveScore();
			manager.reconstruct();
		}
		manager.move();
	}
	/**
	 * draw the game on the screen .
	 */
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint paint2 = new Paint();
		paint2.setColor(Color.WHITE);
		paint2.setTextSize(50);
		canvas.drawText("Score:" + manager.getScore(), 0, 2000, paint2);//Show score at left bottom.
		setOnTouchListener(this);
		manager.draw(canvas, this);
		if (manager.isFailed()) {
			Paint paint = new Paint();
			paint.setColor(Color.WHITE);
			paint.setTextSize(30);
			canvas.drawText("lose, press anywhere to restart", 350, 1000, paint);
			canvas.drawText("Score:" + manager.getScore(), 350, 1100, paint);
		}
		saveGame();
	}
	/**
	 * detect touch event coordinates to control the game . .
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP) {
			event.getY();
			float x = event.getX();
			float y = event.getY();
			manager.playerMove(x, y);
		}

		return true;
	}
	/**
	 * end the game when game is not finished.
	 */
	@Override
	public void endGame() {
		super.endGame();
	}
	/**
	 * whether the game is needed to save the score. .
	 */
	public boolean isSaveScore(){
		return manager.isFailed();
	}

	/**
	 * save the score by SaveScoreActivity.
	 */
	public void saveScore(){
		Intent intent = new Intent();
		intent.setClass(context, SaveScoreActivity.class);
		intent.putExtra("GameName", "Snake");
		intent.putExtra("Score", manager.getScore());
		context.startActivity(intent);
	}
}
