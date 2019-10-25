import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int [][] matrix = new int[number][number];


        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {

                if(numbers.length != matrix[0].length){
                    for (int i = 0; i < numbers.length; i++) {
                        matrix[row][i] = numbers[i];
                    }
                    break;
                }
                matrix[row][col] = numbers[col];
            }
        }


        for (int rows = 0; rows < matrix.length; rows++) {
            System.out.print(matrix[rows][rows] + " ");
        }

        System.out.println();

        for (int rows = 0; rows < matrix.length; rows++) {
            System.out.print(matrix[number - 1 - rows][rows] + " ");
        }
    }
}
