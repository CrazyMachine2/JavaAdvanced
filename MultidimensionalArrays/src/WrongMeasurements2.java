import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[number][];

        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        int[] wrongNumberDimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = wrongNumberDimensions[0];
        int c = wrongNumberDimensions[1];

        int wrongNumber = matrix[r][c];
        int[][] resultMatrix = new int[number][];

        for (int i = 0; i < number; i++) {
            resultMatrix[i] = matrix[i].clone();
        }


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(resultMatrix[row][col] == wrongNumber){
                    resultMatrix[row][col] = getSum(matrix, row, col, wrongNumber);
                }
            }
        }

        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] matrix, int row, int col, int wrongNumber) {

        int sum = 0;

        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }
}