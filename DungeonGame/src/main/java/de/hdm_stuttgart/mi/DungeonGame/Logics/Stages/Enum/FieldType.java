/*
 * FieldTypes.java
 *
 * List of all possible FieldTypes.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-13 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum;

/**
 * List of usable FieldTypes (Wall, Water, ...)
 */
public enum FieldType {
    /**
     * Player is a FieldType which symbols the Player object
     */
    Player(true, '°'),

    /**
     * Enemy is a FieldType which symbols a Enemy object
     */
    Enemy(true, '§'),

    /**
     * Wall is a FiledType which shapes the basic shape of the Field and creates simple walls to interfere with the players path
     */
    Wall(false, '#'),

    /**
     * Floor is a FieldType on which the player is able to move to reach his goal
     */
    Floor(true, ' '),

    /**
     * Water is a FieldType which creates another interference for the player
     * Only used in prebuild Fields.
     */
    Water(false, '~'),

    /**
     * ExitDoor is a FieldType which is accessible and can lead to a Field change
     */
    Door(true, '/'),

    /**
     * Stairs are a FieldType which are accessible and can lead to a Field change
     */
    Stairs(true, '='),

    /**
     * On this tile sits an usable item
     */
    ItemField(true, '?');

    /**
     * Adding a boolean to check the FieldTypes accessibility
     */
    private final boolean walkable;

    /**
     * Adding a char for rendering
     */
    private final char visual;

    /**
     * Constructor to add a parameter
     *
     * @param walkable setting if its possible to walk on this particular FieldType
     */
    private FieldType(boolean walkable, char visual) {
        this.walkable = walkable;
        this.visual = visual;
    }

    /**
     * Getter to ask if the tile is walkable
     *
     * @return if the Player is able to walk on it
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * Getter to ask for the fitting char of specific tile
     *
     * @return the char for rendering
     */
    public char getVisual() {
        return visual;
    }
}
