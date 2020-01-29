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
        if (player.getSpeed() < enemy.getSpeed()) {
            System.out.println(enemy.getName() + " is faster than " + player.getName() + "!");
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
                        System.out.println(player.getName() + " defends himself.");
                        wrongInput = false; break;
                    case 2:
                        printFightStats(player, enemy);
                        wrongInput = false; break;
                    default:
                        System.out.println("Wrong Input! Try again."); break;
                }
            }

            //If the enemy has 0 health points, the player wins the fight
            if (enemy.getHealth() <= 0) {
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
                    System.out.println(enemy.getName() + " defends himself."); break;
                default: break;
            }

            //If the player has 0 health points, the player loses the fight
            if (player.getHealth() <= 0) {
                again = false;
                System.out.println("-- Game Over! --");
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
        int attack = attacker.getAttack();
        int defense = attacked.getDefense();
        int health = attacked.getHealth();

        if (defending) {
            attack = (attack - (((defense * 2) / 100) * attack));
        } else {
            attack = (attack - ((defense / 100) * attack));
        }

        attacked.setHealth(health - attack);
        System.out.println(attacker.getName() + " attacks " + attacked.getName() + "!");
        System.out.println(attacked.getName() + " loses " + attack + " health points.");
        System.out.println();
    }

    public static void printFightStats(Actor player, Actor enemy) {
        System.out.println("++ Current Fight Stats ++");
        System.out.println(player.getName() + ", " + "Health: " + player.getHealth()
                + ", Attack: " + player.getAttack() + ", " + "Defense: " + player.getDefense());
        System.out.println(enemy.getName() + ", " + "Health: " + enemy.getHealth()
                + ", Attack: " + enemy.getAttack() + ", " + "Defense: " + enemy.getDefense());
        System.out.println();
    }

}
