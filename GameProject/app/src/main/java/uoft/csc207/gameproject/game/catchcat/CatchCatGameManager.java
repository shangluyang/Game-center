package uoft.csc207.gameproject.game.catchcat;

import android.content.Context;
import android.graphics.Canvas;

import uoft.csc207.gameproject.game.GameManager;

class CatchCatGameManager extends GameManager {

    private CatchCatGameState gameState;
    private Context context;
    private CatchCatSaveStrategy saveStrategy = new CatchCatSaveStrategy();
    private CatchCatMoveStrategy catchCatMoveStrategy = new CatchCatMoveStrategy();
    private CatchCatDrawStrategy drawStrategy = new CatchCatDrawStrategy();

    CatchCatGameManager(Context context) {

        this.context = context;
    }

    void startGame(String level){
        gameState = new CatchCatGameState();
        gameState.setMap(new GameMap(level));
        gameState.setSteps(0);
        gameState.setTarget();
        gameState.setLevel(level);
    }

    //start a new game
    void newGame() {
        if (lose() || win()) {
            gameState.createNewMap();
            gameState.setTarget();
            resetScore();
        }
    }

    void resumeGame(){
        gameState = saveStrategy.resumeGame(context);
    }

    // save game
    void saveGame(){
        saveStrategy.saveGame(context, gameState);
    }

    //check whether the status of cell located in given x, y is on
    Boolean isStatusOn(int x, int y) {
        return (gameState.getMap().getCell(x, y).getStatus().equals(Status.ON));
    }

    //set the status of cell located in x, y to off
    void setStatusOff(int x, int y) {
        if (isStatusOn(x, y)) {
            gameState.setCell(x, y);
        }
    }

    // draw gameComponent based on their status
    void draw(Canvas canvas) {
        drawStrategy.draw(canvas, gameState);
    }

    void move(){
        catchCatMoveStrategy.move(gameState);
    }

    //get user current step
    int getScore() {
        return (100 - getStep());
    }

    int getStep(){
        return gameState.getSteps();
    }

    //reset current step to 0
    private void resetScore() {
        gameState.setSteps(0);
    }

    //check whether user is lose
    boolean lose() {
        return catchCatMoveStrategy.lose(gameState);
    }

    //check whether user is win
    boolean win() {
        return catchCatMoveStrategy.win(gameState);
    }

}
