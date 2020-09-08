package uoft.csc207.gameproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.user.UserManager;

/**
 * The activity of signup page.
 */
public class SignUpActivity extends BaseActivity {

	/**
	 * The on create method for init
	 *
	 * @param savedInstanceState activity field needed by superclass
	 */
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setFilters();
	}

	/**
	 * Get id of Signupactivity's layout
	 * @return
	 */
	@Override
	protected int getLayoutId() {
		return R.layout.activity_signup;
	}

	/**
	 * Set layout clicking and signup button
	 */
	@Override
	protected void setOnClickListeners() {
		ConstraintLayout layout = findViewById(R.id.signupLayout);
		Button btn_signup = findViewById(R.id.signUpSignUp);

		layout.setOnClickListener(new LayoutClickListener());
		btn_signup.setOnClickListener(new SignUpClickListener());
	}

	/**
	 * Set the text filter and length filter for the username and password.
	 */
	private void setFilters() {
		InputFilter[] filters = new InputFilter[]{new LoginFilter.UsernameFilterGMail(), new InputFilter.LengthFilter(20)};
		EditText et_username = findViewById(R.id.signUpUsername);
		EditText et_password = findViewById(R.id.signUpPassword);
		et_username.setFilters(filters);
		et_password.setFilters(filters);
	}

	/**
	 * Set the situation when background is activated
	 */
	private class LayoutClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			clearFocus();
		}
	}

	/**
	 * Activate signup button.
	 */
	private class SignUpClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			String username = ((EditText) findViewById(R.id.signUpUsername)).getText().toString();
			String password = ((EditText) findViewById(R.id.signUpPassword)).getText().toString();
			if (username.equals("") || password.equals("")) {
				Toast.makeText(SignUpActivity.this, "Empty username or password!", Toast.LENGTH_SHORT).show();
			} else {
				UserManager userManager = GameApplication.getInstance().getUserManager();
				boolean signup = userManager.signUp(username, password);
				if (signup) {
					userManager.saveToFile();
					Toast.makeText(SignUpActivity.this, "Successfully signed up!", Toast.LENGTH_SHORT).show();
					Intent resultIntent = new Intent();
					resultIntent.putExtra("Username", username);
					setResult(Activity.RESULT_OK, resultIntent);
					finish();
				} else {
					Toast.makeText(SignUpActivity.this, username + " is already registered!", Toast.LENGTH_SHORT).show();
				}
			}
		}
	}
}
