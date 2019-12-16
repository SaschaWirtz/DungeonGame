/*
 * Field.java
 *
 * Main class for field creation and managing.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-16 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements

import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
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
    //new entry direction
    Directions EntryDirection;

    /**
     * Constructor to feed new EntryDirection.
     *
     * @param EntryDirection is the new direction for entry position.
     */
    public Field(Directions EntryDirection){
        this.EntryDirection = EntryDirection;
    }

    /**
     * FieldType is the main array in which the end Field will be saved.
     */
    FieldType[][] room = new FieldType[hight][width];

    /**
     * Passes on the EntryDirection for the next field.
     *
     * @return dirction of the new entry.
     */
    public Directions getEntryDirection() {
        return EntryDirection;
    }

    /**
     * Reciving new direction for entry.
     *
     * @param entryDirection is setting the new EntryDirection.
     */
    public void setEntryDirection(Directions entryDirection) {
        EntryDirection = entryDirection;
    }

    /*
    public int getSpawnXCoordinate(){
        //ToDo: Spawn x-coordinate in relation to door.
        }
    */

    /*
    public int getSpawnYCoordinate(){
        //ToDo: Spawn y-coordinate in relation to door.
    }
     */

    /**
     * Returns FieldType for Field-, Player-interactions or rendering.
     *
     * @return a specific FieldType.
     */
    public FieldType[][] getRoom() {
        return room;
    }
}
