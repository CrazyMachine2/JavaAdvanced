import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        long fibonacci = fibonacciWithBottomUpDP(n);
        System.out.println(fibonacci);

    }

    private static long recursiveFibonacci(int n)  {
        if (n <= 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    private static long fibonacciWithBottomUpDP(int n) {
        long[] fibonacciNumbers = new long[n + 1];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacciNumbers[i] =
                    fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        return fibonacciNumbers[n];
    }
}
