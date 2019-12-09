/*
 * EasterEggRenderer.java
 *
 * A static class probably used for an in game easter egg.
 * Runnable only within Graphics package.
 *
 * author: Andreas G.
 * last edit / by: 2019-12-09 / Andreas G.
 */
package de.hdm_stuttgart.mi.DungeonGame.Graphics;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Helper.Graphics.Console;

/**
 * Static class used to render a in game EasterEgg screen.
 */
/*Only debug ->*/public/*<- Omly debug*/ class EasterEggRenderer {
    /**
     * A static const string visualising Andreas G. as graffity
      */
    private static final String ASCII_ANDREAS = "   _____              .___                                    ________ \n" +
                                               "  /  _  \\   ____    __| _/______   ____ _____    ______      /  _____/ \n" +
                                               " /  /_\\  \\ /    \\  / __ |\\_  __ \\_/ __ \\\\__  \\  /  ___/     /   \\  ___ \n" +
                                               "/    |    \\   |  \\/ /_/ | |  | \\/\\  ___/ / __ \\_\\___ \\      \\    \\_\\  \\\n" +
                                               "\\____|__  /___|  /\\____ | |__|    \\___  >____  /____  > /\\   \\______  /\n" +
                                               "        \\/     \\/      \\/             \\/     \\/     \\/  \\/          \\/ ";

    /**
     * A static const string visualising Lara B. as graffity
      */
    private static final String ASCII_LARA = ".____                          __________     \n" +
                                            "|    |   _____ ____________    \\______   \\    \n" +
                                            "|    |   \\__  \\\\_  __ \\__  \\    |    |  _/    \n" +
                                            "|    |___ / __ \\|  | \\// __ \\_  |    |   \\    \n" +
                                            "|_______ (____  /__|  (____  /  |______  / /\\ \n" +
                                            "        \\/    \\/           \\/          \\/  \\/ ";

    /**
     * A static const string visualising Sascha W. as graffity
     */
    private static final String ASCII_SASCHA = "  _________                    .__              __      __   \n" +
                                               " /   _____/____    ______ ____ |  |__ _____    /  \\    /  \\  \n" +
                                               " \\_____  \\\\__  \\  /  ___// ___\\|  |  \\\\__  \\   \\   \\/\\/   /  \n" +
                                               " /        \\/ __ \\_\\___ \\\\  \\___|   Y  \\/ __ \\_  \\        /   \n" +
                                               "/_______  (____  /____  >\\___  >___|  (____  /   \\__/\\  / /\\ \n" +
                                               "        \\/     \\/     \\/     \\/     \\/     \\/         \\/  \\/ ";

    /**
     * A static const string visualising Micha H. as graffity
     */
    private static final String ASCII_MICHA = "   _____  .__       .__               ___ ___     \n" +
                                              "  /     \\ |__| ____ |  |__ _____     /   |   \\    \n" +
                                              " /  \\ /  \\|  |/ ___\\|  |  \\\\__  \\   /    ~    \\   \n" +
                                              "/    Y    \\  \\  \\___|   Y  \\/ __ \\_ \\    Y    /   \n" +
                                              "\\____|__  /__|\\___  >___|  (____  /  \\___|_  / /\\ \n" +
                                              "        \\/        \\/     \\/     \\/         \\/  \\/ ";

    /**
     * A static const string visualising Moritz W. as graffity
     */
    private static final String ASCII_MORITZ = "   _____               .__  __            __      __   \n" +
                                               "  /     \\   ___________|__|/  |_________ /  \\    /  \\  \n" +
                                               " /  \\ /  \\ /  _ \\_  __ \\  \\   __\\___   / \\   \\/\\/   /  \n" +
                                               "/    Y    (  <_> )  | \\/  ||  |  /    /   \\        /   \n" +
                                               "\\____|__  /\\____/|__|  |__||__| /_____ \\   \\__/\\  / /\\ \n" +
                                               "        \\/                            \\/        \\/  \\/ ";

    /**
     * Method clearing the screen and printing the EasterEgg
     */
//    public static void renderEasterEgg() {
//        String bufferGraffity[] = ASCII_ANDREAS.split("\n");
//
//        for (int i = 0; i < bufferGraffity.length; i++) {
//            System.out.println(bufferGraffity[i]);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e) {
//                //Do nothing
//            }
//        }
//
//        for (int i = 0; i < bufferGraffity.length; i++) {
//            bufferGraffityCharArray[i] = bufferGraffity[i].toCharArray();
//        }
//
//        char bufferGraffityCharArray[][] = new char[bufferGraffity.length][];
//        int horizontalLength = 0;
//
//        for (int i = 0; i < bufferGraffity.length; i++) {
//            bufferGraffityCharArray[i] = bufferGraffity[i].toCharArray();
//        }
//    }
}
