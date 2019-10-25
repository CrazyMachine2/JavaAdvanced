import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixNotMine {
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

        int row = rows -1;
        int col = cols -1;

        while (row != -1){
            int c = col;
            int r = row;
            while (c < cols && r >=0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1){
                col = 0;
                row--;
            }
        }
    }
}
