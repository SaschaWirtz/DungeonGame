/*
 * KeyCode.java
 *
 * Enum containing all the relevant key codes for this application
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Enums;

//Import statements

/**
 * The enum with all the keys and it's int values
 */
public enum KeyCode {
    ButtonW(119),
    ButtonD(100),
    ButtonA(97),
    ButtonS(115),

    ButtonESC(27),
    ButtonENTER(13),

    Button1(49),
    Button2(50),
    Button3(51),
    Button4(52),
    Button5(53),
    Button6(54),
    Button7(55);

    /**
     * The int value for the specific key
     */
    int value;

    /**
     * The constructor for the enum elements
     *
     * @param value The int value for the specific key
     */
    KeyCode(int value) {
        this.value = value;
    }

    /**
     * Get the int value of the specific key
     *
     * @return The int value of the specific key
     */
    public int getValue() {
        return value;
    }
}
