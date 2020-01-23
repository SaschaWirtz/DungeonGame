/*
 * Screen.java
 *
 * The main screen singleton class printing the current buffered screen with it's content.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-23 / Andreas G
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics.Console;
import org.jline.terminal.*;

/**
 * The main screen singleton class printing the current buffered screen with it's content
 */
class Screen {
    //----- Instance variables -----//

    /**
     * Property containing the current screen buffer as char array.
     * The height and with depends on terminal with and height.
     */
    private char[][] screenBuffer;



    //----- Class variables -----//

    /**
     * Containing the singleton instance. There can't exist a other
     * screen object.
     */
    private static Screen screenInstance;



    //----- Constructor -----//

    /**
     * Private constructor initializing the screenBuffer array.
     */
    private Screen() {
        //Initializing the screenBuffer
        resetScreenBuffer();
    }



    //----- Instance methods -----//

    /**
     * Method resetting the current screen buffer for a new frame.
     */
    private void resetScreenBuffer() {
        try {
            //Setting the buffer height and width to current terminal size
            screenBuffer = new char[TerminalBuilder.terminal().getHeight()][TerminalBuilder.terminal().getWidth()];
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }
    }

    /**
     * Get the current screen buffer height
     *
     * @return The current screen buffer height
     */
    public int getScreenBufferHeight() {
        return this.screenBuffer.length;
    }

    /**
     * Get the current screen buffer width
     *
     * @return The current screen buffer width
     */
    public int getScreenBufferWidth() {
        return this.screenBuffer[0].length;
    }

    /**
     * Resetting the screen buffer and buffer a new screen
     *
     * @param screenBuffer The char array to buffer for next printing execution
     */
    public void setScreenBuffer(final char[][] screenBuffer) {
        resetScreenBuffer();

        this.screenBuffer = screenBuffer;
    }

    /**
     * Method printing the current buffer to the standard output.
     */
    public void printScreen() {
        //Clear the whole console
        Console.clear();

        //Building a screen representing the console screen
        StringBuilder sb = new StringBuilder();

        for (char[] bufferLine : screenBuffer) {
            for (char bufferChar : bufferLine) {
                sb.append(bufferChar);
            }
            sb.append("\n");
        }

        //Print the String to terminal
        System.out.println(sb.toString());
    }



    //----- Class methods -----//

    /**
     * Get the screen singleton and create the object if it doesn't exist.
     *
     * @return The screen singleton instance
     */
    public static Screen getInstance() {
        //Create the instance if null
        if (screenInstance == null) {
            screenInstance = new Screen();
        }

        //Return the instance
        return screenInstance;
    }

    /**
     * Get the current terminals height.
     *
     * @return The terminals height
     */
    public static int getScreenHeight() {
        try {
            return TerminalBuilder.terminal().getHeight();
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }

        return -1;
    }

    /**
     * Get the current terminals width
     *
     * @return The terminals width
     */
    public static int getScreenWidth() {
        try {
            return TerminalBuilder.terminal().getWidth();
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }

        return -1;
    }
}
