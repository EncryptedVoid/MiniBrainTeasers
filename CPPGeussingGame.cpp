#include <iostream>
#include <cstdlib>
#include <ctime>

int main() {
    // Seed the random number generator
    std::srand(std::time(0));
    int numberToGuess = std::rand() % 100 + 1; // Random number between 1 and 100
    int userGuess = 0;
    int attempts = 0;

    std::cout << "Welcome to the Number Guessing Game!" << std::endl;
    std::cout << "I have selected a number between 1 and 100." << std::endl;
    std::cout << "Can you guess what it is?" << std::endl;

    // Main game loop
    while (userGuess != numberToGuess) {
        std::cout << "Enter your guess: ";
        std::cin >> userGuess;
        attempts++;

        if (userGuess > numberToGuess) {
            std::cout << "Too high! Try again." << std::endl;
        } else if (userGuess < numberToGuess) {
            std::cout << "Too low! Try again." << std::endl;
        } else {
            std::cout << "Congratulations! You guessed the number in " << attempts << " attempts." << std::endl;
        }
    }

    return 0;
}
