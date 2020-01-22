/*
 * Contributor.java
 *
 * Enum identifying all the development contributors
 *
 * author: Andreas G.
 * last edit / by: 2019-12-18 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics.Enums;

//Import statements


/**
 * Enum identifying all the development contributors
 */
public enum Contributor {
    //------ Enum elements ------//
    Andreas(0),
    Lara(1),
    Sascha(2),
    Micha(3),
    Moritz(4);
    //---------------------------//

    /**
     * ID identifying the specific contributor
     */
    int id;

    /**
     * Constructor for the contributor elements setting the ID
     *
     * @param id The ID for the current contributor
     */
    Contributor(int id) {
        this.id = id;
    }

    /**
     * Get the contributors ID
     *
     * @return The contributors ID
     */
    public int getId() {
        return id;
    }
}
