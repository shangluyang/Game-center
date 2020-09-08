package uoft.csc207.gameproject.game.catchcat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class CatchCatMoveStrategy {

    //check whether user is lose
    boolean lose(CatchCatGameState gameState) {
        for(CatchCatGameComponent target: gameState.getTargets()){
            if(target.isAtBoundary()){
                return true;
            }
        }
        return false;
    }

    //check whether user is win
    boolean win(CatchCatGameState gameState) {
        for(CatchCatGameComponent target: gameState.getTargets()){
            if(availableCell(target, gameState).size() != 0 ){
                return false;
            }
        }
        return true;
    }

    //find the all cells near given cell in 6 directions
    private HashMap<String, CatchCatGameComponent> getNeighbor(CatchCatGameComponent cell, CatchCatGameState gameState) {
        HashMap<String, CatchCatGameComponent> neighbors = new HashMap<>();
        CatchCatGameComponent left = gameState.getMap().getCell(cell.getX() - 1, cell.getY());
        CatchCatGameComponent right = gameState.getMap().getCell(cell.getX() + 1, cell.getY());
        int isEven = 0;
        if (cell.getY() % 2 == 0) {
            isEven = 1;
        }
        CatchCatGameComponent downLeft = gameState.getMap().getCell(cell.getX() - isEven, cell.getY() + 1);
        CatchCatGameComponent downRight = gameState.getMap().getCell(cell.getX() - isEven + 1, cell.getY() + 1);
        CatchCatGameComponent upLeft = gameState.getMap().getCell(cell.getX() - isEven, cell.getY() - 1);
        CatchCatGameComponent upRight = gameState.getMap().getCell(cell.getX() - isEven + 1, cell.getY() - 1);
        neighbors.put("left", left);
        neighbors.put("right", right);
        neighbors.put("downleft", downLeft);
        neighbors.put("downright", downRight);
        neighbors.put("upleft", upLeft);
        neighbors.put("upright", upRight);
        return neighbors;
    }

    //get all neighbor cells of given cell with Status.On and Status.Food.
    private List<CatchCatGameComponent> availableCell(CatchCatGameComponent target, CatchCatGameState gameState) {
        List<CatchCatGameComponent> availableCell = new ArrayList<>();
        for (CatchCatGameComponent cell : getNeighbor(target, gameState).values()) {
            if (cell.getStatus().equals(Status.ON) || cell.getStatus().equals(Status.FOOD)) {
                availableCell.add(cell);
            }
        }
        return availableCell;
    }

    /**
     * set the status of all cells in neighborhood of given cell to Status.ON
     */
    private void eliminateBarrier(CatchCatGameComponent target, CatchCatGameState gameState){
        HashMap<String, CatchCatGameComponent> neighbor = getNeighbor(target, gameState);
        for(CatchCatGameComponent cell: neighbor.values()){
            if (cell.getStatus().equals(Status.OFF)){
                cell.setStatus(Status.ON);
            }
        }
    }

    /**
     * Move one target
     */
    private void moveTarget(int targetIndex, CatchCatGameState gameState) {
        if (lose(gameState)) { return; }
        CatchCatGameComponent target = gameState.getTargets().get(targetIndex);
        List<CatchCatGameComponent> availableCell = availableCell(target, gameState);
        if (availableCell.size() != 0) {
            Random random = new Random();
            CatchCatGameComponent cell = availableCell.get(random.nextInt(availableCell.size()));
            if(cell.getStatus().equals(Status.FOOD)){
                eliminateBarrier(cell, gameState);
            }
            gameState.moveCell(target, cell);
            gameState.getTargets().set(targetIndex, cell);
        }
    }

    /**
     * Move all targets
     */
    void move(CatchCatGameState gameState){
        for(int i = 0; i < gameState.getTargets().size(); i ++){
            moveTarget(i, gameState);
        }
        gameState.setSteps(gameState.getSteps() + 1);
    }
}

