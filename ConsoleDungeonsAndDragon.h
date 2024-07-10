#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Define character structure
typedef struct {
    char name[30];
    int health;
    int attack;
    int defense;
    int level;
    int experience;
} Character;

// Function prototypes
void createCharacter(Character *player);
void battle(Character *player, Character *enemy);
void levelUp(Character *player);
int getRandom(int min, int max);

int main() {
    srand(time(NULL));

    Character player;
    Character enemy = {"Goblin", 50, 10, 5, 1, 0};

    createCharacter(&player);

    printf("A wild %s appears!\n", enemy.name);
    battle(&player, &enemy);

    if (player.health > 0) {
        printf("Congratulations, you have defeated the %s!\n", enemy.name);
    } else {
        printf("You have been defeated by the %s.\n", enemy.name);
    }

    return 0;
}

void createCharacter(Character *player) {
    printf("Enter your character's name: ");
    scanf("%s", player->name);
    player->health = 100;
    player->attack = 20;
    player->defense = 10;
    player->level = 1;
    player->experience = 0;

    printf("Welcome, %s! Your adventure begins now.\n", player->name);
}

void battle(Character *player, Character *enemy) {
    while (player->health > 0 && enemy->health > 0) {
        int playerDamage = getRandom(player->attack / 2, player->attack) - enemy->defense;
        int enemyDamage = getRandom(enemy->attack / 2, enemy->attack) - player->defense;

        if (playerDamage < 0) playerDamage = 0;
        if (enemyDamage < 0) enemyDamage = 0;

        printf("%s attacks %s for %d damage!\n", player->name, enemy->name, playerDamage);
        enemy->health -= playerDamage;

        if (enemy->health <= 0) {
            printf("%s has been defeated!\n", enemy->name);
            player->experience += 50;
            levelUp(player);
            break;
        }

        printf("%s attacks %s for %d damage!\n", enemy->name, player->name, enemyDamage);
        player->health -= enemyDamage;

        if (player->health <= 0) {
            printf("%s has been defeated!\n", player->name);
            break;
        }
    }
}

void levelUp(Character *player) {
    if (player->experience >= 100) {
        player->level++;
        player->health += 20;
        player->attack += 5;
        player->defense += 3;
        player->experience = 0;

        printf("Congratulations! %s has leveled up to level %d!\n", player->name, player->level);
    }
}

int getRandom(int min, int max) {
    return rand() % (max - min + 1) + min;
}
