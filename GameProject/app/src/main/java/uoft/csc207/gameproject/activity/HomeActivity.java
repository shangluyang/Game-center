package uoft.csc207.gameproject.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.user.UserManager;

public class HomeActivity extends BaseActivity {
	private static final int SCORE_REQUEST_CODE = 1;

	private Dialog logoutDialog;

	/**
	 * Called when the activity is being initialized.
	 *
	 * @param savedInstanceState The activity's state during a previous termination and can be used
	 *                           to recreate the activity, null if no data was stored.
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setupDialog();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_home;
	}

	/**
	 * Set the {@link android.view.View.OnClickListener} for buttons
	 * in the home activity.
	 */
	@Override
	protected void setOnClickListeners() {
		Button btn_resetpassword = findViewById(R.id.homeResetPassword);
		Button btn_scoreboard = findViewById(R.id.homeScoreboard);
		ImageView iv_snake = findViewById(R.id.homeSnake);
		ImageView iv_catchcat = findViewById(R.id.homeCatchCat);
		ImageView iv_gamble = findViewById(R.id.homeGamble);

		btn_resetpassword.setOnClickListener(new ResetPwClickListener());
		btn_scoreboard.setOnClickListener(new ScoreboardButtonClick());
		iv_snake.setOnClickListener(new SnakeButtonClick());
		iv_catchcat.setOnClickListener(new CatchCatButtonClick());
		iv_gamble.setOnClickListener(new GambleButtonClick());
	}

	/**
	 * Set the text filter and length filter for the username and password.
	 */
	private void setFilters(EditText editText) {
		editText.setFilters(
				new InputFilter[]{
						new LoginFilter.UsernameFilterGMail(), new InputFilter.LengthFilter(20)
				});
	}

	/**
	 * Shows the logout dialog when the back button is pressed.
	 * Prevents user accidentally returning to the log in screen.
	 */
	@Override
	public void onBackPressed() {
		showDialog();
	}

	/**
	 * Set up the logout dialog and set the {@link android.view.View.OnClickListener}
	 * for buttons in the dialog.
	 */
	private void setupDialog() {
		logoutDialog = new Dialog(this);
		logoutDialog.setContentView(R.layout.activity_logout);
		logoutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		Button btn_cancel = logoutDialog.findViewById(R.id.logout_btn_cancel);
		Button btn_logout = logoutDialog.findViewById(R.id.logout_btn_logout);

		btn_cancel.setOnClickListener(new CancelButtonClick());
		btn_logout.setOnClickListener(new LogoutButtonClick());
	}

	private void showDialog() {
		logoutDialog.show();
	}

	private void logout() {
		GameApplication.getInstance().getUserManager().logout();
	}

	/**
	 * Direct HomeActivity page to ScoreboardActivity page.
	 */
	private class ScoreboardButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HomeActivity.this, ScoreboardActivity.class);
			startActivity(intent);
		}
	}

	/**
	 * Direct HomeActivity page to GameMenuActivity page.
	 */
	private class SnakeButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HomeActivity.this, GameMenuActivity.class);
			intent.putExtra("View","Snake");
			startActivity(intent);
		}
	}

	/**
	 * Direct HomeActivity page to GameMenuActivity page.
	 */
	private class CatchCatButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HomeActivity.this, GameMenuActivity.class);
			intent.putExtra("View","CatchCat");
			startActivity(intent);
		}
	}

	/**
	 * Direct HomeActivity page to GambleHomeActivity page.
	 */
	private class GambleButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(HomeActivity.this, GambleHomeActivity.class);
			startActivityForResult(intent, SCORE_REQUEST_CODE);
		}
	}

	/**
	 * Cancel the direction of 'log out' when press "CANCEL" button.
	 */
	private class CancelButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			logoutDialog.dismiss();
		}
	}

	/**
	 * Confirm to log out when press "log out" button.
	 */
	private class LogoutButtonClick implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			logout();
			logoutDialog.dismiss();
			finish();
		}
	}

	/**
	 * Reset the password when press "Reset Password" button.
	 */
	private class ResetPwClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			AlertDialog.Builder resetPw = new AlertDialog.Builder(HomeActivity.this);

			resetPw.setTitle("Reset Password");
			resetPw.setMessage("Please type in your new password.");

			// Set an EditText view to get user input
			final EditText input = new EditText(HomeActivity.this);
			setFilters(input);
			resetPw.setView(input);
			resetPw.setPositiveButton(
					"Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							UserManager userManager = GameApplication.getInstance().getUserManager();
							if (input.getText().toString().equals("")) {
								Toast.makeText(
										HomeActivity.this,
										"Your new password " + "cannot be empty!",
										Toast.LENGTH_SHORT)
										.show();
							} else if (input.getText().toString().equals(userManager.getCurrentUser().getPassword())) {
								Toast.makeText(
										HomeActivity.this,
										"Your new password " + "cannot be the same as old password!",
										Toast.LENGTH_SHORT)
										.show();
							} else {
								userManager
										.getCurrentUser()
										.resetPassword(input.getText().toString());
								userManager.saveToFile();
								Toast.makeText(HomeActivity.this, "Your password has " + "been successfully changed!",
										Toast.LENGTH_SHORT)
										.show();
							}
						}
					});
			resetPw.setNegativeButton("Cancel", null);
			resetPw.show();
		}
	}
}
