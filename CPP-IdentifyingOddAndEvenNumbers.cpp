#include <stdio.h>
#include <stdlib.h>

// Function to check if the input is a valid integer
int isValidInteger(char *input) {
    char *endptr;
    strtol(input, &endptr, 10);
    return *endptr == '\0';
}

// Function to check if a number is even or odd
void checkEvenOdd(int number) {
    if (number % 2 == 0) {
        printf("%d is even.\n", number);
    } else {
        printf("%d is odd.\n", number);
    }
}

int main() {
    char input[100];
    int number;
    char choice;

    do {
        printf("Enter an integer: ");
        scanf("%s", input);

        // Validate input
        while (!isValidInteger(input)) {
            printf("Invalid input. Please enter a valid integer: ");
            scanf("%s", input);
        }

        // Convert input to integer
        number = atoi(input);

        // Check if the number is even or odd
        checkEvenOdd(number);

        // Ask user if they want to continue or exit
        printf("Do you want to check another number? (y/n): ");
        scanf(" %c", &choice);

    } while (choice == 'y' || choice == 'Y');

    printf("Program terminated.\n");
    return 0;
}
