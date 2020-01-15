/*
 * CreateEnemies.java
 *
 * Spawn Enemies.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-15 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
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
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Coordinate> availableTiles = FreeTiles.freeTiles(room);
        for(int enemycount = 1; enemycount < FreeTiles.freeTiles(room).size() / 15; enemycount++) {
            int enemyCoordinate = (int) (Math.random() * availableTiles.size());
            enemies.add(new Enemy(availableTiles.get(enemyCoordinate)));
            availableTiles.remove(enemyCoordinate);
        }
        return enemies;
    }
}
