/*
 * Screen.java
 *
 * The main screen singleton class printing the current buffered screen with it's content.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-26 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics.Console;
import org.jline.terminal.*;
import java.io.Reader;

/**
 * The main screen singleton class printing the current buffered screen with it's content
 */
public class Screen {
    //----- Instance variables -----//

    /**
     * Property containing the current screen buffer as char array.
     * The height and with depends on terminal with and height.
     */
    private char[][] screenBuffer;

    /**
     * Property containing the virtual terminal object.
     */
    private Terminal terminal;



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
        try {
            //Initializing the virtual terminal
            terminal = TerminalBuilder.terminal();
            terminal.enterRawMode();
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }

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
            screenBuffer = new char[terminal.getHeight() - 1][terminal.getWidth()];
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
        resetScreenBuffer();

        return this.screenBuffer.length;
    }

    /**
     * Get the current screen buffer width
     *
     * @return The current screen buffer width
     */
    public int getScreenBufferWidth() {
        resetScreenBuffer();

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

        for (int i = 0; i < screenBuffer.length; i++) {
            for (char bufferChar : screenBuffer[i]) {
                sb.append(bufferChar);
            }

            //Only new line if it's not the last line
            if (i < screenBuffer.length - 1) {
                sb.append("\n");
            }
        }

        //Print the String to terminal
        System.out.println(sb.toString());
    }

    /**
     * Method providing the key reader for current terminal
     *
     * @return The key reader for current terminal
     */
    public Reader getScreenReader() {
        //Return a terminal reader for key events
        return terminal.reader();
    }

    /**
     * Method closing the connection to current terminal for virtual terminal instance
     */
    public void closeTerminalConnection() {
        try {
            //Close the terminal connection
            terminal.close();
        } catch (Exception e) {
            //ToDo: Creating a logical and secure catch routine
        }
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
}
