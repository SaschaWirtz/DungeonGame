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
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.Entry;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages.PutEntryAndExit;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 * JUnitTest for Entry and Exit spawns.
 */
public class TestPutEntryAndExit {

    //Are at least one entrance and one exit in the room
    @Test
    public void atLeastOneExitAndEntrence() {
        FieldType[][] fieldType = new FieldType[10][10];
        new CreateWallAndFloor(fieldType);
        new PutEntryAndExit(new Entry(new Coordinate(1,0), Directions.Top, true, FieldType.Door), fieldType, new ArrayList<>());
        int doorCounter = 0;
        for(int i = 0; i < fieldType.length; i++) {
            for(int z = 0; z < fieldType[0].length; z++) {
                doorCounter++;
            }
        }
        Assert.assertTrue(doorCounter > 1);
    }
}
