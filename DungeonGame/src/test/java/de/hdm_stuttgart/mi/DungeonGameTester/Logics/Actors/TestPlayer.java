package de.hdm_stuttgart.mi.DungeonGameTester.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import org.junit.Assert;
import org.junit.Test;

public class TestPlayer {
    @Test public void testConstructor(){
        Player p=new Player(new Coordinate(3,3));
        Assert.assertEquals(new Coordinate(3,3),p.GetCoordinate());
    }
}
