package uoft.csc207.gameproject.activity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.scoreboard.Score;
import uoft.csc207.gameproject.scoreboard.ScoreboardManager;

public class SaveScoreActivity extends BaseActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setFilters();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_savescore;
	}

	@Override
	protected void setOnClickListeners() {
		Button btn_cancel = findViewById(R.id.saveScoreCancel);
		Button btn_save = findViewById(R.id.saveScoreSave);

		btn_cancel.setOnClickListener(new CancelClickListener());
		btn_save.setOnClickListener(new SaveClickListener());
	}

	private void setFilters() {
		InputFilter[] filters = new InputFilter[]{new LoginFilter.UsernameFilterGMail(), new InputFilter.LengthFilter(10)};
		EditText et_username = findViewById(R.id.saveScoreName);
		et_username.setFilters(filters);
	}

	private class CancelClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			onBackPressed();
		}
	}

	private class SaveClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			EditText et_username = findViewById(R.id.saveScoreName);
			String username = et_username.getText().toString();
			if (username.equals("")) {
				Toast.makeText(SaveScoreActivity.this, "Display name cannot be empty!", Toast.LENGTH_SHORT).show();
			} else {
				String gameName = getIntent().getStringExtra("GameName");
				int score = getIntent().getIntExtra("Score", -1);
				ScoreboardManager scoreboardManager = GameApplication.getInstance().getScoreboardManager();
				Score result = new Score(username, score);
				scoreboardManager.updateScoreboard(gameName, result);
				scoreboardManager.saveToFile();
				finish();
			}
		}
	}
}
