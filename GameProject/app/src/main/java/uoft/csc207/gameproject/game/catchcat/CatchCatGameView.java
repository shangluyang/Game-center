package uoft.csc207.gameproject.game.catchcat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uoft.csc207.gameproject.activity.SaveScoreActivity;
import uoft.csc207.gameproject.game.GameView;

public class CatchCatGameView extends GameView implements View.OnTouchListener {

    /**
     * game manager
     */
    private CatchCatGameManager manager;

    /**
     * Game view initializer
     */

    private Context context;

    public CatchCatGameView(Context context) {
        super(context);
        this.context = context;
        manager = new CatchCatGameManager(context);
        setOnTouchListener(this);
    }

    // save game
    public void saveGame() {
        manager.saveGame();
    }

    // load game
    public void loadGame() {
        manager.resumeGame();
    }

    // create new Game based on given level
    @Override
    public void newGame(String level){
        manager.startGame(level);
    }

    @Override
    public void update() {
    }

    // draw the game map and gameComponent
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        manager.draw(canvas);
        getPaint().setColor(Color.BLACK);
        getPaint().setTextSize(80);
        getPaint().setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("Current steps: " + manager.getStep(), 250, 2000, getPaint());
    }

    /**
     * get the coordinator of touch event and update game
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int size = 100;
        if (event.getAction() == MotionEvent.ACTION_UP) {
            int x = 0;
            int y;
            y = (int) (event.getY() / size);
            //get the cell located at x, y coordinates
            if (y % 2 == 0) {
                x = (int) (event.getX() / size);
            } else if (y % 2 == 1) {
                x = (int) ((event.getX() - size / 2) / size);
            }
            if (x >= 0 & y < 10) {
                // if user doest not win or lose game, we can convert the status of some cells to off
                if (!manager.lose() && !manager.win()) {
                    if (manager.isStatusOn(x, y)) {
                        manager.setStatusOff(x, y);
                        manager.move();
                        saveGame();
                    }
                }
                checkLostWin();
            } else {
                manager.newGame();
            }
        }
        return true;
    }

    /**
     * check whether the game win or lose, and print text.
     */
    private void checkLostWin() {
        if (manager.lose()) {
            Toast.makeText(getContext(), "Lose, click blank to restart", Toast.LENGTH_SHORT).show();
        } else if (manager.win()) {
            Toast.makeText(getContext(), "win, click blank to restart", Toast.LENGTH_SHORT).show();
            saveScore();
        }
    }

    /**
     * save score to scoreboard
     */
    private void saveScore(){
        Intent intent = new Intent();
        intent.setClass(context, SaveScoreActivity.class);
        intent.putExtra("GameName", "CatchCat");
        intent.putExtra("Score", manager.getScore());
        context.startActivity(intent);
    }
}

