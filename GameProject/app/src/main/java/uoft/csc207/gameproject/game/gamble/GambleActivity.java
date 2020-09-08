package uoft.csc207.gameproject.game.gamble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import uoft.csc207.gameproject.R;
import uoft.csc207.gameproject.activity.SaveScoreActivity;

/**
 * An activity class for Gamble level 1.
 */
public class GambleActivity extends Activity implements GambleView {
	private static final int SCORE_REQUEST_CODE = 1;
    private GamblePresenter presenter;
    private TextView pointsTitle;
    private TextView titleLine;

    private EditText input;
    private TextView highScore;

    /**
     * called when the Activity is being initialized
     *
     * @param savedInstanceState The activity's state during a previous termination and can be used
     *                           *                           to recreate the activity, null if no data was stored.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamble);
        presenter = new GamblePresenter(this);
        pointsTitle = findViewById(R.id.PointsTitle);
        titleLine = findViewById(R.id.TitleLine);
        input = findViewById(R.id.PointsInput);
        highScore = findViewById(R.id.highScore);
    }

    /**
     * call presenter's startGamble method when Gamble button is pressed
     */
    public void startGamble(View view) {
        String countString = input.getText().toString();
        if (!countString.equals("")) {
            Integer count = Integer.parseInt(countString);
            presenter.startGamble(count, count);

        }
    }

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            finish();
        }
    }

    /**
     * go to SaveScoreActivity when the game is over
     */
    public void lose() {
        Intent intent = new Intent(GambleActivity.this, SaveScoreActivity.class);
        intent.putExtra("GameName", "Gamble");
        intent.putExtra("Score", Integer.parseInt(highScore.getText().toString()));
        startActivityForResult(intent, SCORE_REQUEST_CODE);
    }

    /**
     * update the points to TextView pointsTitle
     * @param points the value of points to be updated
     */
    public void updatePoints(Integer points){
        pointsTitle.setText(String.format("%d", points));
    }

    /**
     * update the points to TextView highscore
     * @param highscore the value of highscore to be updated
     */
    public void updateHighscore(Integer highscore){
        highScore.setText(String.format("%d", highscore));
    }

    /**
     * update the points to TextView titleLine
     * @param title the value of title to be updated
     */
    public void updateTitle(String title){
        titleLine.setText(title);
    }

    /**
     * an abstract class
     *
     * @param OddLine the value of OddLine
     */
    public void updateOdd(String OddLine){

    }
}
