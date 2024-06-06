public class java__matrix_border_len {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int sum = borderSum(matrix);
        System.out.println("Sum of border elements: " + sum);
    }

    public static int borderSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum = 0;

        // Sum the first and last rows
        for (int j = 0; j < cols; j++) {
            sum += matrix[0][j]; // First row
            sum += matrix[rows - 1][j]; // Last row
        }

        // Sum the first and last columns, excluding the already added corners
        for (int i = 1; i < rows - 1; i++) {
            sum += matrix[i][0]; // First column
            sum += matrix[i][cols - 1]; // Last column
        }

        return sum;
    }
}
