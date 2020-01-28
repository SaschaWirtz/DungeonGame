package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Coordinate;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Field;

public class Player extends Actor {

    private boolean lastMovementDirection;
    /**
     * Constructor for a new Player Object
     */
    public Player(Coordinate coordinate){
        this.coordinate=coordinate;
        attack=25;
        defense=0;
        speed=10;
        lastMovementDirection=true;
    }
    /**
     * Get- and Setter Methods
     */
    public boolean GetLastMoveDirection(){
        return lastMovementDirection;
    }
    /**
     * Methods to Move the Player in one cardinal Direction
     * Checks if the Player can move to the next Tile and increases/decreases Coordinate if possible
     * returns true if movement was possible
     */
    public boolean MoveUp(){
        if(Field.getRoom().getFieldType(coordinate.getxCoordinate(),coordinate.getyCoordinate()-1).isWalkable()){
            coordinate.addyCoordinate(-1);
            lastMovementDirection=false;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean MoveDown(){
        if(Field.getRoom().getFieldType(coordinate.getxCoordinate(),coordinate.getyCoordinate()+1).isWalkable()){
            coordinate.addyCoordinate(1);
            lastMovementDirection=false;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean MoveLeft(){
        if(Field.getRoom().getFieldType(coordinate.getxCoordinate()-1,coordinate.getyCoordinate()).isWalkable()){
            coordinate.addxCoordinate(-1);
            lastMovementDirection=true;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean MoveRight(){
        if(Field.getRoom().getFieldType(coordinate.getxCoordinate()+1,coordinate.getyCoordinate()).isWalkable()){
            coordinate.addxCoordinate(1);
            lastMovementDirection=false;
            return true;
        }
        else{
            return false;
        }
    }

}
