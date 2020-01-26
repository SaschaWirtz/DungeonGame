/*
 * MainDispatcher.java
 *
 * Main dispatcher controlling and triggering the rendering processes and logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-25 / Andreas G.
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

        //Initially handle the main menu
        dispatchMainMenu(-1);
    }

    /**
     * Method handling a new input from the user
     *
     * @param KEY_INPUT The key id of the users input
     * @return True if application is still running
     */
    public boolean dispatch(final int KEY_INPUT) {
        //Checking the terminate key event
        if (KEY_INPUT == KeyCode.ButtonESC.getValue()) {
            if (state == ApplicationState.Field || state == ApplicationState.Fight) {
                //Go back to main menu
                //Changing the current state to main menu
                state = ApplicationState.MainMenu;

                //Initially handle the main menu
                dispatchMainMenu(-1);

                return true;
            } else {
                //Please close the application
                return false;
            }
        } else {
            //Trigger the correct dispatch process
            if (state == ApplicationState.MainMenu) {
                dispatchMainMenu(KEY_INPUT);
            }

            //Check if state has changed to PendingExit after dispatching
            if (state == ApplicationState.PendingExit) {
                //Please close the application
                return false;
            }

            //Please continue application execution
            return true;
        }
    }

    /**
     * Method dispatching the main menu processes
     */
    public void dispatchMainMenu(final int KEY_INPUT) {
        //Get reference types for logics dispatcher
        AtomicReference<String[]> items = new AtomicReference<String[]>(null);
        AtomicReference<Integer> selected = new AtomicReference<Integer>(0);

        //Handling the logic of main menu
        logicsDispatcher.dispatchMainMenu(this, items, selected, KEY_INPUT);

        if (state == ApplicationState.EasterEgg) {
            //Render the easter egg
            graphicsDispatcher.triggerEasterEggRenderer();

            //Chance state back to main menu
            state = ApplicationState.MainMenu;

            //Printing the graphics of main menu
            graphicsDispatcher.triggerMainMenuRenderer(items.get(), selected.get());
        } else if (state == ApplicationState.MainMenu) {
            //Printing the graphics of main menu
            graphicsDispatcher.triggerMainMenuRenderer(items.get(), selected.get());
        }
    }

    /**
     * Change the current application state
     *
     * @param state The new state of the application
     */
    public void setState(final ApplicationState state) {
        this.state = state;
    }
}
