/*
 * IRenderable.java
 *
 * A interface making a Renderer class renderable for
 * other classes.
 *
 * author: Andreas G.
 * last edit / by: 2019-12-18 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces;

//Import statements


/**
 * Interface defining required methods to be implemented by Renderer classes.
 */
public interface IRenderable {
    /**
     * Force every Renderer to implement the rendering method creating the screen visuals and
     * writing it to the screen buffer.
     */
    void render();
}
