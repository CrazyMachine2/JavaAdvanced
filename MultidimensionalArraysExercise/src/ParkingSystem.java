import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        while (true) {
            String input = scan.nextLine();

            if (input.equals("stop")) {
                break;
            }

            int[] coordinates = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            int entryRow = coordinates[0];
            int searchedRow = coordinates[1];
            int searchedCol = coordinates[2];
            int distance = Math.abs(entryRow - searchedRow);

            int count = 1;

            if (matrix[searchedRow][searchedCol] != -1) {
                //TODO:Try to add function
                    count += (entryRow - searchedRow) + addSteps(matrix, searchedRow, searchedCol);
                    matrix[searchedRow][searchedCol] = -1;
                    printCount(count);
            } else if (hasFreeSpot(matrix, searchedRow)) {
                searchedCol = firstFreeSpot(matrix, searchedRow);
                if (searchedRow < entryRow) {
                    count += (entryRow - searchedRow) + addSteps(matrix, searchedRow, searchedCol);
                    matrix[searchedRow][searchedCol] = -1;
                    printCount(count);
                } else if (searchedRow > entryRow) {
                    count += (searchedRow - entryRow) + addSteps(matrix, searchedRow, searchedCol);
                    matrix[searchedRow][searchedCol] = -1;
                    printCount(count);
                } else {
                    count += addSteps(matrix, searchedRow, searchedCol);
                    matrix[searchedRow][searchedCol] = -1;
                    printCount(count);
                }
            } else {
                System.out.printf("Row %d full%n", searchedRow);
            }
        }

    }

    private static boolean isValid(int[][] matrix, int searchedRow, int searchedCol, int entryRow) {
        return searchedRow >= 0 && searchedRow < matrix.length && searchedCol >= 0 && searchedCol < matrix[0].length
                && entryRow >=0 && entryRow < matrix.length;
    }

    private static int firstFreeSpot(int[][] matrix, int row) {
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] == 0) {
                return col;
            }
        }
        return 0;
    }

    private static boolean hasFreeSpot(int[][] matrix, int row) {
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] != -1) {
                return true;
            }
        }
        return false;
    }

    private static int addSteps(int[][] matrix, int row, int searchedCol) {
        int count = 0;
        for (int c = 1; c <= searchedCol; c++) {
            count++;
        }
        return count;
    }

    private static void printCount(int count) {
        System.out.println(count);
    }
}
