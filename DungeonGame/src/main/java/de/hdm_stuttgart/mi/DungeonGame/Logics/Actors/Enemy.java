package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;

public class Enemy extends Actor {

    //Attributes

    //Constructors
    public Enemy(Coordinate coordinate,int healthPoints,int attack,int defense,int speed){
        this.coordinate=coordinate;
        this.healthPoints=healthPoints;
        this.attack=attack;
        this.defense=defense;
        this.speed=speed;
    }

    //Methods

}
