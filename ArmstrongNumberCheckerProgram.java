public class ArmstrongNumberChecker {

    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int originalNumber, remainder, result = 0;
        int n = 0;

        originalNumber = number;

        // Find the number of digits in the number
        for (;originalNumber != 0; originalNumber /= 10, ++n);

        originalNumber = number;

        // Compute the sum of the nth power of each digit
        for (;originalNumber != 0; originalNumber /= 10) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
        }

        // Check if the result is equal to the original number
        return result == number;
    }

    public static void main(String[] args) {
        int number = 153; // Example number

        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
