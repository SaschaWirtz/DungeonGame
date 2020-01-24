/*
 * MainMenu.java
 *
 * Class storing the current state and logic behind the main game menu.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics;

//Import statements

/**
 * Class storing the current state and logic behind the main game menu.
 */
public class MainMenu {
    /**
     * Variable containing the current state if the EasterEgg should be triggered or not.
     */
    private boolean easterEggActive = false;

    /**
     * Variable containing the current state if the game should be triggered or not.
     */
    private boolean gameActive = false;

    /**
     * Variable containing the current state if the application should be closed or not.
     */
    private boolean shutdownActive = false;

    /**
     * Counter checking if easter egg should be shown
     */
    private int easterEggCounter = 0;

    /**
     * Variable storing the currently selected menu item
     */
    private int selected = 0;

    /**
     * Contains all the titles of the menu items
     */
    private final String[] ITEMS = {"START", "EXIT"};

    /**
     * Constructor creating a new MainMenu
     */
    public MainMenu() {

    }

    /**
     * Constructor creating new MainMenu with preselected menu item
     *
     * @param SELECTION The item id to select
     */
    public MainMenu(final int SELECTION) {
        this.selected = SELECTION;
    }

    /**
     * Moving the selection cursor one item up
     */
    public void selectionMoveUp() {
        if (this.selected > 0) {
            this.selected--;
        } else {
            if (this.easterEggCounter == 10) {
                //Triggering the EasterEgg start
                this.easterEggActive = true;
                this.easterEggCounter = 0;
            } else {
                //Increasing the easter egg counter
                this.easterEggCounter++;
            }
        }
    }

    /**
     * Moving the selection cursor one item down
     */
    public void selectionMoveDown() {
        //Resetting the easter egg counter
        this.easterEggCounter = 0;

        if (this.selected < this.ITEMS.length - 1) {
            this.selected++;
        }
    }

    /**
     * Method triggering the event of the current item
     */
    public void select() {
        //Triggering the correct state
        switch (this.selected) {
            case 0:
                this.gameActive = true;
                break;
            case 1:
                this.shutdownActive = true;
                break;
            default:
                break;
        }
    }

    /**
     * Get the current state of easter egg trigger
     *
     * @return If easter egg should be triggered or not
     */
    public boolean getEasterEggState() {
        return this.easterEggActive;
    }

    /**
     * Get the current state of game start trigger
     *
     * @return If game should be started or not
     */
    public boolean getStartGameState() {
        return this.gameActive;
    }

    /**
     * Get the current state of shutdown trigger
     *
     * @return If application should be shutdown or not
     */
    public boolean getShutdownState() {
        return this.shutdownActive;
    }

    /**
     * Get the id of the currently selected item
     *
     * @return The id of the selected item
     */
    public int getCurrentSelection() {
       return this.selected;
    }

    /**
     * Get all the menu items present in this main menu
     *
     * @return A array with all menu title strings
     */
    public String[] getMenuItems() {
        return this.ITEMS;
    }

    /**
     * Resetting the state variables because the event has been triggered
     */
    public void resetState() {
        this.gameActive = false;
        this.easterEggActive = false;
        this.shutdownActive = false;
    }
}
