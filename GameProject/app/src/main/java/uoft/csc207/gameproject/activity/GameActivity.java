package uoft.csc207.gameproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import uoft.csc207.gameproject.game.GameView;
import uoft.csc207.gameproject.game.snake.snakeview.SnakeGameView;

import uoft.csc207.gameproject.game.catchcat.CatchCatGameView;

public class GameActivity extends Activity {
	private GameView gameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow()
				.setFlags(
						WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		String viewName = getIntent().getStringExtra("View");
		String operation = getIntent().getStringExtra("Operation");
		if (!(viewName == null)) {
			if (viewName.equals("Snake")) {
				gameView = new SnakeGameView(this);

			} else if (viewName.equals("CatchCat")) {
				gameView = new CatchCatGameView(this);
			}
		}
    if (!(operation == null)) {
      if (operation.equals("LoadGame")) {
        gameView.loadGame();
      } else {
        gameView.newGame(operation);
      }
      setContentView(gameView);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		String viewName = getIntent().getStringExtra("View");
		String operation = getIntent().getStringExtra("Operation");
		if (!(viewName == null)) {
			if (viewName.equals("Snake")) {
				gameView = new SnakeGameView(this);

			} else if (viewName.equals("CatchCat")) {
				gameView = new CatchCatGameView(this);
			}
		}
		if (!(operation == null)) {
			if (operation.equals("LoadGame")) {
				gameView.loadGame();
			} else {
				gameView.newGame(operation);
			}
			setContentView(gameView);
		}
		super.onResume();

	}

	@Override
	public void onBackPressed() {
		gameView.endGame();
		super.onBackPressed();
	}
}
