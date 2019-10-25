import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] matrixA = new char[rows][cols];
        char[][] matrixB = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] symbols = scan.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                char current = symbols[col].charAt(0);
                matrixA[row][col] = current;
            }
        }

        for (int row = 0; row < rows; row++) {
            String[] symbols = scan.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                char current = symbols[col].charAt(0);
                matrixB[row][col] = current;
            }
        }

        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < matrixA[row].length ; col++) {
                if (matrixA[row][col] != (matrixB[row][col])){
                    System.out.print("*" + " ");
                } else {
                    System.out.print(matrixA[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}

