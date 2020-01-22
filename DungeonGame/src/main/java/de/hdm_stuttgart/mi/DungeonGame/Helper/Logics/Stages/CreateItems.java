/*
 * CreateItems.java
 *
 * Class to spawn Items.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-22 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Enums.PotionType;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Potion;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import java.util.ArrayList;

public class CreateItems {
    /**
     * Method to spawn and list items.
     *
     * @param room Main room
     * @return Itemlist
     */
    public static ArrayList fillItemList(FieldType[][] room){
        ArrayList<Potion> items = new ArrayList<>();
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);
        for(int itemcount = 0; itemcount < FreeTiles.freeTiles(room).size() / 15; itemcount++) {
            int itemCoordinate = (int) (Math.random() * availableTiles.size());
            PotionType potiont;
//            items.add(new Potion(PotionType.values()[(int) ((Math.random() * PotionType.values().length)], ));
            availableTiles.remove(itemCoordinate);
        }
        return items;
    }
}
