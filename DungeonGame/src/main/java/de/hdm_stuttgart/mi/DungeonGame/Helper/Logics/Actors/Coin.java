/*
 * Coin.java
 *
 * Class for creating coins.
 *
 * author: Micha H.
 * last edit / by: 2019-01-22 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors;

// Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

public class Coin {

    /**
     * coordinate - x and y value of the coin
     */
    private Coordinate coordinate;

    /**
     * constructor for creating objects of class Coin
     * @param coordinate - new Coorinate object with x and y value;
     */
    public Coin(Coordinate coordinate) {

        this.coordinate = coordinate;

    }

    /**
     * getter
     * @return coordinate - coordinate of the potion of type Coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

}
