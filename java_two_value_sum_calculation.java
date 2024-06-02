import java.util.InputMismatchException;
import java.util.Scanner;

public class java_two_value_sum_calculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            try {
                System.out.print("Enter the first integer: ");
                int firstNumber = scanner.nextInt();

                System.out.print("Enter the second integer: ");
                int secondNumber = scanner.nextInt();

                System.out.print("Choose an operation (+, -, *, /): ");
                char operation = scanner.next().charAt(0);

                int result = 0;

                switch (operation) {
                    case '+':
                        result = firstNumber + secondNumber;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                    case '*':
                        result = firstNumber * secondNumber;
                        break;
                    case '/':
                        if (secondNumber == 0) {
                            System.out.println("Error: Division by zero is not allowed.");
                            continue;
                        }
                        result = firstNumber / secondNumber;
                        break;
                    default:
                        System.out.println("Invalid operation. Please choose one of +, -, *, /.");
                        continue;
                }

                System.out.println("The result of " + firstNumber + " " + operation + " " + secondNumber + " is: " + result);

                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String userResponse = scanner.next();

                if (!userResponse.equalsIgnoreCase("yes")) {
                    continueCalculating = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        System.out.println("Thank you for using the calculator. Goodbye!");
        scanner.close();
    }

}
