package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Actor;

public class Enemy extends Actor {

    //Attributes

    //Constructors
    public Enemy(){
        super();
    }
    public Enemy(Coordinate coordinate){
        super(coordinate);
    }
    public Enemy(Coordinate coordinate,int healthpoints){
        super(coordinate,healthpoints);
    }
    public Enemy(int x, int y, int healthPoints){
        super(x,y,healthPoints);
    }

    //Methods

}
