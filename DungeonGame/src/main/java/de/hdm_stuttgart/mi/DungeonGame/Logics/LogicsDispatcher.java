/*
 * LogicsDispatcher.java
 *
 * Main class dispatching all the logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-25 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.ApplicationState;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.KeyCode;
import de.hdm_stuttgart.mi.DungeonGame.MainDispatcher;
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
    public void dispatchMainMenu(MainDispatcher mainDispatcher, AtomicReference<String[]> items, AtomicReference<Integer> selected, final int KEY_INPUT) {
        if (mainMenu == null) {
            //Creating a new main menu
            mainMenu = new MainMenu();

            //Get the initial information
            items.set(mainMenu.getMenuItems());
            selected.set(mainMenu.getCurrentSelection());
        } else {
            //Do the logics referred to the key input
            if (KEY_INPUT == KeyCode.ButtonW.getValue()) {
                mainMenu.selectionMoveUp();
            } else if (KEY_INPUT == KeyCode.ButtonS.getValue()) {
                mainMenu.selectionMoveDown();
            } else if (KEY_INPUT == KeyCode.ButtonENTER.getValue()) {
                mainMenu.select();
            } else {

            }

            //Get the new information
            items.set(mainMenu.getMenuItems());
            selected.set(mainMenu.getCurrentSelection());

            //Check if easter egg should be triggered
            if (mainMenu.getEasterEggState()) {
                mainDispatcher.setState(ApplicationState.EasterEgg);
                mainMenu.resetState();
                return;
            }

            //Check if application should be closed
            if (mainMenu.getShutdownState()) {
                mainDispatcher.setState(ApplicationState.PendingExit);
                mainMenu.resetState();
                return;
            }

            //Check if game start should be triggered
            if (mainMenu.getStartGameState()) {
                mainDispatcher.setState(ApplicationState.Field);
                mainMenu = null;
            }
        }
    }
}
