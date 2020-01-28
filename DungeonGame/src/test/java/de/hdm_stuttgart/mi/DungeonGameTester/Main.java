/*
 * Main.java
 *
 * Main testing class for the whole project.
 *
 * author: Sascha W.
 * last edit / by: 2020-01-28 / Sascha W.
 */
package de.hdm_stuttgart.mi.DungeonGameTester;

//Import statements
import de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Stages.TestCreateWallAndFloor;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Main testing class for the whole project
 */
public class Main {
    /**
     * The main entry point for the tests.
     *
     * @param args Startup arguments provided at application startup
     */
    public static void main(String[] args) {
        System.out.println("Test CreateWallsAndFloors was executed.");
        Result result = JUnitCore.runClasses(TestCreateWallAndFloor.class);

        if (result.wasSuccessful()) {
            System.out.println("Test CreateWallsAndFloors was successful.");
        }else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }


}
