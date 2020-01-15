/*
 * Potions.java
 *
 * Class for creating potions
 *
 * author: Micha H.
 * last edit / by: 2019-01-15 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors;

//Import statements
// ...

// ToDo: public/protected/private

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;

/**
 * Class for creating objects of type Potion
 */
public class Potion {

    /**
     * Potion stats
     * type - defines the type of the potion from enum PotionType
     * value - defines the value of the effect of the potion
     */
    private PotionType type;
    private int value;

    /**
     * constructor for creating objects of class Potion
     * @param type - type of the new potion object
     * @param value - value of the effect of the new potion object
     */
    public Potion(PotionType type, int value) {

        this.type = type;
        this.value = value;

    }

    /**
     * Method adds the actual potion object to the Inventory.
     */
    public void moveInventory() {

        Inventory.addPotion(this);

    }

    // ToDo: Javadoc
    public boolean equals(Potion otherPotion) {

        return type == otherPotion.type && value == otherPotion.value;

    }

    /**
     * getter
     * @return type - variable of type PotionType
     */
    public PotionType getType() {
        return type;
    }

    /**
     * getter
     * @return value - variable of type int
     */
    public int getValue() {
        return value;
    }

}
