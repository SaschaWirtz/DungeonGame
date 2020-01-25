/*
 * FieldRenderer.java
 *
 * Renderer responsible for generating the field graphics
 *
 * author: Sascha W.
 * last edit / by: 2020-01-25 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statement
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces.IRenderable;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

/**
 * Renderer responsible for generating the field graphics.
 */
public class FieldRenderer extends Renderer implements IRenderable {

    FieldType[][] room;
    Inventory inventory;
    Player player;
    char[][] fieldSpace;
    char[][] inventorySpace;
    char[][] statusSpace;


    /**
     * Method triggering the rendering process
     */
    @Override
    public void render() {
        this.bufferHeight = Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();
        screenBuffer = getNewEmptyScreenBuffer(bufferHeight, bufferWidth);
        fieldSpace();
        for(int hight = 0; hight < fieldSpace.length; hight++) {
            for(int width = 0; width < fieldSpace[0].length; width++) {
                screenBuffer[hight][width] = fieldSpace[hight][width];
            }
        }
        this.printScreen();
    }

    /**
     * Method to feed FieldRenderer the needed data
     * @param room
     * @param inventory
     * @param player
     */
    public void setRenderer(FieldType[][] room, Inventory inventory, Player player) {
        this.bufferHeight= Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();
        this.room = room;
        this.inventory = inventory;
        this.player = player;
    }

    /**
     * Method to fill the fieldSpace with room-data
     */
    private char[][] fieldSpace() {
        fieldSpace = new char[bufferHeight - 9][bufferWidth / 3 * 2];
//        for(int  = 0, spaceHight < )
//        char[][] fieldBuffer = new char[][];
        return fieldSpace;
    }

    /**
     * Method to fill the inventorySpace with inventory-data
     */
    private char[][] inventorySpace() {
        inventorySpace = new char[bufferHeight - 9][bufferWidth / 3];
        return inventorySpace;
    }

    /**
     * Method to fill the statusSpace with status-data
     */
    private char[][] statusSpace() {
        statusSpace = new char[9][bufferWidth];
        return statusSpace;
    }
}
