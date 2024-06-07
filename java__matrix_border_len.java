import java.util.Scanner;

public class java__matrix_border_len {

    public static void main(String[] args) {
        try {
            int sum = calculateBorderSum();
            System.out.println("Sum of border elements: " + sum);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int calculateBorderSum() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            throw new Exception("Matrix dimensions must be greater than zero.");
        }

        int sum = 0;
        System.out.println("Enter the matrix elements row by row:");

        // Read the first row
        for (int j = 0; j < cols; j++) {
            sum += scanner.nextInt();
        }

        // Read the middle rows
        for (int i = 1; i < rows - 1; i++) {
            // First element of the current row
            sum += scanner.nextInt();
            // Skip middle elements
            for (int j = 1; j < cols - 1; j++) {
                scanner.nextInt();
            }
            // Last element of the current row
            sum += scanner.nextInt();
        }

        // Read the last row if it exists and is not the same as the first row
        if (rows > 1) {
            for (int j = 0; j < cols; j++) {
                sum += scanner.nextInt();
            }
        }

        return sum;
    }

}
