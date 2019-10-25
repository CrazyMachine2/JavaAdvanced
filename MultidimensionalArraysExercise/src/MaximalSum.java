import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int currentSum = sumFromTopLeft(matrix, i, j);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        System.out.printf("%d %d %d\n%d %d %d\n%d %d %d",
                matrix[maxRow][maxCol],
                matrix[maxRow][maxCol + 1],
                matrix[maxRow][maxCol + 2],
                matrix[maxRow + 1][maxCol],
                matrix[maxRow + 1][maxCol + 1],
                matrix[maxRow + 1][maxCol + 2],
                matrix[maxRow + 2][maxCol],
                matrix[maxRow + 2][maxCol + 1],
                matrix[maxRow + 2][maxCol + 2]
        );
    }

    private static int sumFromTopLeft(int[][] matrix, int row, int col) {
        return matrix[row][col] +
                matrix[row][col + 1] +
                matrix[row][col + 2] +
                matrix[row + 1][col] +
                matrix[row + 1][col + 1] +
                matrix[row + 1][col + 2] +
                matrix[row + 2][col] +
                matrix[row + 2][col + 1] +
                matrix[row + 2][col + 2];
    }
}
