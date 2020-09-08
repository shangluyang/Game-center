package uoft.csc207.gameproject.game.catchcat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MapGenerator implements Serializable {

    /**
     * the targets for this game
     */
    private List<CatchCatGameComponent> targets;

    /**
     * the map for this game
     */
    private CatchCatGameComponent[][] map;

    /**
     * MapGenerator initializer
     */
    MapGenerator(CatchCatGameComponent[][] map) {
        this.map = map;
    }

    /**
     * create Game Component for this game
     */
    private void createGameComponent(String level){
        if(level.equals("2")){
            setTargets(2);
        }
        else if(level.equals("3")){
            setTargets(3);
            createFood();
        }
        else{
            setTargets(1);
        }
        createBarrier();
    }

    /**
     * create map with all game components
     */
    void generate(String level) {
        createMap();
        createGameComponent(level);
    }

    /**
     * recreate map with all game components
     */
    void reGenerateMap(String level) {
        setAllCellOn();
        createGameComponent(level);
    }

    /**
     * getter for gameTargets
     */
    List<CatchCatGameComponent> getTargets() {
        return targets;
    }

    private void createMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new CatchCatGameComponent(j, i);
            }
        }
    }

    /**
     * set the status of all cells to Status.ON
     */
    private void setAllCellOn() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j].setStatus(Status.ON);
            }
        }
    }

    /**
     * create game targets
     */
    private void setTargets(int numCats) {
        int i = 0;
        targets = new ArrayList<>();
        while (i < numCats) {
            Random random = new Random();
            int x = random.nextInt(4) + 3;
            int y = random.nextInt(4) + 3;
            CatchCatGameComponent target = map[y][x];
            if (!targets.contains(target)) {
                targets.add(target);
                map[y][x].setStatus(Status.TARGET);
                i++;
            }
        }
    }

    /**
     * create food
     */
    private void createFood(){
        int i = 0;
        Random random = new Random();
        while(i < 10){
            int x = random.nextInt(map.length - 3) + 1;
            int y = random.nextInt(map.length - 3) + 1;
            CatchCatGameComponent food = map[y][x];
            if(map[y][x].getStatus().equals(Status.ON)){
                map[y][x].setStatus(Status.FOOD);
                i ++;
            }
        }
    }

    /**
     * create Barrier
     */
    private void createBarrier() {
        int i = 0;
        Random random = new Random();
        while (i < 10) {
            int x = random.nextInt(map.length);
            int y = random.nextInt(map.length);
            if (map[y][x].getStatus().equals(Status.ON)) {
                map[y][x].setStatus(Status.OFF);
                i++;
            }
        }

    }
}
