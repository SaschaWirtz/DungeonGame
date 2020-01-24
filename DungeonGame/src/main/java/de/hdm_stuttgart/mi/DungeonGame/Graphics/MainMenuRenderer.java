/*
 * MainMenuRenderer.java
 *
 * Renderer responsible for generating the main menu graphics
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces.IRenderable;
import java.util.Arrays;

/**
 * Renderer responsible for generating the main menu graphics.
 */
public class MainMenuRenderer extends Renderer implements IRenderable {
    /**
     * The id of the currently selected menu item
     */
    private int selected;

    /**
     * A constant string array with all the titles of the menu items
     */
    private final String[] ITEMS;

    /**
     * Variables containing the visual renderable buttons
     */
    private final char[][][] BUTTONS;

    /**
     * Method triggering the rendering process
     */
    @Override
    public void render() {
        //Initializing the screen buffer
        this.screenBuffer = this.getNewEmptyScreenBuffer(Screen.getInstance().getScreenBufferHeight(),Screen.getInstance().getScreenBufferWidth());

        //Variable for all the start indexes of the buttons
        int[] startIndexesVertical = new int[BUTTONS.length];

        //Filling the start indexes
        for (int i = 0; i < startIndexesVertical.length; i++) {
            //Helper/Buffer variables
            int heightSpacesBetween = (this.screenBuffer.length - (BUTTONS.length*5))/(BUTTONS.length+1) + 1;
            int startIndexBuffer = 0;

            //Adding the space of the buttons on top of the current one
            for (int z = 0; z < i; z++) {
                startIndexBuffer += heightSpacesBetween;
                startIndexBuffer += 5;
            }

            //Adding the space for the current button
            startIndexBuffer += heightSpacesBetween;

            //Storing the result
            startIndexesVertical[i] = startIndexBuffer;
        }

        int buttonCounter = 0;

        for (char[][] BUTTON:BUTTONS) {
            //Calculate the horizontal start index for the current button
            int startIndexHorizontal = ((this.screenBuffer[0].length-1)/2)-((BUTTON[0].length-1)/2);
            char[][] button;

            //Change the current button visual with the visual for a selected button if selected
            if (buttonCounter == selected) {
                button = this.getButtonAsSelected(BUTTON);
            } else {
                button = BUTTON;
            }

            //Positioning the button correctly on the screen
            for (int i = startIndexesVertical[buttonCounter]; i < button.length + startIndexesVertical[buttonCounter]; i++) {
                for (int z = startIndexHorizontal; z < button[i-startIndexesVertical[buttonCounter]].length + startIndexHorizontal; z++) {
                    this.screenBuffer[i][z] = button[i-startIndexesVertical[buttonCounter]][z-startIndexHorizontal];
                }
            }

            //Go on with the next button
            buttonCounter++;
        }

        //Print the screen buffer
        this.printScreen();
    }

    /**
     * Constructor creating a new MainMenuRenderer for printing the main menu
     *
     * @param ITEMS A string array with all titles of the menu items
     * @param SELECTION The integer value with the id of the selected item
     */
    public MainMenuRenderer(final String[] ITEMS, final int SELECTION) {
        //Initialize instance variables
        this.ITEMS = ITEMS;
        this.selected = SELECTION;
        this.BUTTONS = new char[this.ITEMS.length][][];

        this.generateButtons();
    }

    /**
     * Setting the selected item id with the new menu item id
     *
     * @param NEW_SELECTION The integer value for the id of the new selected item
     */
    public void setSelection(final int NEW_SELECTION) {
        this.selected = NEW_SELECTION;
    }

    /**
     * Method generating all the visual buttons for the menu items
     */
    private void generateButtons() {
        for (int i = 0; i < this.ITEMS.length; i++) {
            //Creating a temporary char array for the string and initialize the specific button visual
            char[] tempItemBuffer = this.ITEMS[i].toCharArray();
            this.BUTTONS[i] = this.getNewEmptyScreenBuffer(5, tempItemBuffer.length+4);

            //Calculating the begin index for centering the name within the scratch object
            int beginIndexHorizontal = 2;

            //Positioning the name in the middle of the button scratch object
            for (int z = beginIndexHorizontal; z < tempItemBuffer.length + beginIndexHorizontal; z++) {
                this.BUTTONS[i][2][z] = tempItemBuffer[z-beginIndexHorizontal];
            }
        }
    }

    /**
     * Method calculating the visual appearance of a button, if it is selected
     *
     * @param SOURCE_BUTTON The visual appearance in raw format
     * @return The visual appearance in selected state
     */
    private char[][] getButtonAsSelected(final char[][] SOURCE_BUTTON) {
        //Creating a copy of the two dimensional char array
        char[][] resultBuffer = Arrays.stream(SOURCE_BUTTON).map(char[]::clone).toArray(char[][]::new);

        //Drawing the border
        for (int i = 0; i < resultBuffer.length; i++) {
            if (i == 0 || i == resultBuffer.length-1) {
                //Draw for first and last line
                for (int z = 0; z < resultBuffer[i].length; z++) {
                    resultBuffer[i][z] = '#';
                }
            } else {
                //Draw all the other lines
                resultBuffer[i][0] = '#';
                resultBuffer[i][resultBuffer[i].length-1] = '#';
            }
        }

        //Return the result
        return resultBuffer;
    }
}
