import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        matrix = fillMatrix(matrix);

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Nuke it from orbit")) {
                break;
            }

            String[] data = input.split(" ");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int rad = Integer.parseInt(data[2]);

            if (isValid(row, col, rows, cols)) {
                int number = matrix[row][col];

                if (number != -1) {
                    matrix = nukeNumbers(matrix, row, col, rad);

                } else {
                    int aliveCol = findAlive(matrix, row, col);
                    if (aliveCol != -1) {
                        number = matrix[row][aliveCol];
                        matrix = nukeNumbers(matrix, row, aliveCol, rad);
                    }
                }
            }

        }
        printMatrix(matrix);
    }

    private static int findAlive(int[][] matrix, int row, int col) {
        for (int i = col; i < matrix[0].length; i++) {
            if (matrix[row][i] != -1) {
                return i;
            }
        }
        return -1;
    }

    private static int findAliveLeft(int[][] matrix, int row, int col) {
        for (int i = col; i >= 0; i--) {
            if (matrix[row][i] != -1) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows) && (col >= 0 && col < cols);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != -1) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] nukeNumbers(int[][] matrix, int row, int col, int rad) {

        for (int i = 1; i <= rad; i++) {
            //up
            if (row - i >= 0) {
                matrix[row - i][col] = -1;
            }
            //down
            if (row + i < matrix.length) {
                matrix[row + i][col] = -1;
            }
            //left
            if (col - i >= 0) {
                matrix[row][col - i] = -1;
            }
            //right
            if (col + i < matrix[0].length) {
                matrix[row][col + i] = -1;
            }
        }
        matrix[row][col] = -1;
        return matrix;
    }

    private static int[][] fillMatrix(int[][] matrix) {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        return matrix;
    }
}
