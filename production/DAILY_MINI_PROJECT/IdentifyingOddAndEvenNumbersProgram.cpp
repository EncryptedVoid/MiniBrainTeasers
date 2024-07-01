#include <stdio.h>

int main() {
    int number;
    char choice;

    do {
        printf("Enter an integer: ");
        // Use scanf directly to get the integer input
        while (scanf("%d", &number) != 1) {
            // Clear the input buffer if the input is not an integer
            while (getchar() != '\n');
            printf("Invalid input. Please enter a valid integer: ");
        }

        // Check if the number is even or odd
        if (number % 2 == 0) {
            printf("%d is even.\n", number);
        } else {
            printf("%d is odd.\n", number);
        }

        // Ask user if they want to continue or exit
        printf("Do you want to check another number? (y/n): ");
        scanf(" %c", &choice);
        // Clear the input buffer
        while (getchar() != '\n');

    } while (choice == 'y' || choice == 'Y');

    printf("Program terminated.\n");
    return 0;
}
