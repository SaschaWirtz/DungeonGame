package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

public class Actor {

    protected int healthPoints,attack,defense,speed;
    protected Coordinate coordinate;

    /**
     * Constructor for Actor Objects
     * Not supposed to be actually used
     */
    public Actor(){
        coordinate=new Coordinate(0,0);
        healthPoints=100;
        attack=0;
        defense=0;
        speed=0;
    }
    /**
     * Get- and Setter Methods
     */
    public void SetCoordinate(Coordinate coordinate){
        this.coordinate=coordinate;
    }
    public void SetHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
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
    /**
     * Method to increase/decrease player health
     */
    public void AddHealthPoints(int healthPointsAdd){
        this.healthPoints+=healthPointsAdd;
    }
    /**
     * Methods for Player Movement
     */

}
