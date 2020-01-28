/*
 * Potions.java
 *
 * Class for creating potions
 *
 * author: Micha H.
 * last edit / by: 2019-01-28 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Enums.PotionType;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

/**
 * Class for creating objects of type Potion
 */
public class Potion {

    /**
     * Potion stats
     * type - defines the type of the potion from enum PotionType
     * value - defines the value of the effect of the potion
     * coordinate - x and y value of the potion
     */
    private PotionType type;
    private int value;
    private Coordinate coordinate;

    /**
     * constructor for creating objects of class Potion
     * @param type - type of the new potion object
     * @param value - value of the effect of the new potion object
     * @param coordinate - new Coorinate object with x and y value;
     */
    public Potion(PotionType type, int value, Coordinate coordinate) {

        this.type = type;
        this.value = value;
        this.coordinate = coordinate;

    }

    /**
     * Method adds the actual potion object to the Inventory.
     */
    public void moveInventory() {

        Inventory.addPotion(this);

    }

    // ToDo: Javadoc | override??
    public boolean equals(Potion otherPotion) {

        return type == otherPotion.type && value == otherPotion.value &&
                coordinate.getxCoordinate() == otherPotion.coordinate.getxCoordinate() &&
                coordinate.getyCoordinate() == otherPotion.coordinate.getyCoordinate();

    }

    @Override
    public String toString() {

        return "type: " + type + ", value: " + value + ", (" + coordinate.getxCoordinate() + "|" + coordinate.getyCoordinate() + ")";

    }

    /**
     * getter
     * @return type - type of the potion of type PotionType
     */
    public PotionType getType() {
        return type;
    }

    /**
     * getter
     * @return value - value of the potion of type int
     */
    public int getValue() {
        return value;
    }

    /**
     * getter
     * @return coordinate - coordinate of the potion of type Coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

}
