package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Field;

public class Enemy extends Actor {

    /**
     * Constructor for a new Enemy Object
     */
    public Enemy(Coordinate coordinate,int healthPoints,int attack,int defense,int speed){
        this.coordinate=coordinate;
        this.healthPoints=healthPoints;
        this.attack=attack;
        this.defense=defense;
        this.speed=speed;
    }

    /**
     * Method to Change the Enemy's Position
     * Changes the Enemy Position Based on the Player Position
     */
    public void NextMove(){
        Coordinate playerPosition= Field.getPlayer().GetCoordinate();
        if(Field.getPlayer().GetLastMoveDirection()) {
            if (coordinate.getyCoordinate() < playerPosition.getyCoordinate() && Field.getRoom().getFieldType(coordinate.getxCoordinate(), coordinate.getyCoordinate() + 1).isWalkable()) {
                coordinate.addyCoordinate(1);
            } else if (coordinate.getyCoordinate() > playerPosition.getyCoordinate() && Field.getRoom().getFieldType(coordinate.getxCoordinate(), coordinate.getyCoordinate() - 1).isWalkable()) {
                coordinate.addyCoordinate(-1);
            } else if (coordinate.getxCoordinate() < playerPosition.getxCoordinate() && Field.getRoom().getFieldType(coordinate.getxCoordinate() + 1, coordinate.getyCoordinate()).isWalkable()) {
                coordinate.addxCoordinate(1);
            } else if (coordinate.getxCoordinate() > playerPosition.getxCoordinate() && Field.getRoom().getFieldType(coordinate.getxCoordinate() - 1, coordinate.getyCoordinate()).isWalkable()) {
                coordinate.addxCoordinate(-1);
            }
        }
        else {
            if (coordinate.getxCoordinate() < playerPosition.getxCoordinate()&&Field.getRoom().getFieldType(coordinate.getxCoordinate()+1,coordinate.getyCoordinate()).isWalkable()) {
                coordinate.addxCoordinate(1);
            } else if (coordinate.getxCoordinate() > playerPosition.getxCoordinate()&&Field.getRoom().getFieldType(coordinate.getxCoordinate()-1,coordinate.getyCoordinate()).isWalkable()) {
                coordinate.addxCoordinate(-1);
            } else if (coordinate.getyCoordinate() < playerPosition.getyCoordinate()&&Field.getRoom().getFieldType(coordinate.getxCoordinate(),coordinate.getyCoordinate()+1).isWalkable()) {
                coordinate.addyCoordinate(1);
            } else if (coordinate.getyCoordinate() > playerPosition.getyCoordinate()&&Field.getRoom().getFieldType(coordinate.getxCoordinate(),coordinate.getyCoordinate()-1).isWalkable()) {
                coordinate.addyCoordinate(-1);
            }
        }
    }


}
