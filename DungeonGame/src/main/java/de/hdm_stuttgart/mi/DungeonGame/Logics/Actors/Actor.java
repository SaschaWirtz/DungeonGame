package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

public class Actor {

    //Attributes
    protected int healthPoints;
    protected Coordinate coordinate;

    //Constructors
    public Actor(){
        coordinate=new Coordinate(0,0);
        healthPoints=100;
    }
    public Actor(Coordinate position,int healthPoints){
        this.coordinate=position;
        this.healthPoints=healthPoints;
    }
    public Actor(Coordinate coordinate){
        this.coordinate=coordinate;
        healthPoints=100;
    }
    public Actor(int x, int y, int healthPoints){
        coordinate=new Coordinate(x,y);
        this.healthPoints=healthPoints;
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
}
