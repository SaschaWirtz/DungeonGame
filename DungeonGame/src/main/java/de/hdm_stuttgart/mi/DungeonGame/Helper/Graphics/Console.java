/*
 * Console.java
 *
 * A static class with helper methods for console interaction
 *
 * author: Andreas G.
 * last edit / by: 2020-01-15 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics;

//Import statements
import java.io.IOException;

/**
 * A static class with helper methods for console interaction
 */
public class Console {
    /**
     * Clearing the current console screen
     */
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
