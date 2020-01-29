/*
 * Field.java
 *
 * Main class for Room and Player managing.
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


public class Field {
    private static Player player = new Player(new Coordinate(1,1));
    private static Inventory inventory = new Inventory();
    private static Room room = new Room(Difficulty.Medium, new Entry(new Coordinate(1, 1), Directions.Top, Boolean.TRUE, FieldType.Door) );


    public static Player getPlayer() {
        return player;
    }

    public static Inventory getInventory() {
        return inventory;
    }

    public static Room getRoom() {
        return room;
    }

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


