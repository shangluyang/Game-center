package uoft.csc207.gameproject.game.catchcat;

import java.io.Serializable;

/**
 *
 * CatchCatGameComponent for CatchCat. Contains information of the game.
 */
class CatchCatGameComponent implements Serializable{

    // the x coordinate of the game component
    private int x;
    // the y coordinate of the game component
    private int y;
    // the status of this gameComponent
    private Status status;

    // initialize this game Component
    CatchCatGameComponent(int x, int y) {
        this.x = x;
        this.y = y;
        status = Status.ON;
    }

    /**
     * Setter for status of this gameComponent.
     * @param  status the status of this gameComponent
     */

    void setStatus(Status status) {
        this.status = status;
    }

    /**
     * getter for status of this gameComponent.
     * @return  status the status of this gameComponent
     */
    Status getStatus() {
        return status;
    }

    /**
     * getter for x coordinate of this gameComponent.
     * @return  x coordinate of this gameComponent.
     */
    int getX() {
        return x;
    }

    /**
     * getter for y coordinate of this gameComponent.
     * @return  y coordinate of this gameComponent.
     */
    int getY() {
        return y;
    }

    /**
     * check whether this game Component is at Boundary
     */
    boolean isAtBoundary() {
        return (getX() == 0 | getX() == 9 | getY() == 0 | getY() == 9);
    }
}
