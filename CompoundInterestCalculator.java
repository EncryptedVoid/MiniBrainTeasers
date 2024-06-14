import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input principal amount
        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        // Input annual interest rate (in percentage)
        System.out.print("Enter the annual interest rate (in %): ");
        double annualRate = scanner.nextDouble();

        // Input number of times interest is compounded per year
        System.out.print("Enter the number of times interest is compounded per year: ");
        int timesCompounded = scanner.nextInt();

        // Input time in years
        System.out.print("Enter the time in years: ");
        int timeInYears = scanner.nextInt();

        // Calculate compound interest
        double amount = principal * Math.pow(1 + (annualRate / 100) / timesCompounded, timesCompounded * timeInYears);
        double compoundInterest = amount - principal;

        // Output the result
        System.out.printf("The compound interest is: %.2f\n", compoundInterest);
        System.out.printf("The total amount after %.2f years is: %.2f\n", (double) timeInYears, amount);

        scanner.close();
    }
}
