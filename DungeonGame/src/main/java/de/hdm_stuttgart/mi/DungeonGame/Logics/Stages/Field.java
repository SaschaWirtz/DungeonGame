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
    private final int HIGHT = (int) (Math.random() * 45) + 5;
    //random FieldType width
    private final int WIDTH = (int) (Math.random() * 45) + 5;
    //new entry direction
    private Directions EntryDirection;
    //random roomType
    private final int ROOMTYPE = (int) Math.random() * 100;

    /**
     * Constructor to Field.
     *
     * @param EntryDirection is the new direction for entry position.
     */
    public Field(Directions EntryDirection) {
        this.EntryDirection = EntryDirection;

        //Fill room with Floor
        for(int hight = 0; hight < (room.length - 1); hight++) {
            for(int width = 1; width < (room[0].length - 1); width++) {
                room[hight][width] = FieldType.Floor;
            }
        }

        //Place top wall
        for(int width = 1; width < room[0].length; width++) {
            room[0][width] = FieldType.Wall;
        }

        //Place left wall
        for(int higth = 1; higth < room.length - 1; higth++) {
            room[higth][room[0].length - 1] = FieldType.Wall;
        }

        //Place bottom wall
        for(int hight = 0; hight < room.length - 1; hight++) {
            room[hight][0] = FieldType.Wall;
        }

        //Place right wall
        for(int width = 0; width < room[0].length; width++) {
            room[room.length - 1][width] = FieldType.Wall;
        }
    }

    /**
     * FieldType is the main array in which the end Field will be saved.
     */
    FieldType[][] room = new FieldType[HIGHT][WIDTH];

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

    /**
     * Returns FieldType for Field-, Player-interactions or rendering.
     *
     * @return a specific FieldType.
     */
    public FieldType[][] getRoom() {
        return room;
    }
}
