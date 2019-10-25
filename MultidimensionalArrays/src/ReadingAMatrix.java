import java.util.Scanner;

public class ReadingAMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int [rows][cols];

        for (int row = 0; row < rows; row++){
            String[] inputTokens = scan.nextLine().split(" ");
            for (int column = 0; column <cols; column++){
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }
    }
}
