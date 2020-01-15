/*
 * Inventory.java
 *
 * Inventory of the player for items (potions/coins/other items)
 *
 * author: Micha H.
 * last edit / by: 2019-01-15 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors;

//Import statements
// ...

// ToDo: public/protected/private

/**
 * Static inventory of the player to administer items (potions/coins).
 */
public class Inventory {

    /**
     * potions - array of the type Potion. Stores objects of the class Potion.
     *          Array size: 100
     *          ToDo: Array size can be increased automatically during the runtime.
     * potionsCounter - variable counts the objects inside the Array potions. Starts at 0.
     * coinsCounter - variable counts the collected coins. Starts at 0.
     */
    static private Potion[] potions = new Potion[100];  // Notiz für mich: 100 Felder und nicht feste Potionplätz + Anzahl, weil vllt auch Potions mit anderen Values möglich, die einen eigenen Platz im Array benötigen.
    static private int potionsCounter = 0;
    static private int coinsCounter = 0;

    /**
     * Adds a coin to the inventory
     */
    static public void collectCoin() { coinsCounter++; }

    /**
     * Adds a potion to the array potions at the last free position.
     * @param potion - object of the class Potion with the attributes type and value.
     */
    static protected void addPotion(Potion potion) {

        potions[potionsCounter] = potion;

        potionsCounter++;

    }

    /**
     * Method searches for actual potion and removes it of the inventory.
     * Removes the empty array field of the removed potion.
     * @param potion - object of type Potion
     */
    static public void usePotion(Potion potion) {

        // loops through array to find the right object
        for(int potionsPos=0; potionsPos<potionsCounter; potionsPos++) {
            if(potion.equals(potions[potionsPos])) {
                potions[potionsPos] = null; // Removes reference of the actual object Potion.
            }
        }

        // potions_tmp - temporarily array to sort array potions.
        Potion[] potions_tmp = new Potion[100];

        // copies all potion objects from array potions into array potions_tmp without null values
        int potions_tmp_counter = 0;
        for(int potionsPos=0; potionsPos<potionsCounter; potionsPos++) {
            if(potions[potionsPos] != null) {
                potions_tmp[potions_tmp_counter] = potions[potionsPos];
                potions_tmp_counter++;
            }
        }

        potions = potions_tmp;

        potionsCounter--;

    }

    // Only for testing.
    static public void printPotions() {

        int i = 0;
        while(potions[i] != null) {
            System.out.println("Type: " + potions[i].getType() + ", Value: " + potions[i].getValue());
            i++;
        }

    }

    /**
     * Only for Unit-Tests
     * @return potions - array with potion objects
     */
    static public Potion[] getPotions() {
        return potions;
    }

}
