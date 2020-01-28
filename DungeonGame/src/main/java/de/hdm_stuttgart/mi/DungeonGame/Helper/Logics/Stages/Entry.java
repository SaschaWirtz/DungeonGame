/*
 * Entry.java
 *
 * Door-class for door storage.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-28 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

public class Entry {

    //Attributes
    //Position of Entry
    private Directions direction;
    //Entry or Exit
    private boolean entrance;
    //Coordinate of Entry
    private Coordinate coordinate;

    private FieldType fieldType;



    /**
     * Constructor to add entrys direction and entrance status
     *
     * @param coordinate are the coordinates of the Entry
     * @param direction is the direction of the wall in which the entry sits in
     * @param entrance is saving if its a entry or a exit
     */
    public Entry(Coordinate coordinate, Directions direction, boolean entrance, FieldType fieldType) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.entrance = entrance;
        this.fieldType = fieldType;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public boolean isEntrance() {
        return entrance;
    }

    public void setEntrance(boolean entrance) {
        this.entrance = entrance;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public FieldType getFieldType() {
        return fieldType;
    }
}

