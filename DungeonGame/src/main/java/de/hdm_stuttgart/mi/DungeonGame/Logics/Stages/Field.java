/*
 * Field.java
 *
 * Main class for Room and Player managing.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-15 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Stages.Entry;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Enum.Difficulty;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;


public class Field {
    private static Player player = new Player();
    private static Room room = new Room(Difficulty.Medium, new Entry(new Coordinate(1, 1), Directions.Top, Boolean.TRUE) );
    public void changeRoom() {
        room = new Room(Difficulty.Medium, room.getEntry());
    }

    public static Player getPlayer() {
        return player;
    }

    public static Room getRoom() {
        return room;
    }
}


