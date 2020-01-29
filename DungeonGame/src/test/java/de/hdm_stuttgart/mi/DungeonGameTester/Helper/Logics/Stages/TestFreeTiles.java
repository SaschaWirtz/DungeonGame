/*
 * TestPutEntryAndExit.java
 *
 * Testing class for PutEntryAndExit.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-28 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.CreateWallAndFloor;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.FreeTiles;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * JUnitTest for FreeTiles detection
 */
public class TestFreeTiles {

    // A five by five field has nine free tiles
    @Test
    public void nineFreeTilesInAFiveByFiveField() {
        FieldType[][] fieldType = new FieldType[5][5];
        new CreateWallAndFloor(fieldType);
        ArrayList<Coordinate> freeTiles = FreeTiles.freeTiles(fieldType);
        int floorCounter = 0;
        for(int i = 0; i < fieldType.length; i++) {
            for(int z = 0; z < fieldType[0].length; z++) {
                if(fieldType[i][z] == FieldType.Floor) {
                    floorCounter++;
                }
            }
        }
        Assert.assertTrue(floorCounter == 9);
    }

    // A five by ten field has twentyfour free tiles
    @Test
    public void twentyFourFreeTilesInAFiveByTenField() {
        FieldType[][] fieldType = new FieldType[5][10];
        new CreateWallAndFloor(fieldType);
        ArrayList<Coordinate> freeTiles = FreeTiles.freeTiles(fieldType);
        int floorCounter = 0;
        for(int i = 0; i < fieldType.length; i++) {
            for(int z = 0; z < fieldType[0].length; z++) {
                if(fieldType[i][z] == FieldType.Floor) {
                    floorCounter++;
                }
            }
        }
        Assert.assertTrue(floorCounter == 24);
    }

    // A twelve by seven field has fifty free tiles
    @Test
    public void fiftyFreeTilesInATwelveBySevenField() {
        FieldType[][] fieldType = new FieldType[12][7];
        new CreateWallAndFloor(fieldType);
        ArrayList<Coordinate> freeTiles = FreeTiles.freeTiles(fieldType);
        int floorCounter = 0;
        for(int i = 0; i < fieldType.length; i++) {
            for(int z = 0; z < fieldType[0].length; z++) {
                if(fieldType[i][z] == FieldType.Floor) {
                    floorCounter++;
                }
            }
        }
        Assert.assertTrue(floorCounter == 50);
    }
}
