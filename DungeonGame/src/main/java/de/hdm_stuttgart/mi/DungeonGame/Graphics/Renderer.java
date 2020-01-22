/*
 * Renderer.java
 *
 * Abstract class providing variables and methods for all the
 * more specific Renderer classes.
 *
 * author: Andreas G.
 * last edit / by: 2019-12-18 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements


/**
 * Abstract Renderer superclass providing variables and methods
 */
abstract class Renderer {
    /**
     * Placeholder for the screenBuffer within the specific Renderer
     */
    protected char[][] screenBuffer = null;

    /**
     * Placeholder for the screenBuffers height within specific Renderer
     */
    protected int bufferHeight = 0;

    /**
     * Placeholder for the screenBuffers width within specific Renderer
     */
    protected int bufferWidth = 0;
}
