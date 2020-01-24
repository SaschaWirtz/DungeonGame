/*
 * Room.java
 *
 * Class for room creation and managing.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-24 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Coin;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Potion;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.*;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Enemy;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Enum.Difficulty;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

import java.util.ArrayList;

/**
 * Junction of all Field related classes.
 */
public class Room {

    //Attributes

    //random FieldType hight
    private final int HIGHT = (int) (Math.random() * 9) + 6;
    //random FieldType width
    private final int WIDTH = (int) (Math.random() * 19) + 6;
    //new entry
    private Entry entry;
    //List with all entrys
    private ArrayList<Entry> doorsAndStairs = new ArrayList<Entry>();
    //random roomType
    private final int ROOMTYPE = (int) (Math.random() * 100);
    //Difficulty
    private final Difficulty DIFFICULTY;
    //List of all Enemies
    private ArrayList<Enemy> enemies;
    //List of all Items
    private ArrayList<Potion> items;
    //List of all Coins
    private ArrayList<Coin> coins;

    /**
     * FieldType is the main array in which the end Field will be saved.
     */
    private FieldType[][] room = new FieldType[HIGHT][WIDTH];

    /**
     * Constructor to Field.
     *
     * @param entry is the new direction for entry position.
     */
    public Room(Difficulty difficulty, Entry entry) {
        this.DIFFICULTY = difficulty;
        this.entry = entry;

        //Fill room-array with simple wall and floor
        new CreateWallAndFloor(room);

        /**
         * Selection of roomtypes.
         */
        if(ROOMTYPE <= 100 && ROOMTYPE >= 0) {
            //Adding entry and exit
            new PutEntryAndExit(entry, room, doorsAndStairs);
        //ToDo: Different map genertors
        }
        refreshRoom();

        //Create Enemys
        enemies = CreateEnemies.fillEnemyList(room);
        refreshRoom();

        //Create Items
        items = CreateItems.fillItemList(room);
        refreshRoom();

        //Set Coins;
        coins = SetCoins.fillCoinList(room);
        refreshRoom();
    }

    /**
     * Refresh room with new Player, Enemy, Item and Coin Coordinates
     */

    private void refreshRoom() {
        for(int width = 1; width < room.length - 1; width++) {
            for(int hight = 1; hight < room[0].length - 1; hight++) {
                if(room[width][hight] == FieldType.Enemy || room[width][hight] == FieldType.ItemField || room[width][hight] == FieldType.CoinField || room[width][hight] == FieldType.Player) {
                    room[width][hight] = FieldType.Floor;
                }
            }
        }
        if(!(enemies == null)) {
            for (int enemycount = 0; enemycount < enemies.size(); enemycount++) {
                room[enemies.get(enemycount).GetCoordinate().getyCoordinate()][enemies.get(enemycount).GetCoordinate().getxCoordinate()] = FieldType.Enemy;
            }
        }
        if(!(items == null)) {
            for (int itemcount = 0; itemcount < items.size(); itemcount++) {
                room[items.get(itemcount).getCoordinate().getyCoordinate()][items.get(itemcount).getCoordinate().getxCoordinate()] = FieldType.ItemField;
            }
        }
        if(!(coins == null)) {
            for (int coinCount = 0; coinCount < coins.size(); coinCount++) {
                room[coins.get(coinCount).getCoordinate().getyCoordinate()][coins.get(coinCount).getCoordinate().getxCoordinate()] = FieldType.CoinField;
            }
        }
        room[Field.getPlayer().GetCoordinate().getyCoordinate()][Field.getPlayer().GetCoordinate().getxCoordinate()] = FieldType.Player;
    }

    /**
     * Method to trigger other mechanics
     */

    public void checkPlayerField() {
        int coinCounter = 0;
        int itemCounter = 0;
        int entryCounter = 0;
        int enemyConter = 0;
        boolean playerTileEquelsCoinTile = false;
        for(int coin = 0; coin < coins.size(); coin++) {
            if(Field.getPlayer().GetCoordinate().equals(coins.get(coin).getCoordinate())) {
                playerTileEquelsCoinTile = true;
                coinCounter = coin;
            }
        }
        boolean playerTileEquelsItemTile = false;
        for(int item = 0; item < items.size(); item++) {
            if(Field.getPlayer().GetCoordinate().equals(items.get(item).getCoordinate())) {
                playerTileEquelsItemTile = true;
                itemCounter = item;
            }
        }
        boolean playerTileEquelsEntryTile = false;
        for(int entry = 0; entry < doorsAndStairs.size(); entry++) {
            if(Field.getPlayer().GetCoordinate().equals(doorsAndStairs.get(entry).getCoordinate())) {
                playerTileEquelsEntryTile = true;
                entryCounter = entry;
            }
        }
        boolean playerTileEquelsEnemyTile = false;
        for(int enemy = 0; enemy < enemies.size(); enemy++) {
            if(Field.getPlayer().GetCoordinate().equals(enemies.get(enemy).GetCoordinate()) ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() - 1 ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() + 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() - 1 ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() + 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() + 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() + 1 ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() + 1 ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() - 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() + 1 ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() - 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() ||
               Field.getPlayer().GetCoordinate().getxCoordinate() == enemies.get(enemy).GetCoordinate().getxCoordinate() - 1 &&
               Field.getPlayer().GetCoordinate().getyCoordinate() == enemies.get(enemy).GetCoordinate().getyCoordinate() - 1) {
                playerTileEquelsEnemyTile = true;
                enemyConter = enemy;
            }
        }

        if(playerTileEquelsCoinTile){
            Field.getInventory().addCoin(coins.get(coinCounter));
            coins.remove(coinCounter);
        }
        if(playerTileEquelsItemTile){
            Field.getInventory().addPotion(items.get(itemCounter));
            items.remove(itemCounter);
        }
        if(playerTileEquelsEntryTile){
            switch(doorsAndStairs.get(entryCounter).getDirection()) {
                case Top:
                    entry = new Entry(doorsAndStairs.get(entryCounter).getCoordinate(), Directions.Bottom, true);
                    break;
                case Right:
                    entry = new Entry(doorsAndStairs.get(entryCounter).getCoordinate(), Directions.Left, true);
                    break;
                case Bottom:
                    entry = new Entry(doorsAndStairs.get(entryCounter).getCoordinate(), Directions.Top, true);
                    break;
                case Left:
                    entry = new Entry(doorsAndStairs.get(entryCounter).getCoordinate(), Directions.Right, true);
                    break;
                default:
                    entry = new Entry(doorsAndStairs.get(entryCounter).getCoordinate(), Directions.NotDefined, true);
                    break;
            }

            Field.setRoom(new Room(Difficulty.Medium, getEntry()));
        }else if(playerTileEquelsEnemyTile) {
//            startFight();
            enemies.remove(enemyConter);
        }
        //ToDo: An Laras Klassen anpassen
    }


    /**
     * Passes on the EntryDirection for the next field.
     *
     * @return dirction of the new entry.
     */
    public Entry getEntry() {
        return entry;
    }


    /**
     * Returns FieldType for Field-, Player-interactions or rendering.
     *
     * @return a specific FieldType.
     */
    public FieldType[][] getRoom() {
        refreshRoom();
        return room;
    }

    /**
     * Returns a requested FieldType
     *
     * @param xCoordinate of requested tile
     * @param yCoordinate of requested tile
     * @return FieldType of requested tile
     */
    public FieldType getFieldType(int xCoordinate, int yCoordinate) {
        refreshRoom();
        return room[yCoordinate][xCoordinate];
    }
}
