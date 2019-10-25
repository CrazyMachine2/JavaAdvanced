import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            matrix = getPatternA(matrix);
            printMatrix(matrix);
        } else {
            matrix = getPatternB(matrix);
            printMatrix(matrix);
        }
    }

    private static int[][] getPatternA(int[][] matrix) {
        int count = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
        return matrix;
    }

    private static int[][] getPatternB(int[][] matrix) {
        int count = 1;

        for (int col = 0; col < matrix[0].length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
