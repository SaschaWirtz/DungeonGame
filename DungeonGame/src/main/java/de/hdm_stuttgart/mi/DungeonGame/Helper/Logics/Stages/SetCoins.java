/*
 * SetCoins.java
 *
 * Class to spawn Coins.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-24 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import java.util.ArrayList;

public class SetCoins {
    /**
     * Method to spawn and list coins.
     *
     * @param room Main room
     * @return Coinlist
     */
    public static ArrayList fillCoinList(FieldType[][] room){
        ArrayList<Coordinate> coins = new ArrayList<>();
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);
        for(int coincount = 0; coincount < FreeTiles.freeTiles(room).size() / 20; coincount++) {
            int coinCoordinate = (int) (Math.random() * availableTiles.size());
            coins.add(availableTiles.get(coinCoordinate));
            availableTiles.remove(coinCoordinate);
        }
        return coins;
    }
}
