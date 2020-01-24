/*
 * Entry.java
 *
 * Door-class for door storage.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-24 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;

public class Entry {

    //Attributes
    //Position of Entry
    public Directions direction;
    //Entry or Exit
    public boolean entrance;
    //Coordinate of Entry
    public Coordinate coordinate;

    /**
     * Constructor to add entrys direction and entrance status
     *
     * @param coordinate are the coordinates of the Entry
     * @param direction is the direction of the wall in which the entry sits in
     * @param entrance is saving if its a entry or a exit
     */
    public Entry(Coordinate coordinate, Directions direction, boolean entrance) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.entrance = entrance;
    }

    public Directions getDirection() {
        return direction;
    }

    public boolean isEntrance() {
        return entrance;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
