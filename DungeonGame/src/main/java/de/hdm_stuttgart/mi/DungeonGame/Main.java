/*
 * Main.java
 *
 * The main entry point for the game and related variables and methods.
 *
 * author: Moritz W.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Screen;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics.Console;
import java.io.Reader;

/**
 * A small DungeonGame project. Class containing the main entry point for the game.
 */
public class Main {
    /**
     * The main entry point for the DungeonGame.
     *
     * @param args Startup arguments provided at application startup
     */
    public static void main(String[] args) {
        //Ensuring that the screen is cleared. Please do not remove this line.
        Console.clear();

        //The main key reader loop
        try {
            //Getting the reader instance
            Reader reader = Screen.getInstance().getScreenReader();

            //The games main loop
            while (true) {
                //Read a new key code
                int input = reader.read();

                //ToDo: Handle the key code input
            }
        } catch (Exception e) {
            //ToDo: Logic error handling
        }
    }
}
