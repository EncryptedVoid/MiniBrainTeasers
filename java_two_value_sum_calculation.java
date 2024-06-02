import java.util.Scanner;

public class java_two_value_sum_calculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first integer
        System.out.print("Enter the first integer: ");
        int firstNumber = scanner.nextInt();

        // Prompt the user to enter the second integer
        System.out.print("Enter the second integer: ");
        int secondNumber = scanner.nextInt();

        // Calculate the sum of the two integers
        int sum = firstNumber + secondNumber;

        // Display the result
        System.out.println("The sum of " + firstNumber + " and " + secondNumber + " is: " + sum);
    }

}
