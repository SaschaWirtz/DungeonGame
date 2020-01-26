/*
 * FieldRenderer.java
 *
 * Renderer responsible for generating the field graphics
 *
 * author: Sascha W.
 * last edit / by: 2020-01-26 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces.IRenderable;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Field;

/**
 * Renderer responsible for generating the field graphics.
 */
public class FieldRenderer extends Renderer implements IRenderable {
    /**
     * Property storing the current room visualization
     */
    private FieldType[][] room;

    /**
     * Property storing the current inventory situation
     */
    private Inventory inventory;

    /**
     * Property storing the current information of the player
     */
    private Player player;


    /**
     * Method triggering the rendering process
     */
    @Override
    public void render() {
        //Creating a new screen buffer with the current terminal size
        this.bufferHeight = Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();
        screenBuffer = getNewEmptyScreenBuffer(bufferHeight, bufferWidth);

        //Triggering the generation of the field space of the screen
        char[][] fieldSpace = fieldSpace();

        //Positioning of the field space within the screen buffer
        for (int hight = 0; hight < fieldSpace.length; hight++) {
            for (int width = 0; width < fieldSpace[0].length; width++) {
                screenBuffer[hight][width] = fieldSpace[hight][width];
            }
        }

        //Triggering the generation of the inventory space of the screen
        char[][] inventorySpace = inventorySpace(fieldSpace[0].length);

        //Positioning of the inventory space within the screen buffer
        for (int hight = 0; hight < inventorySpace.length; hight++) {
            for (int width = fieldSpace[0].length; width < inventorySpace[0].length + fieldSpace[0].length; width++) {
                screenBuffer[hight][width] = inventorySpace[hight][width - fieldSpace[0].length];
            }
        }

        //Triggering the generation of the status space of the screen
        char[][] statusSpace = statusSpace();

        //Positioning of the status space within the screen buffer
        int screenHight = bufferHeight - statusSpace.length;
        for (int hight = 0; hight < statusSpace.length; hight++) {
            for (int width = 0; width < statusSpace[0].length; width++) {
                screenBuffer[screenHight][width] = statusSpace[hight][width];
            }
            screenHight++;
        }

        //Print the screen buffer to the terminal
        this.printScreen();
    }

    /**
     * Method to feed FieldRenderer the needed data
     *
     * @param room      from Field
     * @param inventory from Inventory
     * @param player    from Inventory
     */
    public void setRenderer(FieldType[][] room, Inventory inventory, Player player) {
        this.room = room;
        this.inventory = inventory;
        this.player = player;
    }

    /**
     * Method to cut out the needed field part for rendering
     *
     * @return resulted fieldSpace
     */
    public char[][] fieldSpace() {
        //Generating a temporary field space char array buffer
        char[][] fieldSpace = new char[bufferHeight - 9][bufferWidth / 4 * 3];

        //Preparing the generated field with secure borders
        char[][] fieldBuffer = new char[2 * room.length + fieldSpace.length][2 * room[0].length + fieldSpace[0].length];

        //Fill it with the Wall sign
        for (int hight = 0; hight < fieldBuffer.length; hight++) {
            for (int width = 0; width < fieldBuffer[0].length; width++) {
                fieldBuffer[hight][width] = FieldType.Wall.getVisual();
            }
        }

        //Positioning of the field in the middle of the buffer
        int startIndexHorizontal = (fieldBuffer[0].length/2)-(room[0].length/2);
        int startIndexVertical = (fieldBuffer.length/2)-(room.length/2);

        for (int i = startIndexVertical; i < startIndexVertical + room.length; i++) {
            for (int z = startIndexHorizontal; z < startIndexHorizontal + room[0].length; z++) {
                fieldBuffer[i][z] = room[i-startIndexVertical][z-startIndexHorizontal].getVisual();
            }
        }

        //Adjusted player coordinates
        int playerPostionNewHorizontal = player.GetCoordinate().getxCoordinate() + startIndexHorizontal;
        int playerPositionNewVertical = player.GetCoordinate().getyCoordinate() + startIndexVertical;
        int startIndexPreparedFieldHorizontal = playerPostionNewHorizontal - fieldSpace[0].length / 2;
        int startIndexPreparedFieldVertical = playerPositionNewVertical - fieldSpace.length / 2;

        //Cut out the visual part of the prepared field array
        for (int hight = 0; hight < fieldSpace.length; hight++) {
            for (int width = 0; width < fieldSpace[0].length; width++) {
                fieldSpace[hight][width] = fieldBuffer[hight + startIndexPreparedFieldVertical + 1][width + startIndexPreparedFieldHorizontal + 1];
            }
        }

        //Add border and return result
        adBorder(fieldSpace);
        return fieldSpace;
    }

