import java.util.Scanner;

public class CrossFire2 {
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

            matrix = nukeNumbers(matrix, row, col, rad);
            matrix = orderMatrix(matrix);

        }
        printMatrix(matrix);
    }


    private static int[][] orderMatrix(int[][] matrix) {

        int firstColDead = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == -1) {
                    firstColDead = col;
                    for (int i = col + 1; i < matrix[row].length; i++) {
                        if (matrix[row][i] != -1) {
                            matrix[row][firstColDead] = matrix[row][i];
                            matrix[row][i] = -1;
                            break;
                        }
                    }
                }
            }
        }

        return matrix;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows) && (col >= 0 && col < cols);
    }

    private static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != -1) {
                    if (hasRow(matrix, i, j)) {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
            if(hasRow(matrix,i,0)){
                System.out.println();
            }
        }
    }

    private static boolean hasRow(int[][] matrix, int r, int c) {
        int count = 0;

        for (int col = c; col < matrix[r].length; col++) {
            if (matrix[r][col] == -1) {
                count++;
                if (count == matrix.length) {
                    return false;
                }
            }
        }
        return true;
    }


    private static int[][] nukeNumbers(int[][] matrix, int row, int col, int rad) {

        for (int i = 1; i <= rad; i++) {
            //up
            if (row - i >= 0 && row - i < matrix.length && col >= 0 && col < matrix[0].length) {
                matrix[row - i][col] = -1;
            }
            //down
            if (row + i < matrix.length && row + i >= 0 && col >= 0 && col < matrix[0].length) {
                matrix[row + i][col] = -1;
            }
            //left
            if (col - i >= 0 && col - i < matrix[0].length && row >= 0 && row < matrix.length) {
                matrix[row][col - i] = -1;
            }
            //right
            if (col + i < matrix[0].length && col + i >= 0 && row >= 0 && row < matrix.length) {
                matrix[row][col + i] = -1;
            }
        }
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            matrix[row][col] = -1;
        }
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
