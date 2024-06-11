#include <iostream>
#include <vector>

int main() {
    int n;

    // Get the size of the matrix
    std::cout << "Enter the size of the matrix (n x n): ";
    std::cin >> n;

    // Declare a 2D vector to store the matrix
    std::vector<std::vector<int>> matrix(n, std::vector<int>(n));

    // Get the elements of the matrix from the user
    std::cout << "Enter the elements of the matrix:\n";
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            std::cin >> matrix[i][j];
        }
    }

    // Calculate the sum of elements above the main diagonal
    int sum = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            sum += matrix[i][j];
        }
    }

    // Output the sum
    std::cout << "The sum of the elements above the main diagonal is: " << sum << std::endl;

    return 0;
}
