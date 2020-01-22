/*
 * Coordinate.java
 *
 * Class to create Coordinate objects.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-22 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Constructor for a Coordinate object
     *
     * @param xCoordinate from the object
     * @param yCoordinate from the object
     */
    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * Getter for xCoordinate
     *
     * @return xCoordinate
     */
    public int getxCoordinate() {
        return xCoordinate;
    }


    /**
     * Getter for yCoordinate
     *
     * @return yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }
}
