package uoft.csc207.gameproject.game.catchcat;

import java.io.Serializable;
import java.util.List;

class GameMap implements Serializable {

    /**
     * the map for the game
     */
    private CatchCatGameComponent[][] map;

    /**
     * game map generator
     */
    private MapGenerator generator;

    /**
     * create a map based on given number of cats
     */
    GameMap(String level) {
        map = new CatchCatGameComponent[10][10];
        generator = new MapGenerator(map);
        generator.generate(level);
    }

    /**
     * get the game target which is our cats
     */
    List<CatchCatGameComponent> getTargets(){
        return generator.getTargets();
    }

    /**
     * recreate a new map
     */
    void createNewMap(String level){generator.reGenerateMap(level);}

    /**
     * get the cell based on given coordinates
     */
    CatchCatGameComponent getCell(int x, int y) {
        return map[y][x];
    }

    //move given cell to end
    void moveCell(CatchCatGameComponent cell, CatchCatGameComponent end) {
        cell.setStatus(Status.ON);
        end.setStatus(Status.TARGET);
    }
}
