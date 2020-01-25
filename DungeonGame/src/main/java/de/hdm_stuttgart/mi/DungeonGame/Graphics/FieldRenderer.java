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
        inventorySpace();
        for(int hight = 0; hight < inventorySpace.length; hight++) {
            int screenWidth = bufferWidth - inventorySpace[0].length;
            for(int width = 0; width < inventorySpace[0].length; width++) {
                screenBuffer[hight][screenWidth] = inventorySpace[hight][width];
                screenWidth++;
            }
        }
        statusSpace();
        int screenHight = bufferHeight - statusSpace.length;
        for(int hight = 0; hight < statusSpace.length; hight++) {
            for(int width = 0; width < statusSpace[0].length; width++) {
                screenBuffer[screenHight][width] = statusSpace[hight][width];
            }
            screenHight++;
        }
        this.printScreen();
    }

    /**
     * Method to feed FieldRenderer the needed data
     *
     * @param room from Field
     * @param inventory from Inventory
     * @param player from Inventory
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
        fieldSpace = getNewEmptyScreenBuffer(bufferHeight - 9, bufferWidth / 4 * 3);
        adBorder(fieldSpace);
//        char[][] fieldBuffer = new char[][];
        return fieldSpace;
    }

    /**
     * Method to fill the inventorySpace with inventory-data
     */
    private char[][] inventorySpace() {
        inventorySpace = getNewEmptyScreenBuffer(bufferHeight - 9, bufferWidth - fieldSpace[0].length);
        adBorder(inventorySpace);
        return inventorySpace;
    }

    /**
     * Method to fill the statusSpace with status-data
     */
    private char[][] statusSpace() {
        statusSpace = getNewEmptyScreenBuffer(9, bufferWidth);
        adBorder(statusSpace);
        return statusSpace;
    }

    /**
     * Method to add a border to a specific space
     *
     * @param space to border
     */
    private void adBorder(char[][] space) {
        for(int spaceHight = 0; spaceHight < space.length - 1; spaceHight++) {
            space[spaceHight][0] = 'O';
        }
        for(int spaceHight = 1; spaceHight < space.length - 1; spaceHight++) {
            space[spaceHight][space[0].length - 1] = 'O';
        }
        for(int spaceWidth = 0; spaceWidth < space[0].length; spaceWidth++) {
            space[space.length - 1][spaceWidth] = 'O';
        }
        for(int spaceWidth = 1; spaceWidth < space[0].length; spaceWidth++) {
            space[0][spaceWidth] = 'O';
        }
    }
}
