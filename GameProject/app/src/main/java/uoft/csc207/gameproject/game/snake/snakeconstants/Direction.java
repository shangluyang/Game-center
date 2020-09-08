package uoft.csc207.gameproject.game.snake.snakeconstants;
import java.util.HashMap;
import java.util.Map;

/**
 * Direction represents the direction and the velocity in the snake game as arrays of int.
 */
public class Direction {
    /**
     * the position changes of each directions with x coordinate at index 0 and y coordinate at index 1.
     */
    private final static int[] UP = {0, -50};
    private final static int[] DOWN = {0, 50};
    private final static int[] RIGHT = {50, 0};
    private final static int[] LEFT = {-50, 0};
    /**
     * the hash map that map the direction to velocity.
     */
    private Map<String, int[]> directions = new HashMap<>();

    /**
     * Constructs the direction class with hash map that keys are string of direction and values are velocity.
     */
    public Direction() {
        createDirection();
    }

    /**
     * Constructs the HashMap of the directions.
     */
    private void createDirection(){
        directions.put("up", UP);
        directions.put("down", DOWN);
        directions.put("right", RIGHT);
        directions.put("left", LEFT);
    }

    /**
     * Returns the corresponding direction based on the input parameter.
     */
    public int[] getDirectionCoordinate(String direction) {
        return directions.get(direction);
    }
}
