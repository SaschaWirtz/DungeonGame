/*
 * PutEntryAndExit.java
 *
 * Class to create Doors and Stairs.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-29 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Field;

import java.util.ArrayList;

public class PutEntryAndExit {

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

        //Save new data into PutEntryAndExit
        this.entry = entry;
        this.room = room;
        this.doorsAndStairs = doorsAndStairs;

        //EntryPosition based on chosen entry
        switch (entry.getDirection()) {

            //EntranceDoor in Top Wall
            case Top:
                putTopDoor();
                doorsAndStairs.get(0).setEntrance(true);
                putRandomExits();
                Field.getPlayer().SetCoordinate(new Coordinate(doorsAndStairs.get(0).getCoordinate().getxCoordinate(), doorsAndStairs.get(0).getCoordinate().getyCoordinate() + 1));
                break;

            //EntranceDoor in Right Wall
            case Right:
                putRightDoor();
                doorsAndStairs.get(0).setEntrance(true);
                putRandomExits();
                Field.getPlayer().SetCoordinate(new Coordinate(doorsAndStairs.get(0).getCoordinate().getxCoordinate() - 1, doorsAndStairs.get(0).getCoordinate().getyCoordinate()));
                break;

            //EntranceDoor in Bottom Wall
            case Bottom:
                putBottomDoor();
                doorsAndStairs.get(0).setEntrance(true);
                putRandomExits();
                Field.getPlayer().SetCoordinate(new Coordinate(doorsAndStairs.get(0).getCoordinate().getxCoordinate(), doorsAndStairs.get(0).getCoordinate().getyCoordinate() - 1));
                break;

            //EntranceDoor int Left Wall
            case Left:
                putLeftDoor();
                doorsAndStairs.get(0).setEntrance(true);
                putRandomExits();
                Field.getPlayer().SetCoordinate(new Coordinate(doorsAndStairs.get(0).getCoordinate().getxCoordinate() + 1, doorsAndStairs.get(0).getCoordinate().getyCoordinate()));
                break;

            //EntranceStairs into playfield
            default:
                putStairs();
                doorsAndStairs.get(0).setEntrance(true);
                putRandomExits();
                Field.getPlayer().SetCoordinate(new Coordinate(doorsAndStairs.get(0).getCoordinate().getxCoordinate() - 1, doorsAndStairs.get(0).getCoordinate().getyCoordinate()));
                break;
        }
    }

    /**
     * Putts a random available Exit
     */
    private void putRandomExits() {

        //Loop to ensure at least one exit
        for(entryPlaced = false; !entryPlaced;) {

            //Count of exits is randomized
            for(int nextEntry = 1; nextEntry == 1; nextEntry =(int) (Math.random() * 3)){

                //Position of exit is randomized
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

        //Find all free places for top door, at least one tile apart of eachother
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[1][column] == FieldType.Floor)
                    && !(room[1][column] == FieldType.Stairs)
                    && !(room[0][column] == FieldType.Door)
                    && !(room[0][column - 1] == FieldType.Door)
                    && !(room[0][column + 1] == FieldType.Door)) {

                //Write new door into possibleDoor array
                possibleDoors.add(new Coordinate(column, 0));
            }
        }

        //Set Direction of entry to top for doorsAndStairs array
        entry.setDirection(Directions.Top);

        //Add an top entry into doorsAndStairs array
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Right Wall
     */
    private void putRightDoor() {

        //Find all free places for right door, at least one tile apart of eachother
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][room[0].length - 2] == FieldType.Floor)
                    && !(room[row][room[0].length - 2] == FieldType.Stairs)
                    && !(room[row][room[0].length - 1] == FieldType.Door)
                    && !(room[row - 1][room[0].length - 1] == FieldType.Door)
                    && !(room[row + 1][room[0].length - 1] == FieldType.Door)) {

                //Write new door into possibleDoor array
                possibleDoors.add(new Coordinate(room[0].length - 1, row));
            }
        }

        //Set Direction of entry to right for doorsAndStairs array
        entry.setDirection(Directions.Right);

        //Add an top entry into doorsAndStairs array
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Bottom Wall
     */
    private void putBottomDoor() {

        //Find all free places for bottom door, at least one tile apart of eachother
        for(int column = 1; column < room[0].length - 1; column++) {
            if((room[room.length - 2][column] == FieldType.Floor)
                    && !(room[room.length - 2][column] == FieldType.Stairs)
                    && !(room[room.length - 1][column] == FieldType.Door)
                    && !(room[room.length - 1][column - 1] == FieldType.Door)
                    && !(room[room.length - 1][column + 1] == FieldType.Door)) {

                //Write new door into possibleDoor array
                possibleDoors.add(new Coordinate(column, room.length - 1));
            }
        }

        //Set Direction of entry to bottom for doorsAndStairs array
        entry.setDirection(Directions.Bottom);

        //Add an top entry into doorsAndStairs array
        add(FieldType.Door);
    }

    /**
     * Putts a Door in the Left Wall
     */
    private void putLeftDoor() {

        //Find all free places for left door, at least one tile apart of eachother
        for(int row = 1; row < room.length - 1; row++) {
            if((room[row][1] == FieldType.Floor)
                    && !(room[row][1] == FieldType.Stairs)
                    && !(room[row][0] == FieldType.Door)
                    && !(room[row - 1][0] == FieldType.Door)
                    && !(room[row + 1][0] == FieldType.Door)) {

                //Write new door into possibleDoor array
                possibleDoors.add(new Coordinate(0, row));
            }
        }

        //Set Direction of entry to left for doorsAndStairs array
        entry.setDirection(Directions.Left);

        //Add an top entry into doorsAndStairs array
        add(FieldType.Door);
    }

    /**
     * Putts Stairs in the playfield
     */
    private void putStairs() {

        //Array to buffer all possible places for stairs
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);

        //Find all free places for stairs, at least one tile apart of eachother
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

                //Write new door into possibleDoor array
                possibleDoors.add(availableTiles.get(freeTile));
            }
        }

        //Set Direction of entry to notdefined for doorsAndStairs array
        entry.setDirection(Directions.NotDefined);

        //Add an top entry into doorsAndStairs array
        add(FieldType.Stairs);
    }

    /**
     * Adds a tile into room
     *
     * @param tile added
     */
    private void add(FieldType tile) {

        //Only adds door if there is a door to add
        if(possibleDoors.size() > 0) {

            //Chooses on place ot of all possible places
            EntryPosition = possibleDoors.get((int) (Math.random() * possibleDoors.size()));

            //Changes FieldType of the chosen tile
            room[EntryPosition.getyCoordinate()][EntryPosition.getxCoordinate()] = tile;

            //Gives info that at least one door was placed
            entryPlaced = true;

            //Adds a new door or stairs object int to the doorsAndStairs array for logic uses
            doorsAndStairs.add(new Entry(EntryPosition, entry.getDirection(), false, tile));
        }

        //Clears possibleDoors array for next door spawn
        possibleDoors = new ArrayList<Coordinate>();
    }

}
