/*
 * GraphicsDispatcher.java
 *
 * Main graphics class dispatching all graphic processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-29 / Lara B.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements

import de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Inventory;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Player;
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

/**
 * Main graphics class dispatching all graphic processes
 */
public class GraphicsDispatcher {
    /**
     * Property storing an instance of the main menu renderer
     */
    private MainMenuRenderer mainMenuRenderer;

    /**
     * Property storing an instance of the field renderer
     */
    private FieldRenderer fieldRenderer;

    /**
     * Property storing an instance of the easter egg renderer
     */
    private EasterEggRenderer easterEggRenderer;

    /**
     * Property storing an instance of the game over renderer
     */
    private GameOverRenderer gameOverRenderer;
    /**
     * Constructor for the graphics dispatcher
     */
    public GraphicsDispatcher() {}

    /**
     * Method triggering the render process of the main menu
     *
     * @param items The menu items names to be printed
     * @param selected The id of the selected menu item
     */
    public void triggerMainMenuRenderer(String[] items, int selected) {
        if (mainMenuRenderer == null) {
            //Creating new instance
            mainMenuRenderer = new MainMenuRenderer(items, selected);
        } else {
            //Changing selection
            mainMenuRenderer.setSelection(selected);
        }

        //Render the screen
        mainMenuRenderer.render();
    }

    /**
     * Method triggering the render process of the field
     *
     * @param room The room to be printed
     * @param inventory The inventory to be printed
     * @param player The player to be printed
     */
    public void triggerFieldRenderer(FieldType[][] room, Inventory inventory, Player player) {
        if (fieldRenderer == null) {
            //Creating new instance
            fieldRenderer = new FieldRenderer();
        }
        //setting information
        fieldRenderer.setRenderer(room, inventory, player);

        //render the screen
        fieldRenderer.render();
    }

    /**
     * Method triggering the render process of the easter egg
     */
    public void triggerEasterEggRenderer() {
        //Creating new instance if required
        if (easterEggRenderer == null) {
            easterEggRenderer = new EasterEggRenderer();
        }

        //Render the screen
        easterEggRenderer.render();
    }

    /**
     * Method triggering the render process of the game over screen
     */
    public void triggerGameOverRenderer() {
        //Creating new instance if required
        if (gameOverRenderer == null) {
            gameOverRenderer = new GameOverRenderer();
        }

        //Render the screen
        gameOverRenderer.render();
    }
}
