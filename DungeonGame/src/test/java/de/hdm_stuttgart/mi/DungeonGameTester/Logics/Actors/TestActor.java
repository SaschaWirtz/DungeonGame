package de.hdm_stuttgart.mi.DungeonGameTester.Logics.Actors;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Actor;
import org.junit.Assert;
import org.junit.Test;

public class TestActor {


    @Test public void testConstructor(){
        Actor a=new Actor();
        Assert.assertEquals(new Coordinate(0,0),a.GetCoordinate());
        Assert.assertEquals(100,a.GetHealthPoints());
        Assert.assertEquals(0,a.GetAttack());
        Assert.assertEquals(0,a.GetDefense());
        Assert.assertEquals(0,a.GetSpeed());
    }
    @Test public void testSetterMethods(){
        Actor a=new Actor();
        a.SetCoordinate(new Coordinate(10,10));
        Assert.assertEquals(new Coordinate(10,10),a.GetCoordinate());
        a.SetHealthPoints(111);
        Assert.assertEquals(111,a.GetHealthPoints());
    }
    @Test public void testAddHealthPoints(){
        Actor a=new Actor();
        a.AddHealthPoints(100);
        Assert.assertEquals(200,a.GetHealthPoints());
        a.AddHealthPoints(-20);
        Assert.assertEquals(180 ,a.GetHealthPoints());
    }
}
