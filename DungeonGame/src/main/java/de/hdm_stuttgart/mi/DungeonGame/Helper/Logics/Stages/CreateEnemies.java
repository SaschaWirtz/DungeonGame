/*
 * CreateEnemies.java
 *
 * Spawn Enemies.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-28 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Enemy;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import java.util.ArrayList;

public class CreateEnemies {
    /**
     * Method to spawn and list enemies.
     *
     * @param room Main room
     * @return Enemylist
     */
    public static ArrayList fillEnemyList(FieldType[][] room){
        /**
         * Initialise a list to keep count over every enemy
         */
        ArrayList<Enemy> enemies = new ArrayList<>();

        /**
         * ArrayList of all free Tiles in the room
         */
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);

        //Create enemies in an appropriate amount and add them to the enemy list
        for(int enemycount = 0; enemycount < (Math.random() * (FreeTiles.freeTiles(room).size() / 18)); enemycount++) {
            int enemyCoordinate = (int) (Math.random() * availableTiles.size());
            enemies.add(new Enemy(availableTiles.get(enemyCoordinate), 10, 10, 10, 10));
            availableTiles.remove(enemyCoordinate);
        }

        //Return list of enemies
        return enemies;
    }
}
