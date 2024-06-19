public class JAVA_LCM_CALCULATOR {
    // Method to find the GCD of two numbers
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Method to find the LCM of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int num1 = 12; // Example number 1
        int num2 = 18; // Example number 2

        int lcm = lcm(num1, num2);

        System.out.println("The LCM of " + num1 + " and " + num2 + " is " + lcm);
    }
}
