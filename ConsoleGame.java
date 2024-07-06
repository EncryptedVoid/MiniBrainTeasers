import java.util.Random;
import java.util.Scanner;

public class DungeonAdventure {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int playerHealth = 100;
    private static int playerGold = 0;
    private static int monsterHealth;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the Dungeon Adventure!");
        System.out.println("You find yourself at the entrance of a dark and eerie dungeon.");
        System.out.println("Your objective is to explore, fight monsters, and collect treasures.");

        while (running) {
            System.out.println("\nYou stand at a crossroad. Choose a direction:");
            System.out.println("1. Move forward");
            System.out.println("2. Move left");
            System.out.println("3. Move right");
            System.out.println("4. Check status");
            System.out.println("5. Exit dungeon");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    explore();
                    break;
                case 4:
                    checkStatus();
                    break;
                case 5:
                    running = false;
                    System.out.println("You have exited the dungeon. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void explore() {
        System.out.println("You move deeper into the dungeon...");
        if (random.nextInt(100) < 50) {
            encounterMonster();
        } else {
            findTreasure();
        }
    }

    private static void encounterMonster() {
        System.out.println("A wild monster appears!");
        monsterHealth = random.nextInt(50) + 50;

        while (monsterHealth > 0) {
            System.out.println("Monster HP: " + monsterHealth);
            System.out.println("Your HP: " + playerHealth);
            System.out.println("1. Attack");
            System.out.println("2. Run away");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            if (choice == 1) {
                int playerDamage = random.nextInt(20) + 10;
                int monsterDamage = random.nextInt(15) + 5;
                monsterHealth -= playerDamage;
                playerHealth -= monsterDamage;
                System.out.println("You deal " + playerDamage + " damage to the monster.");
                System.out.println("The monster deals " + monsterDamage + " damage to you.");
                if (playerHealth <= 0) {
                    System.out.println("You have been defeated by the monster. Game Over.");
                    running = false;
                    return;
                }
            } else if (choice == 2) {
                System.out.println("You run away from the monster!");
                return;
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }

        System.out.println("You have defeated the monster!");
        int goldFound = random.nextInt(50) + 10;
        playerGold += goldFound;
        System.out.println("You found " + goldFound + " gold.");
    }

    private static void findTreasure() {
        int goldFound = random.nextInt(100) + 50;
        playerGold += goldFound;
        System.out.println("You found a treasure chest containing " + goldFound + " gold.");
    }

    private static void checkStatus() {
        System.out.println("Your HP: " + playerHealth);
        System.out.println("Your gold: " + playerGold);
    }
}
