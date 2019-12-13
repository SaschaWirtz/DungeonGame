/*
 * Field.java
 *
 * Main class for field creation and managing.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-13 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements

import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

/**
 * Junction of all Field related classes.
 */
public class Field {

    //Attributes

    //random FieldType hight
    int hight = (int) Math.random() * 45 + 5;
    //random FieldType width
    int width = (int) Math.random() * 45 + 5;
    //new door x-coordinate
    int doorXCoordinate;
    //new door y-coordinate
    int doorYCoordinate;

    /**
     * Constructor to feed new door coordinates.
     * @param doorXCoordinate is the new x-coordinate for door position.
     * @param doorYCoordinate is the new y-coordinate for door position.
     */
    public Field(int doorXCoordinate, int doorYCoordinate){
        this.doorXCoordinate = doorXCoordinate;
        this.doorYCoordinate = doorYCoordinate;
    }

    /**
     * FieldType is the main array in which the end Field will be saved.
     */
    FieldType[][] room = new FieldType[hight][width];

    /**
     * Passes on the x-coordinate for the new door in next field.
     *
     * @return x-coordinate of the new door.
     */
    public int getDoorXCoordinate() {
        return doorXCoordinate;
    }

    /**
     * Reciving new x-coordinte for door / spawn.
     *
     * @param doorXCoordinate is setting the new door x-coordinate.
     */
    public void setDoorXCoordinate(int doorXCoordinate) {
        this.doorXCoordinate = doorXCoordinate;
    }

    /**
     * Passes on the y-coordinate for the new door in next field.
     *
     * @return y-coordinate of the new door.
     */
    public int getDoorYCoordinate() {
        return doorYCoordinate;
    }

    /**
     * Reciving new x-coordinate for new door / spawn.
     *
     * @param doorYCoordinate is setting the new door y-coordinte.
     */
    public void setDoorYCoordinate(int doorYCoordinate) {
        this.doorYCoordinate = doorYCoordinate;
    }

    /**
     * Returns FieldType for Field-, Player-interactions or rendering.
     *
     * @return a specific FieldType.
     */
    public FieldType[][] getRoom() {
        return room;
    }
}
