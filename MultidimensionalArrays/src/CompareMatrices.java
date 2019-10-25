import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        String[] rowsNcols = scan.nextLine().split(" ");

        int rows = Integer.parseInt(rowsNcols[0]);
        int cols = Integer.parseInt(rowsNcols[1]);

        int[][] firstMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] colData = scan.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = Integer.parseInt(colData[col]);
            }
        }

        String[] rowsNcols1 = scan.nextLine().split(" ");

        int rows1 = Integer.parseInt(rowsNcols1[0]);
        int cols1 = Integer.parseInt(rowsNcols1[1]);

        int[][] secondMatrix = new int[rows1][cols1];

        for (int row = 0; row < rows1; row++) {
            String[] colData = scan.nextLine().split(" ");
            for (int col = 0; col < cols1; col++) {
                secondMatrix[row][col] = Integer.parseInt(colData[col]);
            }
        }

        if(cols != cols1 || rows != rows1){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if(firstMatrix[row][col] != secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
