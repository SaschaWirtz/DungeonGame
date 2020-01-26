/*
 * PotionType.java
 *
 * Enum for types of potions
 *
 * author: Micha H.
 * last edit / by: 2020-01.26 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Actors.Enums;

//Import statements
// ...

public enum PotionType {

    HEALTH("Health"),
    ATTACK("Attack"),
    DEFENSE("Defense"),
    SPEED("Speed");

    private final String CHARACTER;

    PotionType(final String CHARACTER) {
        this.CHARACTER = CHARACTER;
    }

    public String getCHARACTER() {
        return CHARACTER;
    }
}
