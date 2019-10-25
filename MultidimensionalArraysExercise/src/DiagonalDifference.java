import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int number = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[number][number];

        for (int i = 0; i < number; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < number; i++) {
            sum1 += matrix[i][i];
            sum2 += matrix[number - 1 - i][i];
        }

        System.out.println(Math.abs(sum1-sum2));
    }
}