package uoft.csc207.gameproject.game.catchcat;

import java.io.Serializable;
import java.util.List;

import uoft.csc207.gameproject.game.GameState;

class CatchCatGameState extends GameState implements Serializable {

    /**
     * map for this game.
     */
    private GameMap map;

    /**
     * game targets
     */
    private List<CatchCatGameComponent> targets;

    /**
     * number of steps the cat has moved
     */
    private int steps;

    /**
     * default level
     */
    private String level;

    /**
     * setter for game map
     */
    void setMap(GameMap map) {
        this.map = map;
    }

    /**
     * setter for game level
     */
    void setLevel(String level){this.level = level;}


    /**
     * getter for game level
     */
    String getLevel() {
        return level;
    }

    /**
     * getter for number of steps
     */
    void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * recreate our game map
     */
    void createNewMap() {
        map.createNewMap(level);
    }

    /**
     * getter for number of steps
     */
    int getSteps() {
        return steps;
    }

    /**
     * getter for game map
     */
    GameMap getMap() {
        return map;
    }

    /**
     * setter for game target which is our cat
     */
    void setTarget(){
        targets = map.getTargets();
    }

    /**
     * getter for game target
     */
    List<CatchCatGameComponent> getTargets() {
        return targets;
    }

    /**
     * change cell status to Status.OFF
     */
    void setCell(int x, int y) {
        map.getCell(x, y).setStatus(Status.OFF);
    }

    /**
     * move cell
     */
    void moveCell(CatchCatGameComponent target, CatchCatGameComponent catchCatGameComponent) {
        map.moveCell(target, catchCatGameComponent);
    }
}
