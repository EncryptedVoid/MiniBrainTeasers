public class java__matrix_border_len {
    import java.util.Scanner;

    public class BorderSum {
        public static void main(String[] args) {
            try {
                int[][] matrix = readMatrix();
                validateMatrix(matrix);
                int sum = calculateBorderSum(matrix);
                System.out.println("Sum of border elements: " + sum);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public static int[][] readMatrix() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of rows:");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of columns:");
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];

            System.out.println("Enter the matrix elements row by row:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            return matrix;
        }

        public static void validateMatrix(int[][] matrix) throws Exception {
            if (matrix.length == 0 || matrix[0].length == 0) {
                throw new Exception("Matrix cannot be empty");
            }
            int cols = matrix[0].length;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i].length != cols) {
                    throw new Exception("All rows must have the same number of columns");
                }
            }
        }

        public static int calculateBorderSum(int[][] matrix) {
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

}
