import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String [][] matrix = new String[rows][cols];
        matrix = getMatrix(matrix);
        printMatrix(matrix);

    }

    private static String[][] getMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = fillMatrix(matrix,row,col);
            }
        }
        return matrix;
    }

    private static String fillMatrix(String[][] matrix, int row, int col) {

        for (int i = 0; i < 3; i++) {
            char letter = (char) ('a' + row);
            if (i %2 == 1){
                matrix[row][col] += (char) (letter + col);
            } else if (i == 0) {
                matrix[row][col] = String.valueOf(letter);
            } else {
                matrix[row][col] += letter;
            }
        }
        return matrix[row][col];
    }

    private static void printMatrix (String[][]matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
