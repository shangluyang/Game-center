package uoft.csc207.gameproject.game.catchcat;

import android.content.Context;

import uoft.csc207.gameproject.GameApplication;
import uoft.csc207.gameproject.game.GameFileHandler;
import uoft.csc207.gameproject.game.GameState;

class CatchCatSaveStrategy {

    /**
     * game filehandler
     */
    private GameFileHandler fileHandler = new GameFileHandler();
    private static final String SUFFIX = "-catchCat-sav";
    private static final String FILE = ".dat";

    //resume game
    CatchCatGameState resumeGame(Context context){
        return loadGame(GameApplication.getInstance().getUserManager().getCurrentUser().getUsername() + SUFFIX + FILE, context);
    }

    //load game
    private CatchCatGameState loadGame(String filename, Context context){
        fileHandler.loadGame(filename, context);
        return (CatchCatGameState) fileHandler.getGameState();
    }

    //save Game
    void saveGame(Context context, GameState gameState) {
        fileHandler.saveGame(GameApplication.getInstance().getUserManager().getCurrentUser().getUsername() + SUFFIX + FILE, context, gameState);
    }
}
