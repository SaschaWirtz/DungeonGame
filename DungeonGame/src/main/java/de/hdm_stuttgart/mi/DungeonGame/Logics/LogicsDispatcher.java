/*
 * LogicsDispatcher.java
 *
 * Main class dispatching all the logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics;

//Import statements
import java.util.concurrent.atomic.AtomicReference;

/**
 * Main class dispatching all the logics processes
 */
public class LogicsDispatcher {
    /**
     * The property storing the main menu instance
     */
    private MainMenu mainMenu;

    /**
     * Constructor for this class
     */
    public LogicsDispatcher() {}

    /**
     * Method initializing logics on first startup and provide the information
     *
     * @param items The reference type forwarding the menu items
     * @param selected The reference type forwarding the id of the selected item
     */
    public void init(AtomicReference<String[]> items, AtomicReference<Integer> selected) {
        //Creating a new main menu
        mainMenu = new MainMenu();

        //Get the initial information
        items.set(mainMenu.getMenuItems());
        selected.set(mainMenu.getCurrentSelection());
    }
}
