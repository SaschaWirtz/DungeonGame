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
import de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Stages.TestFreeTiles;
import de.hdm_stuttgart.mi.DungeonGameTester.Helper.Logics.Stages.TestPutEntryAndExit;
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
        //TestCreateWallsAndFloors
        System.out.println("TestCreateWallsAndFloors was executed.");
        Result result = JUnitCore.runClasses(TestCreateWallAndFloor.class);

        if (result.wasSuccessful()) {
            System.out.println("TestCreateWallsAndFloors was successful.");
        }else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        //TestPutEntryAndExit
        System.out.println("TestPutEntryAndExit was executed.");
        Result result2 = JUnitCore.runClasses(TestPutEntryAndExit.class);

        if (result2.wasSuccessful()) {
            System.out.println("TestPutEntryAndExit was successful.");
        }else {
            for (Failure failure : result2.getFailures()) {
                System.out.println(failure.toString());
            }
        }
        //TestFreeTiles
        System.out.println("TestFreeTiles was executed.");
        Result result3 = JUnitCore.runClasses(TestFreeTiles.class);

        if (result3.wasSuccessful()) {
            System.out.println("TestFreeTiles was successful.");
        }else {
            for (Failure failure : result3.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }


}
