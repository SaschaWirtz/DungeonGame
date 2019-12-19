/*
 * PutEntryAndExit.java
 *
 * Class to create Doors and Stairs.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-18 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

import java.util.ArrayList;

public class PutEntryAndExit {

    /**
     * Constructor to add Entry and Exit to Room in Field.java.
     *
     * @param entry is a object of the Entry.
     * @param room is a reference to the Room-array in Field.java.
     */
    public PutEntryAndExit(Entry entry, FieldType[][] room) {

        //Attributes
        //is a random number based on given parameter to place the enrance-door or staris
        final Coordinate EntryPosition;
        //List of all possible doorpositions in a wall
        ArrayList<Coordinate> possibleDoors = new ArrayList<Coordinate>();

        /**
         * EntryPosition based on choosen entry.
         */
        switch (entry.direction) {
            //EntranceDoor int Top Wall
            case Top:
                for(int column = 1; column < room[0].length - 1; column++) {
                    if((room[1][column] == FieldType.Floor) || (room[1][column] == FieldType.ItemField)) {
                        possibleDoors.add(new Coordinate(column, 0));
                    }
                }
                EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
                room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
                break;
            //EntranceDoor in Right Wall
            case Right:
                for(int row = 1; row < room.length - 1; row++) {
                    if((room[row][room[0].length - 2] == FieldType.Floor) || (room[row][room[0].length - 2] == FieldType.ItemField)) {
                        possibleDoors.add(new Coordinate(room[0].length - 1, row));
                    }
                }
                EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
                room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
                break;
            //EntranceDoor in Bottom Wall
            case Bottom:
                for(int column = 1; column < room[0].length - 1; column++) {
                    if((room[room.length - 2][column] == FieldType.Floor) || (room[room.length - 2][column] == FieldType.ItemField)) {
                        possibleDoors.add(new Coordinate(column, room.length - 1));
                    }
                }
                EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
                room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
                break;
            //EntranceDoor int Left Wall
            case Left:
                for(int row = 1; row < room.length - 1; row++) {
                    if((room[row][1] == FieldType.Floor) || (room[row][1] == FieldType.ItemField)) {
                        possibleDoors.add(new Coordinate(0, row));
                    }
                }
                EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
                room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
                break;
            //EntranceStairs in playfield
            default:
                EntryPosition = new FreeTiles().freeTiles(room).get((int) (Math.random() * new FreeTiles().freeTiles(room).size()));
                room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Stairs;
                //ToDo: Make it for all usable
                break;
            //ToDo: Add Exit Points
        }
    }
}
