package uoft.csc207.gameproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * BaseActivity is an abstract class which extends AppCompatActivity. It provides common
 * methods for activities in the project.
 */
public abstract class BaseActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());

		setOnClickListeners();
	}

	/**
	 * If the current focus is not {@code null}, hide the soft keyboard and clear the current focus.
	 */
	public void clearFocus() {
		if (getCurrentFocus() != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			if (imm != null) {
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
			getCurrentFocus().clearFocus();
		}
	}

	/**
	 * Get id of each layout
	 * @return id of each layout
	 */
	protected abstract int getLayoutId();

	/**
	 * Set buttons on each layout
	 */
	protected abstract void setOnClickListeners();
}
