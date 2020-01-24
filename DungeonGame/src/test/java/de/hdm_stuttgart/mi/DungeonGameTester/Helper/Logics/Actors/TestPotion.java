/*
 * Test.java
 *
 * The test game place
 *
 * author: Micha H.
 * last edit / by: 2019-01-15 / Micha H.
 */
package de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Actors;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Potion;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Enums.PotionType;
import org.junit.Assert;
import org.junit.Test;

public class TestPotion {
/**
    // ToDo: Noch kein Unit-Test!
//    public static void main(String[] args) {
//
//        Potion potion = new Potion(PotionType.HEALTH, 25);
//        potion.moveInventory();
//        Inventory.usePotion(potion);
//
//        potion = new Potion(PotionType.ATTACK, 20);
//        potion.moveInventory();
//
//        potion = new Potion(PotionType.DEFENSE, 15);
//        potion.moveInventory();
//
//        potion = new Potion(PotionType.SPEED, 10);
//        potion.moveInventory();
//
//        Inventory.printPotions();
//
//    }
//
//    @Test
//    /**
//     * Unit-Test is testing if created potion objects are correctly added to the inventory.
//     */
//    public void test_addPotion() {
//            Potion potion = new Potion(PotionType.HEALTH, 25);
//            potion.moveInventory();
//        Assert.assertEquals(potion, Inventory.getPotions()[0]);
//
//            potion = new Potion(PotionType.ATTACK, 20);
//            potion.moveInventory();
//        Assert.assertEquals(potion, Inventory.getPotions()[1]);
//
//            potion = new Potion(PotionType.DEFENSE, 15);
//            potion.moveInventory();
//        Assert.assertEquals(potion, Inventory.getPotions()[2]);
//
//            potion = new Potion(PotionType.SPEED, 10);
//            potion.moveInventory();
//        Assert.assertEquals(potion, Inventory.getPotions()[3]);
//    }
//
//    @Test
//    /**
//     * Unit-Test is testing if removed potion objects (no special order) are correctly removed from the inventory.
//     */
//    public void test_removePotion() {
//        test_addPotion();
//
//            Inventory.usePotion(Inventory.getPotions()[1]);
//            /**
//             * potions - array with potion objects like in the inventory for testing
//             */
//            Potion[] potions = new Potion[100];
//            potions[0] = new Potion(PotionType.HEALTH, 25);
//            potions[1] = new Potion(PotionType.DEFENSE, 15);
//            potions[2] = new Potion(PotionType.SPEED, 10);
//        for(int potionsPos=0; potionsPos<3; potionsPos++) {
//            Assert.assertTrue(potions[potionsPos].equals(Inventory.getPotions()[potionsPos]));
//        }
//
//            Inventory.usePotion(Inventory.getPotions()[1]);
//            potions = new Potion[100];
//            potions[0] = new Potion(PotionType.HEALTH, 25);
//            potions[1] = new Potion(PotionType.SPEED, 10);
//        for(int potionsPos=0; potionsPos<2; potionsPos++) {
//            Assert.assertTrue(potions[potionsPos].equals(Inventory.getPotions()[potionsPos]));
//        }
//
//            Inventory.usePotion(Inventory.getPotions()[0]);
//            potions = new Potion[100];
//            potions[0] = new Potion(PotionType.SPEED, 10);
//        Assert.assertTrue(potions[0].equals(Inventory.getPotions()[0]));
//
//            Inventory.usePotion(Inventory.getPotions()[0]);
//            potions = new Potion[100];
//        Assert.assertEquals(null, Inventory.getPotions()[0]);
//
//    }
}
