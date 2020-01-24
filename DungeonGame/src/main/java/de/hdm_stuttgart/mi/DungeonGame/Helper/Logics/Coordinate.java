/*
 * Coordinate.java
 *
 * Class to create Coordinate objects.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-19 / Sascha W.
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
     * Setter for xCoordinate
     *
     * @param xCoordinate of object
     */
    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Getter for yCoordinate
     *
     * @return yCoordinate
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Setter for yCoordinate
     *
     * @param yCoordinate of object
     */
    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object obj) {
        Coordinate c=(Coordinate)obj;
        if(xCoordinate==c.xCoordinate&&yCoordinate==c.yCoordinate){
            return true;
        }
        else{
            return false;
        }
    }
}
