/*
 * EasterEggRenderer.java
 *
 * A class probably used for an in game easter egg.
 * Runnable only within Graphics package.
 *
 * author: Andreas G.
 * last edit / by: 2020-01-24 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Enums.Contributor;
import de.hdm_stuttgart.mi.DungeonGame.Graphics.Interfaces.IRenderable;

/**
 * Static class used to render a in game EasterEgg screen.
 */
class EasterEggRenderer extends Renderer implements IRenderable {
    /**
     * A const string visualising Andreas G. as graffity
      */
    private final String ASCII_ANDREAS = "   _____              .___                                    ________ \n" +
                                         "  /  _  \\   ____    __| _/______   ____ _____    ______      /  _____/ \n" +
                                         " /  /_\\  \\ /    \\  / __ |\\_  __ \\_/ __ \\\\__  \\  /  ___/     /   \\  ___ \n" +
                                         "/    |    \\   |  \\/ /_/ | |  | \\/\\  ___/ / __ \\_\\___ \\      \\    \\_\\  \\\n" +
                                         "\\____|__  /___|  /\\____ | |__|    \\___  >____  /____  > /\\   \\______  /\n" +
                                         "        \\/     \\/      \\/             \\/     \\/     \\/  \\/          \\/ ";

    /**
     * A const string visualising Lara B. as graffity
      */
    private final String ASCII_LARA = ".____                          __________     \n" +
                                      "|    |   _____ ____________    \\______   \\    \n" +
                                      "|    |   \\__  \\\\_  __ \\__  \\    |    |  _/    \n" +
                                      "|    |___ / __ \\|  | \\// __ \\_  |    |   \\    \n" +
                                      "|_______ (____  /__|  (____  /  |______  / /\\ \n" +
                                      "        \\/    \\/           \\/          \\/  \\/ ";

    /**
     * A const string visualising Sascha W. as graffity
     */
    private final String ASCII_SASCHA = "  _________                    .__              __      __   \n" +
                                        " /   _____/____    ______ ____ |  |__ _____    /  \\    /  \\  \n" +
                                        " \\_____  \\\\__  \\  /  ___// ___\\|  |  \\\\__  \\   \\   \\/\\/   /  \n" +
                                        " /        \\/ __ \\_\\___ \\\\  \\___|   Y  \\/ __ \\_  \\        /   \n" +
                                        "/_______  (____  /____  >\\___  >___|  (____  /   \\__/\\  / /\\ \n" +
                                        "        \\/     \\/     \\/     \\/     \\/     \\/         \\/  \\/ ";

    /**
     * A const string visualising Micha H. as graffity
     */
    private final String ASCII_MICHA = "   _____  .__       .__               ___ ___     \n" +
                                       "  /     \\ |__| ____ |  |__ _____     /   |   \\    \n" +
                                       " /  \\ /  \\|  |/ ___\\|  |  \\\\__  \\   /    ~    \\   \n" +
                                       "/    Y    \\  \\  \\___|   Y  \\/ __ \\_ \\    Y    /   \n" +
                                       "\\____|__  /__|\\___  >___|  (____  /  \\___|_  / /\\ \n" +
                                       "        \\/        \\/     \\/     \\/         \\/  \\/ ";

    /**
     * A const string visualising Moritz W. as graffity
     */
    private final String ASCII_MORITZ = "   _____               .__  __            __      __   \n" +
                                        "  /     \\   ___________|__|/  |_________ /  \\    /  \\  \n" +
                                        " /  \\ /  \\ /  _ \\_  __ \\  \\   __\\___   / \\   \\/\\/   /  \n" +
                                        "/    Y    (  <_> )  | \\/  ||  |  /    /   \\        /   \n" +
                                        "\\____|__  /\\____/|__|  |__||__| /_____ \\   \\__/\\  / /\\ \n" +
                                        "        \\/                            \\/        \\/  \\/ ";

    /**
     * A char array visualising all names as graffity.
     * The char array has a senseful width. 3th dimension is for
     * differing the contributors.
     *
     * [Contributors.]
     */
    private char[][][] asciiChars;

    /**
     * Method rendering the EasterEgg and printing it to screen
     */
    @Override
    public void render() {
        //Let all the contributors appear
        for (Contributor contributor:Contributor.values()) {
            //Just appear the name
            appearName(asciiChars[contributor.getId()]);

            //Wait for 3 seconds
            this.sleep(3000);
        }
    }

    /**
     * Just let the name appear on screen
     *
     * @param nameCharBuffer The name to be appearing as char array
     */
    private void appearName(char[][] nameCharBuffer) {
        //Buffering the current screen size
        this.bufferHeight = Screen.getInstance().getScreenBufferHeight();
        this.bufferWidth = Screen.getInstance().getScreenBufferWidth();

        //Creating a new buffer array
        this.screenBuffer = this.getNewEmptyScreenBuffer(this.bufferHeight, this.bufferWidth);

        if (screenBuffer[0].length >= nameCharBuffer[0].length && screenBuffer.length >= nameCharBuffer.length) {
            //Calculating the begin index for centering the name within the screen buffer
            int beginIndexHorizontal = ((this.screenBuffer[0].length-1)/2)-((nameCharBuffer[0].length-1)/2);
            int beginIndexVertical = ((this.screenBuffer.length-1)/2)-((nameCharBuffer.length-1)/2);

            //Positioning the name in the middle of the screen buffer
            for (int i = beginIndexVertical; i < nameCharBuffer.length + beginIndexVertical; i++) {
                for (int z = beginIndexHorizontal; z < nameCharBuffer[i-beginIndexVertical].length + beginIndexHorizontal; z++) {
                    this.screenBuffer[i][z] = nameCharBuffer[i-beginIndexVertical][z-beginIndexHorizontal];
                }
            }
        } else {
            //ToDo: Printing if screen is too small.
        }

        //Printing the result to the screen
        this.printScreen();
    }

    /**
     * Constructor preparing the graffity char arrays
     */
    public EasterEggRenderer() {
        prepareValidGraffityCharArrays();
    }

    /**
     * Preparing the char array containing all char arrays for the
     * contributors graffities.
     */
    private void prepareValidGraffityCharArrays() {
        //Char array buffering the result of all the conversions
        char[][][] resultBuffer = new char[Contributor.values().length][][];

        //Filling the result buffer with the char arrays
        resultBuffer[Contributor.Andreas.getId()] = createValidGraffityCharArray(ASCII_ANDREAS);
        resultBuffer[Contributor.Lara.getId()] = createValidGraffityCharArray(ASCII_LARA);
        resultBuffer[Contributor.Sascha.getId()] = createValidGraffityCharArray(ASCII_SASCHA);
        resultBuffer[Contributor.Micha.getId()] = createValidGraffityCharArray(ASCII_MICHA);
        resultBuffer[Contributor.Moritz.getId()] = createValidGraffityCharArray(ASCII_MORITZ);

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
