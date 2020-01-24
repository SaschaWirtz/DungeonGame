/*
 * MainDispatcher.java
 *
 * Main dispatcher controlling and triggering the rendering processes and logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.GraphicsDispatcher;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.ApplicationState;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.KeyCode;
import de.hdm_stuttgart.mi.DungeonGame.Logics.LogicsDispatcher;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Main dispatcher controlling and triggering the rendering processes and logics processes
 */
public class MainDispatcher {
    /**
     * Variable storing the current state of the application
     */
    private ApplicationState state;

    /**
     * The property storing a instance of the graphics dispatcher
     */
    private GraphicsDispatcher graphicsDispatcher = new GraphicsDispatcher();

    /**
     * The property storing a instance of the logics dispatcher
     */
    private LogicsDispatcher logicsDispatcher = new LogicsDispatcher();

    /**
     * Constructor creating an instance of this class
     */
    public MainDispatcher() {
        //Changing the current state to main menu
        state = ApplicationState.MainMenu;

        //Dipatching the main menu
        AtomicReference<String[]> items = new AtomicReference<String[]>(null);
        AtomicReference<Integer> selected = new AtomicReference<Integer>(0);

        logicsDispatcher.init(items, selected);

        graphicsDispatcher.triggerMainMenuRenderer(items.get(), selected.get());
    }

    /**
     * Method handling a new input from the user
     *
     * @param KEY_INPUT The key id of the users input
     * @return True if application is still running
     */
    public boolean dispatch(final int KEY_INPUT) {
        //Checking all the possible key events
        if (KEY_INPUT == KeyCode.ButtonESC.getValue()) {
            //Please close the application
            return false;

        }

        //Debug
        System.out.println("Test");

        return true;
    }

    /**
     * Method dispatching the main menu processes
     */
    public void dispatchMainMenu() {
        AtomicReference<String[]> items = new AtomicReference<String[]>(null);
        AtomicReference<Integer> selected = new AtomicReference<Integer>(0);

        logicsDispatcher.init(items, selected);

        graphicsDispatcher.triggerMainMenuRenderer(selected.get());
    }
}
