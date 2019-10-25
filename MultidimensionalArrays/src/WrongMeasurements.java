import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[number][];

        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = numbers;
        }

        int[] wrongNumberDimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = wrongNumberDimensions[0];
        int c = wrongNumberDimensions[1];

        int wrongNumber = matrix[r][c];

        if (matrix[0].length == 1) {
            for (int row = 0; row < matrix.length; row++){
                int numberCandidate = matrix[row][0];
                int sum = 0;

                if (row == 0){
                    int numD = matrix[row+1][0];

                    if (numD != wrongNumber){
                        sum += numD;
                    }
                    matrix[row][0] = sum;
                } else if (row == matrix.length -1){
                    int numU = matrix[row-1][0];

                    if (numU != wrongNumber){
                        sum += numU;
                    }
                    matrix[row][0] = sum;
                } else {
                    int numD = matrix[row+1][0];
                    int numU = matrix[row-1][0];

                    if (numD != wrongNumber){
                        sum += numD;
                    }
                    if (numU != wrongNumber){
                        sum += numU;
                    }
                    matrix[row][0] = sum;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int numberCandidate = matrix[row][col];
                int sum = 0;
                if (numberCandidate == wrongNumber) {

                    if (row == 0) {
                        if (col == 0) {
                            int numD = matrix[row + 1][col];
                            int numR = matrix[row][col + 1];

                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            matrix[row][col] = sum;

                        } else if (col == matrix[row].length - 1) {
                            int numD = matrix[row + 1][col];
                            int numL = matrix[row][col - 1];

                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            matrix[row][col] = sum;
                        } else {
                            int numD = matrix[row + 1][col];
                            int numL = matrix[row][col - 1];
                            int numR = matrix[row][col + 1];

                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            matrix[row][col] = sum;
                        }

                    } else if (row == matrix.length - 1) {
                        if (col == 0) {
                            int numU = matrix[row - 1][col];
                            int numR = matrix[row][col + 1];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            matrix[row][col] = sum;

                        } else if (col == matrix[row].length - 1) {
                            int numU = matrix[row - 1][col];
                            int numL = matrix[row][col - 1];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            matrix[row][col] = sum;
                        } else {
                            int numU = matrix[row - 1][col];
                            int numL = matrix[row][col - 1];
                            int numR = matrix[row][col + 1];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            matrix[row][col] = sum;
                        }

                    } else {
                        if (col == 0) {
                            int numU = matrix[row - 1][col];
                            int numR = matrix[row][col + 1];
                            int numD = matrix[row + 1][col];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            matrix[row][col] = sum;

                        } else if (col == matrix[row].length - 1) {
                            int numU = matrix[row - 1][col];
                            int numL = matrix[row][col - 1];
                            int numD = matrix[row + 1][col];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            matrix[row][col] = sum;
                        } else {
                            int numU = matrix[row - 1][col];
                            int numL = matrix[row][col - 1];
                            int numR = matrix[row][col + 1];
                            int numD = matrix[row + 1][col];

                            if (numU != wrongNumber) {
                                sum += numU;
                            }
                            if (numL != wrongNumber) {
                                sum += numL;
                            }
                            if (numR != wrongNumber) {
                                sum += numR;
                            }
                            if (numD != wrongNumber) {
                                sum += numD;
                            }
                            matrix[row][col] = sum;
                        }
                    }

                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
