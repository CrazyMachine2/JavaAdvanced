import java.util.Scanner;

public class TronRacers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int dimension = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[dimension][dimension];

        int firstPlayerRow = 0;
        int firstPlayerCol = 0;
        int secondPlayerRow = 0;
        int secondPlayerCol = 0;


        for (int i = 0; i < dimension; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < input.length; j++) {
                if (input[j].equals("f")) {
                    firstPlayerRow = i;
                    firstPlayerCol = j;
                }
                if (input[j].equals("s")) {
                    secondPlayerRow = i;
                    secondPlayerCol = j;
                }

                matrix[i][j] = input[j];
            }
        }
        boolean isAlive = true;

        while (true) {
            String[] cmd = scan.nextLine().split(" ");
            String firstPlayerCmd = cmd[0];
            String secondPlayerCmd = cmd[1];

            isAlive = moveFirstPlayer(matrix, firstPlayerCmd, firstPlayerRow, firstPlayerCol);

            if (isAlive) {
                if (firstPlayerCmd.equals("up") || firstPlayerCmd.equals("down")) {
                    firstPlayerRow = updateRow(firstPlayerCmd, firstPlayerRow, matrix);
                } else {
                    firstPlayerCol = updateCol(firstPlayerCmd, firstPlayerCol, matrix);
                }

                isAlive = moveSecondPlayer(matrix,secondPlayerCmd,secondPlayerRow,secondPlayerCol);
                if(isAlive){
                    if (secondPlayerCmd.equals("up") || secondPlayerCmd.equals("down")) {
                        secondPlayerRow = updateRow(secondPlayerCmd, secondPlayerRow, matrix);
                    } else {
                        secondPlayerCol = updateCol(secondPlayerCmd, secondPlayerCol, matrix);
                    }
                } else {
                    printMatrix(matrix);
                   return;
                }

            } else {
                printMatrix(matrix);
                return;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }


    private static boolean moveFirstPlayer(String[][] matrix, String cmd, int row, int col) {

        if (cmd.equals("up")) {
            if (row - 1 < 0) {
                if (!matrix[matrix.length - 1][col].equals("s")) {
                    matrix[matrix.length - 1][col] = "f";
                } else {
                    matrix[matrix.length - 1][col] = "x";
                    return false;
                }
            } else {
                if (!matrix[row - 1][col].equals("s")) {
                    matrix[row - 1][col] = "f";
                } else {
                    matrix[row - 1][col] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("down")) {
            if (row + 1 > matrix.length - 1) {
                if (!matrix[0][col].equals("s")) {
                    matrix[0][col] = "f";

                } else {
                    matrix[0][col] = "x";
                    return false;
                }
            } else {
                if (!matrix[row + 1][col].equals("s")) {
                    matrix[row + 1][col] = "f";
                } else {
                    matrix[row + 1][col] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("left")) {
            if (col - 1 < 0) {
                if (!matrix[row][matrix[row].length - 1].equals("s")) {
                    matrix[row][matrix[row].length - 1] = "f";
                } else {
                    matrix[row][matrix[row].length - 1] = "x";
                    return false;
                }
            } else {
                if (!matrix[row][col - 1].equals("s")) {
                    matrix[row][col - 1] = "f";
                } else {
                    matrix[row][col - 1] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("right")) {
            if (col + 1 > matrix[row].length - 1) {
                if (!matrix[row][0].equals("s")) {
                    matrix[row][0] = "f";
                } else {
                    matrix[row][0] = "x";
                    return false;
                }
            } else {
                if (!matrix[row][col + 1].equals("s")) {
                    matrix[row][col + 1] = "f";
                } else {
                    matrix[row][col + 1] = "x";
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean moveSecondPlayer(String[][] matrix, String cmd, int row, int col) {

        if (cmd.equals("up")) {
            if (row - 1 < 0) {
                if (!matrix[matrix.length - 1][col].equals("f")) {
                    matrix[matrix.length - 1][col] = "s";
                } else {
                    matrix[matrix.length - 1][col] = "x";
                    return false;
                }
            } else {
                if (!matrix[row - 1][col].equals("f")) {
                    matrix[row - 1][col] = "s";
                } else {
                    matrix[row - 1][col] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("down")) {
            if (row + 1 > matrix.length - 1) {
                if (!matrix[0][col].equals("f")) {
                    matrix[0][col] = "s";

                } else {
                    matrix[0][col] = "x";
                    return false;
                }
            } else {
                if (!matrix[row + 1][col].equals("f")) {
                    matrix[row + 1][col] = "s";
                } else {
                    matrix[row + 1][col] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("left")) {
            if (col - 1 < 0) {
                if (!matrix[row][matrix[row].length - 1].equals("f")) {
                    matrix[row][matrix[row].length - 1] = "s";
                } else {
                    matrix[row][matrix[row].length - 1] = "x";
                    return false;
                }
            } else {
                if (!matrix[row][col - 1].equals("f")) {
                    matrix[row][col - 1] = "s";
                } else {
                    matrix[row][col - 1] = "x";
                    return false;
                }
            }
        } else if (cmd.equals("right")) {
            if (col + 1 > matrix[row].length - 1) {
                if (!matrix[row][0].equals("f")) {
                    matrix[row][0] = "s";
                } else {
                    matrix[row][0] = "x";
                    return false;
                }
            } else {
                if (!matrix[row][col + 1].equals("f")) {
                    matrix[row][col + 1] = "s";
                } else {
                    matrix[row][col + 1] = "x";
                    return false;
                }
            }
        }
        return true;
    }

    private static int updateRow(String cmd, int row, String[][] matrix) {
        if (cmd.equals("up")) {
            if (row - 1 < 0) {
                return matrix.length - 1;
            } else {
                return --row;
            }
        } else {
            if (row + 1 > matrix.length - 1) {
                return 0;
            } else {
                return ++row;
            }
        }
    }
    private static int updateCol(String cmd, int col, String[][] matrix){
        if (cmd.equals("left")) {
            if (col - 1 < 0) {
                return matrix[0].length - 1;
            } else {
                return --col;
            }
        } else {
            if (col + 1 > matrix[0].length - 1) {
                return 0;
            } else {
                return ++col;
            }
        }
    }
}
