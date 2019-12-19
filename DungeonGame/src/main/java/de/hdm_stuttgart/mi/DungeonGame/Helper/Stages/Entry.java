/*
 * Entry.java
 *
 * Door-class for door storage.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-18 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.Directions;

public class Entry {

    //Attributes
    //Position of Entry
    public Directions direction;
    //Entry or Exit
    public boolean entrance;

    /**
     * Constructor to add entrys direction and entrance status.
     *
     * @param direction is the direction of the wall in which the entry sits in.
     * @param entrance is saving if its a entry or a exit.
     */
    public Entry(Directions direction, boolean entrance) {
        this.direction = direction;
        this.entrance = entrance;
    }
}
