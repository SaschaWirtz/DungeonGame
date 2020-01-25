/*
 * GraphicsDispatcher.java
 *
 * Main graphics class dispatching all graphic processes
 *
 * author: Andreas G.
 * last edit / by: 2020-01-25 / Andreas G.
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
     * Property storing an instance of the easter egg renderer
     */
    private EasterEggRenderer easterEggRenderer;

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
}
