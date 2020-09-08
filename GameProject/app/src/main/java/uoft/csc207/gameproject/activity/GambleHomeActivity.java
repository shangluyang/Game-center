package uoft.csc207.gameproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.game.gamble.Gamble2Activity;
import uoft.csc207.gameproject.game.gamble.GambleActivity;

/**
 * the activity of gamble home page
 */
public class GambleHomeActivity extends BaseActivity {

    /**
     * Called when the activity is being initialized.
     *
     * @param savedInstanceState The activity's state during a previous termination and can be used
     *                           to recreate the activity, null if no data was stored.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Get id of gamblehome layout
     * @return id of gamblehome layout
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_gamblehome;
    }

    /**
     * Set three buttons on gamble home page
     */
    @Override
    protected void setOnClickListeners() {
        Button btn_gamblelevelone = findViewById(R.id.btnGambleLevelOne);
        Button btn_gambleleveltwo = findViewById(R.id.btnGambleLevelTwo);

        btn_gamblelevelone.setOnClickListener(new GambleHomeActivity.LevelOneClickListener());
        btn_gambleleveltwo.setOnClickListener(new GambleHomeActivity.LevelTwoClickListener());
    }

    /**
     * Activate level one button
     */
    private class LevelOneClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(GambleHomeActivity.this, GambleActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Activate level two button
     */
    private class LevelTwoClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(GambleHomeActivity.this, Gamble2Activity.class);
            startActivity(intent);
        }
    }
}
