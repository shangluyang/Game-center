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
 * an activity class for the gamble game level 2.
 */
public class Gamble2Activity extends Activity implements GambleView {
    private GamblePresenter presenter;
    private TextView pointsTitle;
    private TextView titleLine;
    private EditText input;
    private EditText output;
    private TextView highScore;
    private TextView odd;

    /**
     * called when the Activity is being initialized
     *
     * @param savedInstanceState The activity's state during a previous termination and can be used
     *                           *                           to recreate the activity, null if no data was stored.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamble2);
        presenter = new GamblePresenter(this);
        pointsTitle = findViewById(R.id.PointsTitle);
        titleLine = findViewById(R.id.TitleLine);
        input = findViewById(R.id.PointsInput);
        highScore = findViewById(R.id.highScore);
        output = findViewById(R.id.PointsOutput);
        odd = findViewById(R.id.odd);
    }

    /**
     * call presenter's startAnalyze method when Analyze button is pressed
     */
    public void startAnalyze(View view){
        String countString = input.getText().toString();
        String countString2 = output.getText().toString();
        if(!countString.equals("") && !countString2.equals("")){
            Integer count = Integer.parseInt(countString);
            Integer count2 = Integer.parseInt(countString2);
            presenter.startAnalyze(count, count2);
        }
    }

    /**
     *call presenter's startGamble method when Gamble button is pressed
     */
    public void startGamble(View view) {
        //get the player's input
        String countString = input.getText().toString();
        String countString2 = output.getText().toString();
        if(!countString.equals("") && !countString2.equals("")){
            Integer count = Integer.parseInt(countString);
            Integer count2 = Integer.parseInt(countString2);
            presenter.startGamble(count, count2);
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
        //start endScreen Activity
        Intent intent = new Intent(Gamble2Activity.this, SaveScoreActivity.class);
        intent.putExtra("GameName", "Gamble");
        intent.putExtra("Score", Integer.parseInt(highScore.getText().toString()));
        startActivityForResult(intent, 1);
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
     *update oddLine to TextView OddLine
     * @param oddLine the value of OddLine
     */
    public void updateOdd(String oddLine){
        odd.setText(oddLine);
    }
}
