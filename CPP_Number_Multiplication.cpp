#include <iostream>

int main() {
    int number;
    std::cout << "Enter a number: ";
    std::cin >> number;

    int product = 1;
    while (number > 0) {
        int digit = number % 10;
        product *= digit;
        number /= 10;
    }

    std::cout << "The product of the digits is: " << product << std::endl;
    return 0;
}
