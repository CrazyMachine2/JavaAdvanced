import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }

        int curRow = matrix.length - 2;

        for (int col = matrix[rows - 1].length - 1; col >= 0; col--) {
            System.out.print(matrix[rows - 1][col] + " ");
            for (int colR = col + 1; colR < matrix[0].length; colR++) {
                if (curRow >= 0) {
                    if (colR < matrix[curRow].length) {
                        System.out.print(matrix[curRow][colR] + " ");
                        curRow--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            curRow = matrix.length - 2;
            System.out.println();
        }

        if (rows > 1) {
            curRow = matrix.length - 3;
            int count = 3;
            for (int row = rows - 2; row >= 0; row--) {
                System.out.print(matrix[row][0] + " ");
                if (row == 0) {
                    break;
                }
                for (int colR = 1; colR < matrix[0].length; colR++) {
                    if (curRow >= 0) {
                        if (colR < matrix[curRow].length) {
                            System.out.print(matrix[curRow][colR] + " ");
                            curRow--;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                curRow = matrix.length - ++count;
                System.out.println();
            }
        }
    }
}
