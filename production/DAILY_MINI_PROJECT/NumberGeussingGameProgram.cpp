#include <iostream>
#include <cstdlib>
#include <ctime>

// Function prototypes
void printWelcomeMessage();
void printInstructions();
int generateRandomNumber();
void playGame(int numberToGuess);
void printSuccessMessage(int attempts);
void printHint(int guess, int numberToGuess);
void setConsoleColor(const std::string& color);

int main() {
    // Seed the random number generator
    std::srand(std::time(0));
    int numberToGuess = generateRandomNumber();

    printWelcomeMessage();
    printInstructions();

    playGame(numberToGuess);

    return 0;
}

void printWelcomeMessage() {
    setConsoleColor("1;32"); // Bold green
    std::cout << "Welcome to the Number Guessing Game!" << std::endl;
    setConsoleColor("0"); // Reset
}

void printInstructions() {
    setConsoleColor("1;34"); // Bold blue
    std::cout << "I have selected a number between 1 and 100." << std::endl;
    std::cout << "Can you guess what it is?" << std::endl;
    setConsoleColor("0"); // Reset
}

int generateRandomNumber() {
    return std::rand() % 100 + 1; // Random number between 1 and 100
}

void playGame(int numberToGuess) {
    int userGuess = 0;
    int attempts = 0;

    while (userGuess != numberToGuess) {
        setConsoleColor("1;33"); // Bold yellow
        std::cout << "Enter your guess: ";
        setConsoleColor("0"); // Reset
        std::cin >> userGuess;
        attempts++;

        if (userGuess != numberToGuess) {
            printHint(userGuess, numberToGuess);
        } else {
            printSuccessMessage(attempts);
        }
    }
}

void printSuccessMessage(int attempts) {
    setConsoleColor("1;32"); // Bold green
    std::cout << "Congratulations! You guessed the number in " << attempts << " attempts." << std::endl;
    setConsoleColor("0"); // Reset
}

void printHint(int guess, int numberToGuess) {
    if (guess > numberToGuess) {
        setConsoleColor("1;31"); // Bold red
        std::cout << "Too high! Try again." << std::endl;
    } else {
        setConsoleColor("1;31"); // Bold red
        std::cout << "Too low! Try again." << std::endl;
    }
    setConsoleColor("0"); // Reset
}

void setConsoleColor(const std::string& color) {
    std::cout << "\033[" << color << "m";
}
