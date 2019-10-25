import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        matrix = fillMatrix(matrix, rows, cols);

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


    private static boolean isInRange(int row, int col,List<List<Integer>>matrix) {
        return (row >= 0 && row < matrix.size()) && (col >= 0 && col < matrix.get(row).size());
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sb.append(matrix.get(i).get(j) + " ");
            }
            sb.append("\r\n");
        }
        System.out.println(sb);

//             for(List<Integer> integers : matrix){
//        for (Integer integer : integers) {
//        System.out.print(integer + " ");
//        }
//        System.out.println();
//        }
    }

    private static List<List<Integer>> nukeNumbers(List<List<Integer>> matrix, int row, int col, int rad) {

        for (int i = 0; i <= rad; i++) {
            //up
            if (row - i >= 0 && row - i < matrix.size() && col >= 0) {
                if (col < matrix.get(row-i).size()) {
                    matrix.get(row - i).set(col, -1);
                }
            }
            //down
            if (row + i < matrix.size() && row + i >= 0 && col >= 0) {
                if (col < matrix.get(row +i).size()) {
                    matrix.get(row + i).set(col, -1);
                }
            }
            //left
            if (col - i >= 0 && row >= 0 && row < matrix.size()) {
                if (col - i < matrix.get(row).size()) {
                    matrix.get(row).set(col - i, -1);
                }
            }
            //right
            if (col + i >= 0 && row >= 0 && row < matrix.size()) {
                if (col + i < matrix.get(row).size()) {
                    matrix.get(row).set(col + i, -1);
                }
            }
        }
        if (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size()) {
            matrix.get(row).set(col, -1);
        }
        return matrix;
    }

    private static List<List<Integer>> fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int count = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(count);
                count++;
            }
        }
        return matrix;
    }

    private static List<List<Integer>> orderMatrix(List<List<Integer>> matrix) {
        for (int row = matrix.size() - 1; row >= 0; row--) {
            for (int col = matrix.get(row).size() - 1; col >= 0; col--) {
                if (matrix.get(row).get(col) == -1) {
                    matrix.get(row).remove(col);
                    matrix.removeIf(List::isEmpty);
                }
            }
        }
        return matrix;
    }

}

//     for (int i = row - radius; i <= row + radius; i++) {
//             if (isInRange(i, col, matrix) && i != row){
//             matrix.get(i).remove(col);
//             }
//             }
//
//             for (int i = col + radius; i >= col - radius; i--) {
//             if (isInRange(row, i, matrix)){
//             matrix.get(row).remove(i);
//             }
//             }
//
//             matrix.removeIf(List::isEmpty);
//
