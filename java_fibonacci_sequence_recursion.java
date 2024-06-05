public class java_fibonacci_sequence_recursion {
    // Method to find the nth Fibonacci number using recursion
    public static int findFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return findFibonacci(n - 1) + findFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Example: Find the 10th Fibonacci number
        System.out.println("The " + n + "th Fibonacci number is: " + findFibonacci(n));
    }
}
