import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = input;
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] matrix2x2 = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int num1 = matrix[row][col];
                int num2 = matrix[row][col + 1];
                int num3 = matrix[row + 1][col];
                int num4 = matrix[row + 1][col + 1];

                int potentialMax = num1 + num2 + num3 + num4;

                if (potentialMax > maxSum) {
                    maxSum = potentialMax;

                    matrix2x2[0][0] = num1;
                    matrix2x2[0][1] = num2;
                    matrix2x2[1][0] = num3;
                    matrix2x2[1][1] = num4;
                }
            }
        }

        //TODO: do it without matrix

        for (int i = 0; i < matrix2x2.length; i++) {
            for (int j = 0; j < matrix2x2[i].length; j++) {
                System.out.print(matrix2x2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);

    }
}