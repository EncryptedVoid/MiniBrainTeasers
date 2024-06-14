import java.util.Scanner;

public class CompoundInterestCalculator  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculations = true;

        while (continueCalculations) {
            // Input principal amount with validation
            double principal = getValidInput(scanner, "Enter the principal amount: ", 0);

            // Input annual interest rate (in percentage) with validation
            double annualRate = getValidInput(scanner, "Enter the annual interest rate (in %): ", 0);

            // Input number of times interest is compounded per year with options
            int timesCompounded = getCompoundingFrequency(scanner);

            // Input time in years with validation
            double timeInYears = getValidInput(scanner, "Enter the time in years: ", 0);

            // Calculate compound interest
            double amount = principal * Math.pow(1 + (annualRate / 100) / timesCompounded, timesCompounded * timeInYears);
            double compoundInterest = amount - principal;

            // Output the result
            System.out.printf("The compound interest is: %.2f\n", compoundInterest);
            System.out.printf("The total amount after %.2f years is: %.2f\n", timeInYears, amount);

            // Ask if the user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = scanner.next();
            continueCalculations = response.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    // Method to get valid input
    private static double getValidInput(Scanner scanner, String prompt, double minValue) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= minValue) {
                    break;
                } else {
                    System.out.println("Please enter a value greater than or equal to " + minValue);
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear the invalid input
            }
        }
        return value;
    }

    // Method to get compounding frequency
    private static int getCompoundingFrequency(Scanner scanner) {
        System.out.println("Select the compounding frequency:");
        System.out.println("1. Daily");
        System.out.println("2. Monthly");
        System.out.println("3. Quarterly");
        System.out.println("4. Semi-Annually");
        System.out.println("5. Annually");

        int choice;
        while (true) {
            System.out.print("Enter your choice (1-5): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // clear the invalid input
            }
        }

        switch (choice) {
            case 1: return 365; // Daily
            case 2: return 12;  // Monthly
            case 3: return 4;   // Quarterly
            case 4: return 2;   // Semi-Annually
            case 5: return 1;   // Annually
            default: return 1;  // Default to annually if something goes wrong
        }
    }
}
