/*
 * GameOverRenderer.java
 *
 * A class rendering the GameOver screen.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-28 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces.IRenderable;

/**
 * A class rendering the GameOver screen.
 */
public class GameOverRenderer extends Renderer implements IRenderable {
    /**
     * A const string visualising Game over as graffity
      */
    private final String ASCII_GameOver = "  ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
                                          " ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
                                          "▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
                                          "░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
                                          "░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
                                          " ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
                                          "  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
                                          "░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
                                          "      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
                                          "                                                     ░                   ";

    /**
     * A char array visualising the Game over graffity
     */
    private char[][] asciiChars;

    /**
     * Method rendering the GameOver screen and printing it to screen
     */
    @Override
    public void render() {
        //Slide in the Game over graffity from left
        slideInVisual(asciiChars, true);

        //Wait for 3 seconds
        this.sleep(3000);
    }

    /**
     * Just let the visual appear on screen
     *
     * @param visualCharBuffer The visual to be appearing as char array
     */
    private void appearVisual(char[][] visualCharBuffer) {
        //Buffering the current screen size
        this.bufferHeight = Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();

        //Creating a new buffer array
        this.screenBuffer = this.getNewEmptyScreenBuffer(this.bufferHeight, this.bufferWidth);

        if (screenBuffer[0].length >= visualCharBuffer[0].length && screenBuffer.length >= visualCharBuffer.length) {
            //Calculating the begin index for centering the name within the screen buffer
            int beginIndexHorizontal = ((this.screenBuffer[0].length-1)/2)-((visualCharBuffer[0].length-1)/2);
            int beginIndexVertical = ((this.screenBuffer.length-1)/2)-((visualCharBuffer.length-1)/2);

            //Positioning the name in the middle of the screen buffer
            for (int i = beginIndexVertical; i < visualCharBuffer.length + beginIndexVertical; i++) {
                for (int z = beginIndexHorizontal; z < visualCharBuffer[i-beginIndexVertical].length + beginIndexHorizontal; z++) {
                    this.screenBuffer[i][z] = visualCharBuffer[i-beginIndexVertical][z-beginIndexHorizontal];
                }
            }
        } else {
            //ToDo: Printing if screen is too small.
        }

        //Printing the result to the screen
        this.printScreen();
    }

    /**
     * Slide in the visual provided as char array graffity
     *
     * @param visualCharBuffer The visual as char array graffity
     */
    private void slideInVisual(char[][] visualCharBuffer, final boolean LEFT) {
        //Buffering the current screen size
        this.bufferHeight = Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();

        //Creating a new buffer array
        this.screenBuffer = this.getNewEmptyScreenBuffer(this.bufferHeight, this.bufferWidth);

        //Set if animation starts left or right
        if (LEFT) {
            final int ANIMATION_START = -visualCharBuffer[0].length;

            for (int x = ANIMATION_START; x <= ((this.screenBuffer[0].length-1)/2)-((visualCharBuffer[0].length-1)/2); x++) {
                //Creating a new buffer array
                this.screenBuffer = this.getNewEmptyScreenBuffer(this.bufferHeight, this.bufferWidth);

                if (screenBuffer[0].length >= visualCharBuffer[0].length && screenBuffer.length >= visualCharBuffer.length) {
                    //Calculating the begin index for centering the name within the screen buffer
                    int beginIndexHorizontal = x;
                    int beginIndexVertical = ((this.screenBuffer.length-1)/2)-((visualCharBuffer.length-1)/2);

                    //Positioning the name in the middle of the screen buffer
                    for (int i = beginIndexVertical; i < visualCharBuffer.length + beginIndexVertical; i++) {
                        for (int z = beginIndexHorizontal; z < visualCharBuffer[i-beginIndexVertical].length + beginIndexHorizontal; z++) {
                            if (z >= 0 && z-beginIndexHorizontal >= 0) {
                                this.screenBuffer[i][z] = visualCharBuffer[i-beginIndexVertical][z-beginIndexHorizontal];
                            }
                        }
                    }
                } else {
                    //ToDo: Printing if screen is too small.
                }

                //Printing the result to the screen
                this.printScreen();

                //Sleep for short time
                this.sleep(1000/30);
            }
        } else {
            final int ANIMATION_START = screenBuffer[0].length;

            for (int x = ANIMATION_START; x >= ((this.screenBuffer[0].length-1)/2)-((visualCharBuffer[0].length-1)/2); x--) {
                //Creating a new buffer array
                this.screenBuffer = this.getNewEmptyScreenBuffer(this.bufferHeight, this.bufferWidth);

                if (screenBuffer[0].length >= visualCharBuffer[0].length && screenBuffer.length >= visualCharBuffer.length) {
                    //Calculating the begin index for centering the name within the screen buffer
                    int beginIndexHorizontal = x;
                    int beginIndexVertical = ((this.screenBuffer.length-1)/2)-((visualCharBuffer.length-1)/2);

                    //Positioning the name in the middle of the screen buffer
                    for (int i = beginIndexVertical; i < visualCharBuffer.length + beginIndexVertical; i++) {
                        for (int z = beginIndexHorizontal; z < visualCharBuffer[i-beginIndexVertical].length + beginIndexHorizontal; z++) {
                            if (z < screenBuffer[i].length && z-beginIndexHorizontal < screenBuffer[i].length) {
                                this.screenBuffer[i][z] = visualCharBuffer[i-beginIndexVertical][z-beginIndexHorizontal];
                            }
                        }
                    }
                } else {
                    //ToDo: Printing if screen is too small.
                }

                //Printing the result to the screen
                this.printScreen();

                //Sleep for short time
                this.sleep(1000/30);
            }
        }
    }

    /**
     * Constructor preparing the graffity char array
     */
    public GameOverRenderer() {
        prepareValidGraffityCharArray();
    }

    /**
     * Preparing the char array containing the GameOver visual
     */
    private void prepareValidGraffityCharArray() {
        //Char array buffering the result of the conversion
        char[][] resultBuffer;

        //Filling the result buffer with the char array
        resultBuffer = createValidGraffityCharArray(ASCII_GameOver);

        //Storing the result into the instance variable
        asciiChars = resultBuffer;
    }

    /**
     * Creating a char array for that graffity with a valid width
     *
     * @param sourceGraffity The graffity string to be converted
     * @return The valid char array
     */
    private char[][] createValidGraffityCharArray(String sourceGraffity) {
        //Helper variables
        char[][] resultGraffity;
        String[] linesBuffer = sourceGraffity.split("\\r?\\n");
        int widthBuffer = 0;

        //Analyzing the fitting width
        for (String line: linesBuffer) {
            widthBuffer = Math.max(line.toCharArray().length, widthBuffer);
        }

        //Preparing the resultBuffer with setting bounds
        resultGraffity = new char[linesBuffer.length][widthBuffer];

        //Filling the resultBuffer
        for (int i = 0; i < linesBuffer.length; i++) {
            char[] lineCharBuffer = linesBuffer[i].toCharArray();

            for (int z = 0; z < resultGraffity[i].length; z++) {
                if (z < lineCharBuffer.length) {
                    resultGraffity[i][z] = lineCharBuffer[z];
                } else {
                    resultGraffity[i][z] = ' ';
                }
            }
        }

        //Return the result
        return resultGraffity;
    }
}