    /**
     * Method to fill the inventorySpace with inventory-data
     */
    private char[][] inventorySpace(final int START_INDEX) {
        //Generate a temporary char[][] buffer
        char[][] inventorySpace = getNewEmptyScreenBuffer(bufferHeight - 9, bufferWidth - START_INDEX);

        //Calculating start indexes
        int startIndexVertical = (inventorySpace.length - Inventory.getPotions().length) / (Inventory.getPotions().length + 1) + 1;
        int startIndexHorizontal = 3;

        //Positioning of item slots
        for(int i = startIndexVertical; i / startIndexVertical < Inventory.getPotions().length + 1; i += startIndexVertical) {
            char[] currentElement = (Inventory.getPotions()[i / startIndexVertical - 1] == null) ? ("" + (i / startIndexVertical) + ":").toCharArray() : ("" + (i / startIndexVertical) + ": " + Inventory.getPotions()[i / startIndexVertical - 1].getType().getCHARACTER() + " (" + Inventory.getPotions()[i / startIndexVertical - 1].getValue() + ")").toCharArray();
            for(int z = startIndexHorizontal; z < currentElement.length + startIndexHorizontal; z++) {
                inventorySpace[i + 1][z] = currentElement[z - startIndexHorizontal];
            }
        }

        //Add border and return result
        adBorder(inventorySpace);
        return inventorySpace;
    }


    /**
     * Method to fill the statusSpace with status-data
     */
    private char[][] statusSpace() {
        //Generate a temporary char[][] buffer
        char[][] statusSpace = getNewEmptyScreenBuffer(9, bufferWidth);

        //Convert int to char array
        char[] health = ("Health: " + player.GetHealthPoints()).toCharArray();
        char[] attack = ("Attack: " + player.GetAttack()).toCharArray();
        char[] defense = ("Defense: " + player.GetDefense()).toCharArray();
        char[] speed = ("Speed: " + player.GetSpeed()).toCharArray();

        //Adding stats into statusSpace
        for(int i = 0; i < health.length; i++) {
            statusSpace[3][statusSpace[0].length / 5 + i] = health[i];
        }
        for(int i = 0; i < attack.length; i++) {
            statusSpace[5][statusSpace[0].length / 5 + i] = attack[i];
        }
        for(int i = 0; i < defense.length; i++) {
            statusSpace[3][statusSpace[0].length / 5 * 3 + i] = defense[i];
        }
        for(int i = 0; i < speed.length; i++) {
            statusSpace[5][statusSpace[0].length / 5 * 3 + i] = speed[i];
        }

        //Add border and return result
        adBorder(statusSpace);
        return statusSpace;
    }

    /**
     * Method to add a border to a specific space
     *
     * @param space to border
     */
    private void adBorder(char[][] space) {
        for (int i = 0; i < space.length; i++) {
            if (i == 0 || i==space.length - 1) {
                for (int z = 0; z < space[i].length; z++) {
                    //Fill first and last line
                    space[i][z] = 'O';
                }
            } else {
                //Fill the lines in between
                space[i][0] = 'O';
                space[i][space[i].length-1] = 'O';
            }
        }
    }
}
