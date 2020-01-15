/*
 * CreateWallAndFloor.java
 *
 * Fill Room-array with simple wall and room.
 *
 * author: Sascha W.
 * last edit / by: 2019-12-17 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGame.Helper.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Logics.Stages.Enum.FieldType;

public class CreateWallAndFloor {
    /**
     * Constructor to add entry and exit.
     *
     * @param room reference to room-array from Field.java.
     */
    public CreateWallAndFloor(FieldType[][] room) {

        //Fill room with Floor
        for(int hight = 0; hight < (room.length - 1); hight++) {
            for(int width = 1; width < (room[0].length - 1); width++) {
                room[hight][width] = FieldType.Floor;
            }
        }

        //Place top wall
        for(int width = 1; width < room[0].length; width++) {
            room[0][width] = FieldType.Wall;
        }

        //Place left wall
        for(int higth = 1; higth < room.length - 1; higth++) {
            room[higth][room[0].length - 1] = FieldType.Wall;
        }

        //Place bottom wall
        for(int hight = 0; hight < room.length - 1; hight++) {
            room[hight][0] = FieldType.Wall;
        }

        //Place right wall
        for(int width = 0; width < room[0].length; width++) {
            room[room.length - 1][width] = FieldType.Wall;
        }
    }
}
