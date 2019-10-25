import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double playerHP = 18500;
        double heiganHP = 3000000;
        int[][] matrix = new int[15][15];

        int playerRow = 8;
        int playerCol = 8;

        boolean isDefeated = false;

        double dmgEachTurn = Double.parseDouble(scan.nextLine());

        printMatrix(matrix);
       while (isDefeated){
            String[] data = scan.nextLine().split(" ");
           String spell = data[0];
           int row = Integer.parseInt(data[1]);
          int col = Integer.parseInt(data[2]);
       }
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
}
