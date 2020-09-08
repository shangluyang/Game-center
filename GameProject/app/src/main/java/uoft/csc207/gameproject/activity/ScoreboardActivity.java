package uoft.csc207.gameproject.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.scoreboard.Score;
import uoft.csc207.gameproject.scoreboard.Scoreboard;

/**
 * The activity of scoreboard page
 */
public class ScoreboardActivity extends BaseActivity {
	private Dialog scoreDialog;

	/**
	 * the on create method for init
	 *
	 * @param savedInstanceState activity field needed by superclass
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	/**
	 * Get the id of scoreboard layout
	 *
	 * @return id of scoreboard layout
	 */
	@Override
	protected int getLayoutId() {
		return R.layout.activity_scoreboard;
	}

	/**
	 * Set three games' imageview to access the scoreboard
	 */
	@Override
	protected void setOnClickListeners() {
		ImageView iv_snake = findViewById(R.id.scoreboardSnake);
		ImageView iv_catchcat = findViewById(R.id.scoreboardCat);
		ImageView iv_gamble = findViewById(R.id.scoreboardGamble);

		iv_snake.setOnClickListener(new ScoreboardActivity.SnakeButtonClick());
		iv_catchcat.setOnClickListener(new ScoreboardActivity.CatchCatButtonClick());
		iv_gamble.setOnClickListener(new ScoreboardActivity.GambleButtonClick());
	}

	/**
	 * Activate snake imageview
	 */
	private class SnakeButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			setupDialog("Snake");
			scoreDialog.show();

		}
	}

	/**
	 * Activate catchcat imageview
	 */
	private class CatchCatButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			setupDialog("CatchCat");
			scoreDialog.show();
		}
	}

	/**
	 * Activate gamble imageview
	 */
	private class GambleButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			setupDialog("Gamble");
			scoreDialog.show();
		}
	}

	/**
	 * Set score info to scoreboard
	 */
	private void setupDialog(String gameName) {
		scoreDialog = new Dialog(this);
		scoreDialog.setContentView(R.layout.activity_score);
		scoreDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		TextView tv_user0 = scoreDialog.findViewById(R.id.scoreUserZero);
		TextView tv_user1 = scoreDialog.findViewById(R.id.scoreUserOne);
		TextView tv_user2 = scoreDialog.findViewById(R.id.scoreUserTwo);
		TextView tv_user3 = scoreDialog.findViewById(R.id.scoreUserThree);
		TextView tv_user4 = scoreDialog.findViewById(R.id.scoreUserFour);
		TextView tv_score0 = scoreDialog.findViewById(R.id.scoreScoreZero);
		TextView tv_score1 = scoreDialog.findViewById(R.id.scoreScoreOne);
		TextView tv_score2 = scoreDialog.findViewById(R.id.scoreScoreTwo);
		TextView tv_score3 = scoreDialog.findViewById(R.id.scoreScoreThree);
		TextView tv_score4 = scoreDialog.findViewById(R.id.scoreScoreFour);
		List<TextView> userTextViews = new ArrayList<TextView>();
		List<TextView> scoreTextViews = new ArrayList<TextView>();
		userTextViews.add(tv_user0);
		userTextViews.add(tv_user1);
		userTextViews.add(tv_user2);
		userTextViews.add(tv_user3);
		userTextViews.add(tv_user4);
		scoreTextViews.add(tv_score0);
		scoreTextViews.add(tv_score1);
		scoreTextViews.add(tv_score2);
		scoreTextViews.add(tv_score3);
		scoreTextViews.add(tv_score4);
		TextView tv_name = scoreDialog.findViewById(R.id.scoreGameName);
		tv_name.setText(gameName);
		Scoreboard scoreboard = GameApplication.getInstance().getScoreboardManager().getScoreboard(gameName);
		List<Score> scores = scoreboard.getScoreList();
		Collections.sort(scores, new Score.SortByScore());
		Collections.reverse(scores);
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i) != null) {
				userTextViews.get(i).setText(scores.get(i).getName());
				scoreTextViews.get(i).setText(String.valueOf(scores.get(i).getScore()));
			}
		}
	}
}
