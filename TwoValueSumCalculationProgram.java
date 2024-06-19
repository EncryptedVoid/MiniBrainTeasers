import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_two_value_sum_calculation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean continueCalculating = true;

        while (continueCalculating) {
            try {
                System.out.print("Enter the first integer: ");
                int firstNumber = Integer.parseInt(reader.readLine().trim());

                System.out.print("Enter the second integer: ");
                int secondNumber = Integer.parseInt(reader.readLine().trim());

                System.out.print("Choose an operation (+, -, *, /): ");
                char operation = (char) reader.readLine().trim().charAt(0);

                int result = 0;
                boolean validOperation = true;

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
                            validOperation = false;
                        } else {
                            result = firstNumber / secondNumber;
                        }
                        break;
                    default:
                        System.out.println("Invalid operation. Please choose one of +, -, *, /.");
                        validOperation = false;
                }

                if (validOperation) {
                    System.out.println(STR."The result of \{firstNumber} \{operation} \{secondNumber} is: \{result}");
                }

                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String userResponse = reader.readLine().trim();

                if (!userResponse.equalsIgnoreCase("yes")) {
                    continueCalculating = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers.");
            }
        }

        System.out.println("Thank you for using the calculator. Goodbye!");
    }
}
