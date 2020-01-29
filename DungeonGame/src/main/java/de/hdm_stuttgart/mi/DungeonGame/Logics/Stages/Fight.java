/*
 * Fight.java
 *
 *
 *
 * author: Lara B.
 * last edit / by: 2020-01-22 / Lara B.
 */
package de.hdm_stuttgart.mi.DungeonGame.Logics.Stages;

//Import statements
import de.hdm_stuttgart.mi.DungeonGame.Logics.Actors.Actor;
import java.util.Random;
import java.util.Scanner;

/**
 * Fight class
 */
public class Fight {

    /**
     * Main fight method, continues until one Actor's health is below 0
     *
     * @param player
     * @param enemy
     */
    public static void startFight(Actor player, Actor enemy) {
        System.out.println("-- Fight start! --");
        System.out.println();

        //If the enemy is faster than the player, he will attack first
        if (player.GetSpeed() < enemy.GetSpeed()) {
            attack(enemy, player, false);
        }
        boolean defenseEnemy = false;

        //This loop will continue until either the player or the enemy has 0 health points
        boolean again = true;
        while(again) {

            //Player's turn
            boolean defensePlayer = false;

            boolean wrongInput = true;
            while (wrongInput) {  //The player chooses whether he wants to attack or defend
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter a number (0: attack, 1: defend, 2: view current fight stats): ");
                int playerChoice = scan.nextInt();

                switch (playerChoice) {
                    case 0:
                        attack(player, enemy, defenseEnemy);
                        wrongInput = false; break;
                    case 1:
                        defensePlayer = true;
                        wrongInput = false; break;
                    case 2:
                        wrongInput = false; break;
                    default:
                        System.out.println("Wrong Input! Try again."); break;
                }
            }

            //If the enemy has 0 health points, the player wins the fight
            if (enemy.GetHealthPoints() <= 0) {
                again = false;
                System.out.println("-- You won! --");
            }

            defenseEnemy = false;

            //Enemy's turn
            //A random number determines whether the enemy attacks or defends
            Random random = new Random();
            int enemyChoice = random.nextInt(2);

            switch (enemyChoice) {
                case 0:
                    attack(enemy, player, defensePlayer); break;
                case 1:
                    defenseEnemy = true;
                     break;
                default: break;
            }

            //If the player has 0 health points, the player loses the fight
            if (player.GetHealthPoints() <= 0) {
                again = false;
            }

        }
    }

    /**
     * Attack
     * One Actor (attacker) attacks another actor (attacker).
     *
     * @param attacker
     * @param attacked
     */
    private static void attack(Actor attacker, Actor attacked, boolean defending) {
        int attack = attacker.GetAttack();
        int defense = attacked.GetDefense();
        int health = attacked.GetHealthPoints();

        if (defending) {
            attack = (attack - (((defense * 2) / 100) * attack));
        } else {
            attack = (attack - ((defense / 100) * attack));
        }

        //attacked.SetHealth(health - attack);
    }

}
