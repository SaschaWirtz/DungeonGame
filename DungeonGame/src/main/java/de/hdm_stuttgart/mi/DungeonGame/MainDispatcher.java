/*
 * MainDispatcher.java
 *
 * Main dispatcher controlling and triggering the rendering processes and logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-29 / Lara B.
 */
package de.hdm_stuttgart.mi.DungeonGame;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.GraphicsDispatcher;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.ApplicationState;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.KeyCode;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.LogicsDispatcher;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

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
            if (state == ApplicationState.MainMenu) {
                //Please close the application
                return false;
            } else {
                //state related dispatching process start
                if (state == ApplicationState.Field) {
                    dispatchField(KEY_INPUT);
                } else if (state == ApplicationState.Fight) {
                    //TODO: for future implementations of fight
                }
                return true;
            }
        } else {
            //Trigger the correct dispatch process
            if (state == ApplicationState.MainMenu) {
                dispatchMainMenu(KEY_INPUT);
            } else if (state == ApplicationState.Field) {
                dispatchField(KEY_INPUT);
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
     *
     * @param KEY_INPUT current user input
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
        } else if (state == ApplicationState.Field) {
            //Dispatch initial field
            this.dispatchField(-1);
        }
    }

    /**
     * Method dispatching the field processes
     *
     * @param KEY_INPUT current user input
     */
    public void dispatchField(final int KEY_INPUT) {
        //Get reference types for logics dispatcher
        AtomicReference<FieldType[][]> room = new AtomicReference<FieldType[][]>(null);
        AtomicReference<Inventory> inventory = new AtomicReference<Inventory>(null);
        AtomicReference<Player> player = new AtomicReference<Player>(null);

        //Handling the logic of field
        logicsDispatcher.dispatchField(this, room, inventory, player, KEY_INPUT);

        if (state == ApplicationState.Field) {
            //Render the field
            graphicsDispatcher.triggerFieldRenderer(room.get(), inventory.get(), player.get());

        } else if (state == ApplicationState.MainMenu) {
            //Printing the graphics of main menu
            this.dispatchMainMenu(-1);
        } else if (state == ApplicationState.GameOver) {
            //graphics of game over
            graphicsDispatcher.triggerGameOverRenderer();
            //set to main menu
            state = ApplicationState.MainMenu;
            //Printing the graphics of main menu
            this.dispatchMainMenu(-1);
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
