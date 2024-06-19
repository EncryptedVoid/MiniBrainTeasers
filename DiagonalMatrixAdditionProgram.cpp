#include <iostream>
#include <vector>

// Function to get matrix dimensions from the user
void getMatrixDimensions(int &rows, int &cols) {
    std::cout << "Enter the number of rows: ";
    std::cin >> rows;
    std::cout << "Enter the number of columns: ";
    std::cin >> cols;
}

// Function to input matrix elements from the user
void inputMatrixElements(std::vector<std::vector<int>> &matrix, int rows, int cols) {
    std::cout << "Enter the elements of the matrix:\n";
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            std::cin >> matrix[i][j];
        }
    }
}

// Function to calculate the sum of elements above the main diagonal
int sumAboveMainDiagonal(const std::vector<std::vector<int>> &matrix, int rows, int cols) {
    int sum = 0;
    for (int i = 0; i < rows; ++i) {
        for (int j = i + 1; j < cols; ++j) {
            sum += matrix[i][j];
        }
    }
    return sum;
}

// Main function
int main() {
    int rows, cols;

    // Get the dimensions of the matrix
    getMatrixDimensions(rows, cols);

    // Check if the matrix is at least 1x1
    if (rows < 1 || cols < 1) {
        std::cerr << "Error: Matrix dimensions must be at least 1x1." << std::endl;
        return 1;
    }

    // Declare a 2D vector to store the matrix
    std::vector<std::vector<int>> matrix(rows, std::vector<int>(cols));

    // Get the elements of the matrix from the user
    inputMatrixElements(matrix, rows, cols);

    // Calculate the sum of elements above the main diagonal
    int sum = sumAboveMainDiagonal(matrix, rows, cols);

    // Output the sum
    std::cout << "The sum of the elements above the main diagonal is: " << sum << std::endl;

    return 0;
}


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
