import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            matrix[i] = input;
        }

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            String[] data = input.split(" ");

            if (data.length == 5 && data[0].equals("swap")) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if (areCoordinatesValid(row1, col1, row2, col2, rows, cols)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);
                } else {
                    printError();
                }
            } else {
                printError();
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean areCoordinatesValid(int row1, int col1, int row2, int col2, int rows, int cols) {
        return (row1 >= 0 && row1 < rows) && (row2 >= 0 && row2 < rows)
                && (col1 >= 0 && col1 < cols) && (col2 >= 0 && col2 < cols);
    }

    private static void printError() {
        System.out.println("Invalid input!");
    }
}
