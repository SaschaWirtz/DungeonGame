/*
 * chooseNumberOfFreeTiles.java
 *
 * It chooses a number of free tiles.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-20 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import java.util.ArrayList;

public class ChooseNumberOfFreeTiles {
    /**
     * Method to choose a number of random Coordinates out of an arraylist and gives one back.
     *
     * @param freeTiles are all available free tiles
     * @param number number of needed chosenTiles
     * @return a ArrayList with all needed Coordinates
     */
    public ArrayList<Coordinate> chooseNumberOfFreeTiles(ArrayList<Coordinate> freeTiles, int number) {
        ArrayList<Coordinate> chosenTiles = new ArrayList<Coordinate>();
        for(int repetitions = 0; repetitions < number; repetitions++) {
            chosenTiles.add(freeTiles.get((int) (Math.random() * freeTiles.size())));
        }
        return chosenTiles;
    }
}
