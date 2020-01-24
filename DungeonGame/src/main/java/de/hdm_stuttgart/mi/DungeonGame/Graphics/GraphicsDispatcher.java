/*
 * GraphicsDispatcher.java
 *
 * Main graphics class dispatching all graphic processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements

/**
 * Main graphics class dispatching all graphic processes
 */
public class GraphicsDispatcher {
    /**
     * Property storing an instance of the main menu renderer
     */
    private MainMenuRenderer mainMenuRenderer;

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
        //Creating new instance
        mainMenuRenderer = new MainMenuRenderer(items, selected);

        //Render the screen
        mainMenuRenderer.render();
    }

    /**
     * Method triggering the render process of the main menu
     *
     * @param selected The id of the selected menu item
     */
    public void triggerMainMenuRenderer(int selected) {
        //Set the current selection
        mainMenuRenderer.setSelection(selected);

        //Render the screen
        mainMenuRenderer.render();
    }
}
