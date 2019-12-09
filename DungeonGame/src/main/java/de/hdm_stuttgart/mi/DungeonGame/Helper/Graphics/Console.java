/*
 * Console.java
 *
 * A static class with helper methods for console interaction
 *
 * author: Andreas G.
 * last edit / by: 2019-12-06 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics;

//Import statements

/**
 * A static class with helper methods for console interaction
 */
public class Console {
    /**
     * Clearing the current console screen
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
