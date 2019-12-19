/*
 * PutEntryAndExit.java
 *
 * Class to create Doors and Stairs.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-19 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

import java.util.ArrayList;

public class PutEntryAndExit {

    //Attributes
    //is a random number based on given parameter to place the enrance-door or staris
    Coordinate EntryPosition;
    //List of all possible doorpositions in a wall
    ArrayList<Coordinate> possibleDoors = new ArrayList<Coordinate>();
    FieldType[][] room;

    /**
     * Constructor to add Entry and Exit to Room in Field.java.
     *
     * @param entry is a object of the Entry.
     * @param room is a reference to the Room-array in Field.java.
     */
    public PutEntryAndExit(Entry entry, FieldType[][] room) {
        this.room = room;

        /**
         * EntryPosition based on choosen entry.
         */
        switch (entry.direction) {
            //EntranceDoor int Top Wall
            case Top:
                putTopDoor();
                for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 2)){
                    switch((int )(Math.random() * 4)){
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
                break;
            //EntranceDoor in Right Wall
            case Right:
                putRightDoor();
                for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 2)){
                    switch((int )(Math.random() * 4)){
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
                break;
            //EntranceDoor in Bottom Wall
            case Bottom:
                putBottomDoor();
                for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 2)){
                    switch((int )(Math.random() * 4)){
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
                break;
            //EntranceDoor int Left Wall
            case Left:
                putLeftDoor();
                for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 2)){
                    switch((int )(Math.random() * 4)){
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
                break;
            //EntranceStairs in playfield
            default:
                putStairs();
                for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 2)){
                    switch((int )(Math.random() * 4)){
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
                break;
            //ToDo: Arraylist for Entrys
        }
    }

    /**
     * Putts a Door in the Top wall
     */
    private void putTopDoor() {
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[1][column] == FieldType.Floor) && !(room[1][column] == FieldType.Stairs) && !(room[0][column] == FieldType.Door) && !(room[0][column - 1] == FieldType.Door) && !(room[0][column + 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(column, 0));
            }
        }
        if(possibleDoors.size() > 0) {
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
        }
    }

    /**
     * Putts a Door in the Right Wall
     */
    private void putRightDoor() {
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][room[0].length - 2] == FieldType.Floor) && !(room[row][room[0].length - 2] == FieldType.Stairs) && !(room[row][room[0].length - 1] == FieldType.Door) && !(room[row - 1][room[0].length - 1] == FieldType.Door) && !(room[row + 1][room[0].length - 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(room[0].length - 1, row));
            }
        }
        if(possibleDoors.size() > 0) {
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
        }
    }

    /**
     * Putts a Door in the Bottom Wall
     */
    private void putBottomDoor() {
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[room.length - 2][column] == FieldType.Floor) && !(room[room.length - 2][column] == FieldType.Stairs) && !(room[room.length - 1][column] == FieldType.Door) && !(room[room.length - 1][column - 1] == FieldType.Door) && !(room[room.length - 1][column + 1] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(column, room.length - 1));
            }
        }
        if(possibleDoors.size() > 0) {
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
        }
    }

    /**
     * Putts a Door in the Left Wall
     */
    private void putLeftDoor() {
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][1] == FieldType.Floor) && !(room[row][1] == FieldType.Stairs) && !(room[row][0] == FieldType.Door) && !(room[row - 1][0] == FieldType.Door) && !(room[row + 1][0] == FieldType.Door)) {
                possibleDoors.add(new Coordinate(0, row));
            }
        }
        if(possibleDoors.size() > 0) {
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Door;
        }
    }

    /**
     * Putts Stairs in the playfield
     */
    private void putStairs() {
        ArrayList<Coordinate> availableTiles = new FreeTiles().freeTiles(room);
        for(int freeTile = 0; freeTile < availableTiles.size(); freeTile++) {
            if((room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate() + 1] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate()] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() + 1][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate()][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor) && (room[availableTiles.get(freeTile).getyCoordinate() - 1][availableTiles.get(freeTile).getxCoordinate() - 1] == FieldType.Floor)) {
                possibleDoors.add(availableTiles.get(freeTile));
            }
        }
        EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));
        room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = FieldType.Stairs;
    }
}
