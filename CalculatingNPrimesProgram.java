public class java_N_primes {
    import java.util.Scanner;

    public class PrimeNumbers {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the value of N: ");
            int N = scanner.nextInt();
            scanner.close();

            int count = 0; // Count of prime numbers found
            int num = 2;   // The number to be checked for prime

            while (count < N) {
                if (isPrime(num)) {
                    System.out.println(num);
                    count++;
                }
                num++;
            }
        }

        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
