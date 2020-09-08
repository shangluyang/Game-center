package uoft.csc207.gameproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.user.UserManager;

/**
 * The login activity which allows the user to log in with their registered accounts.
 * The main entry point of the application.
 */
public class LoginActivity extends BaseActivity {
	private static final int HOME_REQUEST_CODE = 1;
	private static final int SIGNUP_REQUEST_CODE = 2;

	/**
	 * Called when the activity is being initialized.
	 *
	 * @param savedInstanceState The activity's state during a previous termination and can be used
	 *                           to recreate the activity, null if no data was stored.
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setFilters();
	}

	/**
	 * Processes the result obtained from activities started for a result.
	 *
	 * @param requestCode 1 if the started activity is {@link HomeActivity},
	 *                    2 if the started activity is {@link SignUpActivity}.
	 * @param resultCode  {@code Activity.RESULT_OK} if the activity succeeded,
	 *                    {@code Activity.RESULT_CANCELED} if the activity was canceled.
	 * @param data        The data from the started activity.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		EditText et_username = findViewById(R.id.logInUsername);
		EditText et_password = findViewById(R.id.logInPassword);
		et_username.setText("");
		et_password.setText("");
		if (requestCode == HOME_REQUEST_CODE) {
			et_username.requestFocus();
		} else if (requestCode == SIGNUP_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				String username = data.getStringExtra("Username");
				et_username.setText(username);
				et_password.requestFocus();
			} else if (resultCode == Activity.RESULT_CANCELED) {
				et_username.requestFocus();
			}
		}
	}

	/**
	 * Get id of this layout
	 * @return id of this layout
	 */
	@Override
	protected int getLayoutId() {
		return R.layout.activity_login;
	}

	/**
	 * Set the {@link android.view.View.OnClickListener} for buttons
	 * in the sign up activity.
	 */
	@Override
	protected void setOnClickListeners() {
		ConstraintLayout layout = findViewById(R.id.loginLayout);
		Button btn_login = findViewById(R.id.logInLogin);
		TextView tv_signup = findViewById(R.id.logInSignUp);

		layout.setOnClickListener(new LayoutClickListener());
		btn_login.setOnClickListener(new LoginClickListener());
		tv_signup.setOnClickListener(new SignupClickListener());
	}

	/**
	 * Set the text filter and length filter for the username and password.
	 */
	private void setFilters() {
		InputFilter[] filters = new InputFilter[]{new LoginFilter.UsernameFilterGMail(), new InputFilter.LengthFilter(20)};
		EditText et_username = findViewById(R.id.logInUsername);
		EditText et_password = findViewById(R.id.logInPassword);
		et_username.setFilters(filters);
		et_password.setFilters(filters);
	}

	/**
	 * Set the situation when click the background
	 */
	private class LayoutClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			clearFocus();
		}
	}

	/**
	 * Set login button
	 */
	private class LoginClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			String username = ((EditText) findViewById(R.id.logInUsername)).getText().toString();
			String password = ((EditText) findViewById(R.id.logInPassword)).getText().toString();
			if (username.equals("") || password.equals("")) {
				Toast.makeText(LoginActivity.this, "Empty username or password!", Toast.LENGTH_SHORT).show();
			} else {
				UserManager userManager = GameApplication.getInstance().getUserManager();
				boolean loggedin = userManager.login(username, password);
				if (loggedin) {
					Toast.makeText(LoginActivity.this, "Welcome back " + username + "!", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
					startActivityForResult(intent, HOME_REQUEST_CODE);
				} else {
					Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}

	/**
	 * Set signup button.
	 */
	private class SignupClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
			startActivityForResult(intent, SIGNUP_REQUEST_CODE);
		}
	}
}
