/*
 * SetCoins.java
 *
 * Class to spawn Coins.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-29 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Coin;
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

        //Initialise a list to keep count over every coin
        ArrayList<Coin> coins = new ArrayList<>();

        //ArrayList of all free Tiles in the room
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);

        //Create coins in an appropriate amount and add them to the coin list
        for(int coincount = 0; coincount < (Math.random() * (FreeTiles.freeTiles(room).size() / 20)); coincount++) {
            int coinCoordinate = (int) (Math.random() * availableTiles.size());
            coins.add(new Coin(availableTiles.get(coinCoordinate)));
            availableTiles.remove(coinCoordinate);
        }

        //Return list of coins
        return coins;
    }
}
