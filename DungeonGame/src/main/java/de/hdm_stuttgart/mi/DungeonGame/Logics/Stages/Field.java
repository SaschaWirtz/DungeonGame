/*
 * Field.java
 *
 * Main class for field creation and managing.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-18 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements

import de.hdm_stuttgart.mi.DungeonGame.Helper.Stages.CreateWallAndFloor;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Stages.Entry;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Stages.PutEntryAndExit;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Enum.Difficulty;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

/**
 * Junction of all Field related classes.
 */
public class Field {

    //Attributes

    //random FieldType hight
    private final int HIGHT = (int) (Math.random() * 25) + 5;
    //random FieldType width
    private final int WIDTH = (int) (Math.random() * 45) + 5;
    //new entry
    private Entry entry;
    //array with all entrys
    private Entry[] doors;
    //random roomType
    private final int ROOMTYPE = (int) (Math.random() * 100);
    //Difficulty
    private final Difficulty DIFFICULTY;

    /**
     * FieldType is the main array in which the end Field will be saved.
     */
    private FieldType[][] room = new FieldType[HIGHT][WIDTH];

    /**
     * Constructor to Field.
     *
     * @param entry is the new direction for entry position.
     */
    public Field(Difficulty difficulty, Entry entry) {
        this.DIFFICULTY = difficulty;
        this.entry = entry;

        //Fill room-array with simple wall and floor
        new CreateWallAndFloor(room);

        /**
         * Selection of roomtypes.
         */
        if(ROOMTYPE <= 100 && ROOMTYPE >= 0) {
            //Adding entry and exit
            new PutEntryAndExit(entry, room);
        //ToDo: Different map genertors
        }
    }

    /*
    public void checkPlayerField() {
        //ToDo:Item and Exit check
    }
     */

    /**
     * Passes on the EntryDirection for the next field.
     *
     * @return dirction of the new entry.
     */
    public Entry getEntry() {
        return entry;
    }

    /**
     * Reciving new direction for entry.
     *
     * @param entry is setting the new EntryDirection.
     */
    public void setEntry(Entry entry) {
        this.entry = entry;
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
