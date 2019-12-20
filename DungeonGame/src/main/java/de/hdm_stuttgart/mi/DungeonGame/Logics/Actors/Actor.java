package de.hdm_stuttgart.mi.DungeonGame.Logics.Actors;

public class Actor {

    //Attributes
    protected int x , y ,healthPoints;

    //Constructors
    public Actor(){
        x=0;
        y=0;
        healthPoints=100;
    }
    public Actor(int x, int y, int healthPoints){
        this.x=x;
        this.y=y;
        this.healthPoints=healthPoints;
    }

    //Get- and Setter Methods
    public void SetX(int x){
        this.x=x;
    }
    public void SetY(int y){
        this.y=y;
    }
    public void SetXY(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void SetHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
    }
    public void AddHealthPoints(int healthPoints){
        this.healthPoints+=healthPoints;
    }
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public int GetHealthPoints(){
        return healthPoints;
    }
}
