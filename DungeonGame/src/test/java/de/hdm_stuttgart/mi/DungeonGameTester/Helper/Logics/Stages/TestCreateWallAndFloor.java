/*
 * TestCreateWallAndFloor.java
 *
 * Testing class for CreateWallAndFloor.java.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-28 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.CreateWallAndFloor;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnitTest for wall and floor creation
 */
public class TestCreateWallAndFloor {

    //Are the walls in a ten by ten field correctly made
    @Test
    public void wallsOfArrayAreWallFieldTypesForTenByTenField() {
        FieldType[][] fieldType = new FieldType[10][10];
        new CreateWallAndFloor(fieldType);
        for (int i = 0; i < fieldType.length; i++) {
            if (i == 0 || i==fieldType.length - 1) {
                for (int z = 0; z < fieldType[i].length; z++) {
                    //Fill first and last line
                    Assert.assertTrue(fieldType[i][z] == FieldType.Wall);
                }
            } else {
                //Fill the lines in between
                Assert.assertTrue(fieldType[i][0] == FieldType.Wall);
                Assert.assertTrue(fieldType[i][fieldType[i].length-1] == FieldType.Wall);
            }
        }
    }

    //Are the floors in a ten by ten field correctly made
    @Test
    public void floorOfArrayAreWallFieldTypesForTenByTenField() {
        FieldType[][] fieldType = new FieldType[10][10];
        new CreateWallAndFloor(fieldType);
        for(int i = 1; i < fieldType.length - 1; i++) {
            for(int z = 1; z < fieldType[0].length - 1; z++) {
                Assert.assertTrue(fieldType[i][z] == FieldType.Floor);
            }
        }
    }

    //Are the walls in a five by ten field correctly made
    @Test
    public void wallsOfArrayAreWallFieldTypesForFiveByTenField() {
        FieldType[][] fieldType = new FieldType[5][10];
        new CreateWallAndFloor(fieldType);
        for (int i = 0; i < fieldType.length; i++) {
            if (i == 0 || i==fieldType.length - 1) {
                for (int z = 0; z < fieldType[i].length; z++) {
                    //Fill first and last line
                    Assert.assertTrue(fieldType[i][z] == FieldType.Wall);
                }
            } else {
                //Fill the lines in between
                Assert.assertTrue(fieldType[i][0] == FieldType.Wall);
                Assert.assertTrue(fieldType[i][fieldType[i].length-1] == FieldType.Wall);
            }
        }
    }

    //Are the floors in a five by ten field correctly made
    @Test
    public void floorOfArrayAreWallFieldTypesForFiveByTenField() {
        FieldType[][] fieldType = new FieldType[5][10];
        new CreateWallAndFloor(fieldType);
        for(int i = 1; i < fieldType.length - 1; i++) {
            for(int z = 1; z < fieldType[0].length - 1; z++) {
                Assert.assertTrue(fieldType[i][z] == FieldType.Floor);
            }
        }
    }

    //Are the walls in a twelve by eleven field correctly made
    @Test
    public void wallsOfArrayAreWallFieldTypesForTwelveByElevenField() {
        FieldType[][] fieldType = new FieldType[12][11];
        new CreateWallAndFloor(fieldType);
        for (int i = 0; i < fieldType.length; i++) {
            if (i == 0 || i==fieldType.length - 1) {
                for (int z = 0; z < fieldType[i].length; z++) {
                    //Fill first and last line
                    Assert.assertTrue(fieldType[i][z] == FieldType.Wall);
                }
            } else {
                //Fill the lines in between
                Assert.assertTrue(fieldType[i][0] == FieldType.Wall);
                Assert.assertTrue(fieldType[i][fieldType[i].length-1] == FieldType.Wall);
            }
        }
    }

    //Are the floors in a twelve by eleven field correctly made
    @Test
    public void floorOfArrayAreWallFieldTypesForTwelveByElevenField() {
        FieldType[][] fieldType = new FieldType[12][11];
        new CreateWallAndFloor(fieldType);
        for(int i = 1; i < fieldType.length - 1; i++) {
            for(int z = 1; z < fieldType[0].length - 1; z++) {
                Assert.assertTrue(fieldType[i][z] == FieldType.Floor);
            }
        }
    }
}
