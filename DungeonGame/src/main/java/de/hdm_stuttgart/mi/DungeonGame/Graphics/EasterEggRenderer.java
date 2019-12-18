/*
 * EasterEggRenderer.java
 *
 * A class probably used for an in game easter egg.
 * Runnable only within Graphics package.
 *
 * author: Andreas G.
 * last edit / by: 2019-12-18 / Andreas G.
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
//        //Buffering the current screen size
//        this.bufferHeight = Screen.getScreenHeight();
//        this.bufferWidth = Screen.getScreenWidth();
//
//        //Creating a new buffer array
//        this.screenBuffer = new char[bufferHeight][bufferWidth];
//
//        //Do the slide animation
//        //slideInName(asciiChars[Contributor.Andreas.getId()]);
//
//        //Just appear the name
//        appearName(asciiChars[Contributor.Andreas.getId()]);
//
//        //Wait for 3 seconds with disappearing
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            //ToDo: A secure and senseful catching routine
//        }
    }

    /**
     * Animating an slideIn animation for the provided Name
     *
     * @param nameCharBuffer The name to be animated as char array
     */
//    private void slideInName(char[][] nameCharBuffer) {
//        //Defining the edges where graffitys first line and last line is located
//        int endTop = ((screenBuffer.length - nameCharBuffer.length) / 2) - 1;
//        int beginBottom = screenBuffer.length - 1 - endTop;
//
//
//        for(int i = beginBottom; i >= 0; i--) {
//
//        }
//
//        printScreen();
//    }

    /**
     * Just let the name appear on screen
     *
     * @param nameCharBuffer The name to be appearing as char array
     */
//    private void appearName(char[][] nameCharBuffer) {
//
//    }

    /**
     * Printing the current Renderer screenBuffer with Screen class on screen
     */
    private void printScreen() {
        //Provide the screenBuffer to Screen instance
        Screen.getInstance().setScreenBuffer(this.screenBuffer);

        //Let screen print the current buffer
        Screen.getInstance().printScreen();
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
        String[] linesBuffer = sourceGraffity.split("$");
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
            int beginPoint = ((resultGraffity[i].length - lineCharBuffer.length) / 2);


            for (int z = beginPoint; (z - beginPoint) < lineCharBuffer.length; z++) {
                resultGraffity[i][z] = lineCharBuffer[z - beginPoint];
            }
        }

        //Return the result
        return resultGraffity;
    }
}
