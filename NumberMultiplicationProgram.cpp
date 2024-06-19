#include <iostream>
#include <cmath>

int getProductOfDigits(int number) {
    // Use long long to handle larger products
    long long product = 1;
    number = std::abs(number);  // Ensure the number is positive

    if (number == 0) {
        return 0;
    }

    while (number > 0) {
        int digit = number % 10;
        // If digit is 0 and we have other digits, return 0 immediately
        if (digit == 0) {
            return 0;
        }
        product *= digit;
        number /= 10;
    }

    return product;
}

void getUserInputAndCalculateProduct() {
    int number;
    std::cout << "Enter a number: ";
    std::cin >> number;

    int product = getProductOfDigits(number);
    std::cout << "The product of the digits is: " << product << std::endl;
}

int main() {
    getUserInputAndCalculateProduct();
    return 0;
}
