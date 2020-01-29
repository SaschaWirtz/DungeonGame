/*
 * LogicsDispatcher.java
 *
 * Main class dispatching all the logics processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-29 / Lara B.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.ApplicationState;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Enums.KeyCode;
import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Field;
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
     * The property storing the field instance
     */
    private Field field;

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

    /**
     * Method initializing field and handling the field logic processes
     *
     * @param mainDispatcher connects graphicsDispatcher and logicsDispatcher
     * @param room forwards the current room
     * @param inventory forwards the current inventory
     * @param player forwards the current player
     * @param KEY_INPUT works with user input
     */
    public void dispatchField(MainDispatcher mainDispatcher, AtomicReference<FieldType[][]> room, AtomicReference<Inventory> inventory, AtomicReference<Player> player, final int KEY_INPUT) {

        //creates instance if not initialized
        if (field == null) {
            field = new Field();

            room.set(field.getRoom().getRoom());
            inventory.set(field.getInventory());
            player.set(field.getPlayer());
        } else {

            if (KEY_INPUT == KeyCode.ButtonESC.getValue()) {
                //back to menu
                field = null;
                Field.resetField();
                Inventory.reset();
                mainDispatcher.setState(ApplicationState.MainMenu);
            } else if (KEY_INPUT == KeyCode.ButtonW.getValue()) {
                //move up
                field.getPlayer().MoveUp();
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.ButtonA.getValue()) {
                //move left
                field.getPlayer().MoveLeft();
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.ButtonS.getValue()) {
                //move down
                field.getPlayer().MoveDown();
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.ButtonD.getValue()) {
                //move right
                field.getPlayer().MoveRight();
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button1.getValue()) {
                //use item 1
                field.getInventory().usePotion(field.getInventory().getPotions()[0]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button2.getValue()) {
                //use item 2
                field.getInventory().usePotion(field.getInventory().getPotions()[1]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button3.getValue()) {
                //use item 3
                field.getInventory().usePotion(field.getInventory().getPotions()[2]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button4.getValue()) {
                //use item 4
                field.getInventory().usePotion(field.getInventory().getPotions()[3]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button5.getValue()) {
                //use item 5
                field.getInventory().usePotion(field.getInventory().getPotions()[4]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button6.getValue()) {
                //use item 6
                field.getInventory().usePotion(field.getInventory().getPotions()[5]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            } else if (KEY_INPUT == KeyCode.Button7.getValue()) {
                //use item 7
                field.getInventory().usePotion(field.getInventory().getPotions()[6]);
                field.getRoom().checkPlayerField();

                room.set(field.getRoom().getRoom());
                inventory.set(field.getInventory());
                player.set(field.getPlayer());
            }

            if (field.getPlayer().GetHealthPoints() <= 0) {
                //game over
                field = null;
                Field.resetField();
                Inventory.reset();
                mainDispatcher.setState(ApplicationState.GameOver);
            }
        }
    }
}
