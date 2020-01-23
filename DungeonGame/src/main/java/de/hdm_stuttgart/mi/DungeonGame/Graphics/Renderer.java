/*
 * Renderer.java
 *
 * Abstract class providing variables and methods for all the
 * more specific Renderer classes.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-23 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements

/**
 * Abstract Renderer superclass providing variables and methods
 */
abstract class Renderer {
    /**
     * Placeholder for the screenBuffer within the specific Renderer
     */
    protected char[][] screenBuffer = null;

    /**
     * Placeholder for the screenBuffers height within specific Renderer
     */
    protected int bufferHeight = 0;

    /**
     * Placeholder for the screenBuffers width within specific Renderer
     */
    protected int bufferWidth = 0;

    /**
     * Method printing the screenBuffer for every renderer.
     */
    protected void printScreen() {
        //Provide the screenBuffer to Screen instance
        Screen.getInstance().setScreenBuffer(this.screenBuffer);

        //Let screen print the current buffer
        Screen.getInstance().printScreen();
    }

    /**
     * Method providing a new empty screen buffer array with whitespaces.
     *
     * @param height The height of the screen buffer
     * @param width The width of the screen buffer
     * @return The empty ready to use screen buffer
     */
    protected char[][] getNewEmptyScreenBuffer(final int height, final int width) {
        char[][] tempScreenBuffer = new char[height][width];

        for (int i = 0; i < tempScreenBuffer.length; i++) {
            for (int z = 0; z < tempScreenBuffer[i].length; z++) {
                tempScreenBuffer[i][z] = ' ';
            }
        }

        return tempScreenBuffer;
    }

    /**
     * Pause the execution for a specific number of milliseconds.
     *
     * @param milliseconds The time the application should be interrupted.
     */
    protected void sleep(final int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            //ToDo: A secure and senseful catching routine
        }
    }
}
