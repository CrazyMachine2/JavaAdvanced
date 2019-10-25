import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] data = scan.nextLine().split("[()]+");
        int rotateAngle = Integer.parseInt(data[1]) % 360;

        int maxLength = 0;

        List<String> inputs = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            inputs.add(input);
        }

        char[][] matrix = new char[inputs.size()][maxLength];

        for (int row = 0; row < inputs.size(); row++) {
            for (int col = 0; col < maxLength; col++) {
                if (col > inputs.get(row).length() - 1) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputs.get(row).charAt(col);
                }
            }
        }

        if (rotateAngle == 90) {
            printMatrix90(matrix);
        } else if (rotateAngle == 180) {
            printMatrix180(matrix);
        } else if (rotateAngle == 270) {
            printMatrix270(matrix);
        } else {
            printMatrix0(matrix);
        }
    }

    private static void printMatrix270(char[][] matrix) {
        for (int c = matrix[0].length - 1; c >= 0; c--) {
            for (int r = 0; r < matrix.length; r++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix) {
        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix[r].length - 1; c >= 0; c--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix) {
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrix0(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
