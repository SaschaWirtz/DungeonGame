/*
 * Field.java
 *
 * Main class for Room and Player management.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-29 / Lara B.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.Entry;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Enum.Difficulty;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

/**
 * Main class for Room and Player management
 */
public class Field {

    /**
     * Create Player
     */
    private static Player player = new Player(new Coordinate(1,1));

    /**
     * Create Inventory
     */
    private static Inventory inventory = new Inventory();

    /**
     * Create first room
     */
    private static Room room = new Room(Difficulty.Medium, new Entry(new Coordinate(1, 1), Directions.Top, Boolean.TRUE, FieldType.Door) );

    /**
     * Getter for player
     *
     * @return player object
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * Getter for inventory
     *
     * @return inventory object
     */
    public static Inventory getInventory() {
        return inventory;
    }

    /**
     * Getter for room
     *
     * @return room object
     */
    public static Room getRoom() {
        return room;
    }

    /**
     * Setter for room to create a new one after the first one was made
     * @param room is changed
     */
    public static void setRoom(Room room) {
        Field.room = room;
    }

    /**
     * resetting all field related properties
     */
    public static void resetField() {
        player = new Player(new Coordinate(1,1));
        inventory = new Inventory();
        room = new Room(Difficulty.Medium, new Entry(new Coordinate(1, 1), Directions.Top, Boolean.TRUE, FieldType.Door) );

    }
}


