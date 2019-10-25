import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String sizes = scan.nextLine();

        int[][] matrix = readMatrix(sizes,scan);

        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    public static int[][] readMatrix (String sizes, Scanner scan){

        String[] dimensions = sizes.split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
           int [] numbers = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];
            }
        }
        return matrix;
    }
}
