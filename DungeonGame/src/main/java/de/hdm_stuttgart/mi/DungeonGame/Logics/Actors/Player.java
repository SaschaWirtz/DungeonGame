package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Actor;

public class Player extends Actor {

    //Attributes

    //Constructors
    public Player(Coordinate coordinate){
        this.coordinate=coordinate;
        attack=25;
        defense=0;
        speed=10;
    }

    //Methods

}
