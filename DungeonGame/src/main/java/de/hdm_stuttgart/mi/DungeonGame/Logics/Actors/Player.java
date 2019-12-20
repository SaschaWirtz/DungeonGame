package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Actor;

public class Player extends Actor {

    //Attributes

    //Constructors
    public Player(){
        super();
    }
    public Player(Coordinate coordinate){
        super(coordinate);
    }
    public Player(Coordinate coordinate, int healthpoints){
        super(coordinate,healthpoints);
    }
    public Player(int x, int y, int healthPoints){
        super(x,y,healthPoints);
    }

    //Methods

}
