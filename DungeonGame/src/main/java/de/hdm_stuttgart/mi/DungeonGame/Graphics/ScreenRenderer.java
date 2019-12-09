/*
 * ScreenRenderer.java
 *
 * The main rendering class printing the current screen with it's content.
 *
 * author: Andreas G.
 * last edit / by: 2019-12-09 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import org.jline.terminal.*;

/**
 * The main rendering class printing the current screen with it's content
 */
public class ScreenRenderer {
    /**
     * Property containing the current screen buffer as char array.
     * The height and with depends on terminal with and height.
     */
    private char[][] screenBuffer;

    /**
     * Constructor initializing the screenBuffer array.
     */
    public ScreenRenderer() {
        //Initializing the screenBuffer
        resetScreenBuffer();
    }

    /**
     * Method resetting the current screen buffer for a new frame.
     */
    private void resetScreenBuffer() {
        try {
            screenBuffer = new char[TerminalBuilder.terminal().getHeight()][TerminalBuilder.terminal().getWidth()];
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }
    }

    /**
     * Method putting a new object or screen to the buffer. Object will be positioned
     * in the middle of the screen.
     *
     * @param object A char array containing the graphics object to be add to buffer
     */
//    public void putObjectInMiddle(char[][] object) {
//        //Check new terminal size and reset the buffer for new frame
//        resetScreenBuffer();
//
//        //Buffering the x and y coordinate values the object must be positioned at
//        int xPositionBuffer;
//        int yPositionBuffer;
//
//
//    }

    /**
     * Method putting a new object or screen to the buffer. Object will be positioned
     * at the provided coordinate.
     *
     * @param object A char array containing the graphics object to be add to buffer
     * @param xPosition The x value of the coordinate
     * @param yPosition The y value of the coordinate
     */
//    public void putObjectToPosition(char[][] object, int xPosition, int yPosition) {
//
//    }

    /**
     * Method printing the current buffer to the standard output.
     */
//    public void printScreen() {
//
//    }
}
