/*
 * PutEntryAndExit.java
 *
 * Class to create Doors and Stairs.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-09 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

import java.util.ArrayList;

public class PutEntryAndExit {

    //Attributes
    //is a random number based on given parameter to place the entrance-door or stairs
    private Coordinate EntryPosition;
    //List of all possible doorpositions in a wall
    private ArrayList<Coordinate> possibleDoors = new ArrayList<Coordinate>();
    //room FieldType-array from Field.java
    private FieldType[][] room;
    //variable for test if entry is placed
    private boolean entryPlaced;
    //reference on all entry objects
    private ArrayList<Entry> doorsAndStairs;
    //Entry for direction
    private Entry entry;

    /**
     * Constructor to add Entry and Exit to Room in Field.java
     *
     * @param entry is a object of the Entry
     * @param room is a reference to the Room-array in Field.java
     */
    public PutEntryAndExit(Entry entry, FieldType[][] room, ArrayList<Entry> doorsAndStairs) {
        this.entry = entry;
        this.room = room;
        this.doorsAndStairs = doorsAndStairs;

        //EntryPosition based on choosen entry.

        switch (entry.direction) {
            //EntranceDoor int Top Wall
            case Top:
                putTopDoor();
                doorsAndStairs.get(0).entrance = true;
                putRandomExits();
                break;
            //EntranceDoor in Right Wall
            case Right:
                putRightDoor();
                doorsAndStairs.get(0).entrance = true;
                putRandomExits();
                break;
            //EntranceDoor in Bottom Wall
            case Bottom:
                putBottomDoor();
                doorsAndStairs.get(0).entrance = true;
                putRandomExits();
                break;
            //EntranceDoor int Left Wall
            case Left:
                putLeftDoor();
                doorsAndStairs.get(0).entrance = true;
                putRandomExits();
                break;
            //EntranceStairs in playfield
            default:
                putStairs();
                doorsAndStairs.get(0).entrance = true;
                putRandomExits();
                break;
        }
    }

    /**
     * Putts a random available Exit
     */
    private void putRandomExits() {
        for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 3)){
            for(entryPlaced = false; !entryPlaced;) {
                switch ((int) (Math.random() * 5)) {
                    case 1:
                        putTopDoor();
                        break;
                    case 2:
                        putRightDoor();
                        break;
                    case 3:
                        putBottomDoor();
                        break;
                    case 4:
                        putLeftDoor();
                        break;
                    default:
                        putStairs();
                        break;
                }
            }
        }
    }

    /**
     * Putts a Door in the Top wall
     */
    private void putTopDoor() {
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[1][column] == FieldType.Floor)
                    && !(room[1][column] == FieldType.Stairs)
                    && !(room[0][column] == FieldType.Door)
                    && !(room[0][column - 1] == FieldType.Door)
                    && !(room[0][column + 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(column, 0));
            }
        }
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Right Wall
     */
    private void putRightDoor() {
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][room[0].length - 2] == FieldType.Floor)
                    && !(room[row][room[0].length - 2] == FieldType.Stairs)
                    && !(room[row][room[0].length - 1] == FieldType.Door)
                    && !(room[row - 1][room[0].length - 1] == FieldType.Door)
                    && !(room[row + 1][room[0].length - 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(room[0].length - 1, row));
            }
        }
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Bottom Wall
     */
    private void putBottomDoor() {
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[room.length - 2][column] == FieldType.Floor)
                    && !(room[room.length - 2][column] == FieldType.Stairs)
                    && !(room[room.length - 1][column] == FieldType.Door)
                    && !(room[room.length - 1][column - 1] == FieldType.Door)
                    && !(room[room.length - 1][column + 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(column, room.length - 1));
            }
        }
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Left Wall
     */
    private void putLeftDoor() {
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][1] == FieldType.Floor)
                    && !(room[row][1] == FieldType.Stairs)
                    && !(room[row][0] == FieldType.Door)
                    && !(room[row - 1][0] == FieldType.Door)
                    && !(room[row + 1][0] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(0, row));
            }
        }
        add(FieldType.Door);
    }

    /**
     * Putts Stairs in the playfield
     */
    private void putStairs() {
        ArrayList<Coordinate> availableTiles = new FreeTiles().freeTiles(room);
        for(int freeTile = 0; freeTile < availableTiles.size(); freeTile++) {
            if((room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor)
                    && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor)) {
                possibleDoors.add(availableTiles.get(freeTile));
            }
        }
        add(FieldType.Stairs);
    }

    /**
     * Adds a tile into room
     *
     * @param tile added
     */
    private void add(FieldType tile) {
        if(possibleDoors.size() > 0) {
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = tile;
            entryPlaced = true;
            doorsAndStairs.add(new Entry(EntryPosition, entry.direction, false));
        }
        possibleDoors = new ArrayList<Coordinate>();
    }

}
