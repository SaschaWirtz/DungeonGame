package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

public class Actor {

    //Attributes
    protected int healthPoints,attack,defense,speed;
    protected Coordinate coordinate;


    //Constructors
    public Actor(){
        coordinate=new Coordinate(0,0);
        healthPoints=0;
        attack=0;
        defense=0;
        speed=0;
    }

    //Get- and Setter Methods
    public void SetCoordinate(Coordinate coordinate){
        this.coordinate=coordinate;
    }
    public void SetHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
    }
    public void AddHealthPoints(int healthPoints){
        this.healthPoints+=healthPoints;
    }
    public Coordinate GetCoordinate(){
        return coordinate;
    }
    public int GetHealthPoints(){
        return healthPoints;
    }
    public int GetAttack(){
        return attack;
    }
    public int GetDefense(){
        return defense;
    }
    public int GetSpeed(){
        return speed;
    }
}
