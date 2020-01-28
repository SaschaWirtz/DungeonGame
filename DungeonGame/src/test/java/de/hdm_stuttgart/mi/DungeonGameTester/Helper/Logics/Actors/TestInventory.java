/*
 * TestInventory.java
 *
 * Unit-Test for testing the Inventory
 *
 * author: Micha H.
 * last edit / by: 2019-01-22 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Actors;

// Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Coin;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Enums.PotionType;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Potion;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import org.junit.Assert;
import org.junit.Test;

public class TestInventory {

    @Test
    /**
     * Tests if coins are added correctly to the inventory.
     */
    public void test_addCoin() {
        for(int coins=0; coins<42; coins++) {
            Inventory.addCoin(new Coin(new Coordinate(10, 10)));
            Assert.assertEquals(coins+1, Inventory.getCoinsCounter());
        }
    }

    @Test
    /**
     * Unit-Test adds 6 potion to the inventory
     */
    public void inventoryOverflow() {
        Potion potion = new Potion(PotionType.HEALTH, 25, new Coordinate(10, 10));
        for(int potionAnzahl=0; potionAnzahl<6; potionAnzahl++) {
            potion.moveInventory();
        }
        Assert.assertTrue(Inventory.hasFreeSlot()); // one free slot
        potion.moveInventory(); // 7th potion.
        Assert.assertFalse(Inventory.hasFreeSlot()); // no free slot.
        potion.moveInventory(); // this would be the 8th potion.
    }

}
