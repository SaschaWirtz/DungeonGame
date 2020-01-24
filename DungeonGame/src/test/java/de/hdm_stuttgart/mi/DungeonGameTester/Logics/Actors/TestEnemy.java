package de.hdm_stuttgart.mi.DungeonGameTester.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Enemy;
import org.junit.Assert;
import org.junit.Test;

public class TestEnemy {
    @Test public void testConstructor(){
        Enemy e =new Enemy(new Coordinate(2,3),100,20,5,1);
        Assert.assertEquals(new Coordinate(2,3),e.GetCoordinate());
        Assert.assertEquals(100,e.GetHealthPoints());
        Assert.assertEquals(20,e.GetAttack());
        Assert.assertEquals(5,e.GetDefense());
        Assert.assertEquals(1,e.GetSpeed());
    }
}
