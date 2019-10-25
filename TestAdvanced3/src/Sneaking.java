import java.util.Scanner;

public class Sneaking {

    public static int
    samRow,samCol,nikRow;

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int dimension = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < input.length; j++) {
                if(input[j].equals("N")){
                    nikRow = i;
                }
                if (input[j].equals("S")){
                    samRow = i;
                    samCol = j;
                }
                matrix[i] = input;
            }
        }

        String cmdArgs = scan.nextLine();
        boolean hasWon = false;

        for (int i = 0; i < cmdArgs.length(); i++) {

            while (!hasWon){

                if (!isSamAlive(matrix,samRow,samCol)){
                    printEnd(matrix,hasWon,samRow,samCol);
                    return;
                }

                if(moveSam(matrix,samRow,samCol,nikRow,cmdArgs.charAt(i))){
                    if (cmdArgs.charAt(i) == 'U' || cmdArgs.charAt(i) == 'D'){
                        samRow = getCoordinates(cmdArgs.charAt(i),samRow,samCol);
                    } else if (cmdArgs.charAt(i) == 'R' || cmdArgs.charAt(i) == 'L'){
                        samCol = getCoordinates(cmdArgs.charAt(i),samRow,samCol);
                    }

                    if (samRow == nikRow){
                        hasWon = true;
                        printEnd(matrix,hasWon,samRow,samCol);
                    }

                } else {
                    if (cmdArgs.charAt(i) == 'U' || cmdArgs.charAt(i) == 'D'){
                        samRow = getCoordinates(cmdArgs.charAt(i),samRow,samCol);
                    } else if (cmdArgs.charAt(i) == 'R' || cmdArgs.charAt(i) == 'L'){
                        samCol = getCoordinates(cmdArgs.charAt(i),samRow,samCol);
                    }

                    printEnd(matrix,hasWon,samRow,samCol);
                    return;
                }
            }
        }

    }

    private static int getCoordinates(char cmd, int samRow, int samCol) {
        if (cmd == 'U') {
            return samRow - 1;
        } else if (cmd == 'D'){
            return samRow + 1;
        } else if (cmd == 'L'){
            return samCol - 1;
        } else {
            return samCol + 1;
        }
    }

    private static boolean moveSam(String[][] matrix, int samRow, int samCol, int nikRow,char cmd) {

        if(cmd == 'U'){
            if (matrix[samRow - 1][samCol].equals("d") || matrix[samRow - 1][samCol].equals("b")){
                matrix[samRow - 1][samCol] = "S";
                matrix[samRow][samCol] = ".";
            } else {
                for (int i = 0; i < matrix[samCol].length; i++) {
                    if(matrix[samRow][i].equals("b")){
                        if (i < samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                    if(matrix[samRow][i].equals("d")){
                        if (i > samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                }
                matrix[samRow - 1][samCol] = "S";
                matrix[samRow][samCol] = ".";
            }
        } else if (cmd == 'D'){
            if (matrix[samRow + 1][samCol].equals("d") || matrix[samRow + 1][samCol].equals("b")){
                matrix[samRow + 1][samCol] = "S";
                matrix[samRow][samCol] = ".";
            } else {
                for (int i = 0; i < matrix[samCol].length; i++) {
                    if(matrix[samRow][i].equals("b")){
                        if (i < samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                    if(matrix[samRow][i].equals("d")){
                        if (i > samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                }
                matrix[samRow + 1][samCol] = "S";
                matrix[samRow][samCol] = ".";
            }
        } else if (cmd == 'L'){
            if (matrix[samRow ][samCol - 1].equals("d") || matrix[samRow][samCol - 1].equals("b")){
                matrix[samRow][samCol - 1] = "S";
                matrix[samRow][samCol] = ".";
            } else {
                for (int i = 0; i < matrix[samCol].length; i++) {
                    if(matrix[samRow][i].equals("b")){
                        if (i < samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                    if(matrix[samRow][i].equals("d")){
                        if (i > samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                }
                matrix[samRow][samCol - 1] = "S";
                matrix[samRow][samCol] = ".";
            }
        } else if (cmd == 'R'){
            if (matrix[samRow][samCol + 1].equals("d") || matrix[samRow][samCol + 1].equals("b")){
                matrix[samRow][samCol + 1] = "S";
                matrix[samRow][samCol] = ".";
            } else  {
                for (int i = 0; i < matrix[samCol].length; i++) {
                    if(matrix[samRow][i].equals("b")){
                        if (i < samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                    if(matrix[samRow][i].equals("d")){
                        if (i > samCol){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                    }
                }
                matrix[samRow][samCol + 1] = "S";
                matrix[samRow][samCol] = ".";
            }
        }

        return true;
    }

    private static void printEnd(String[][] matrix, boolean hasWon, int samRow, int samCol) {
        if (!hasWon){
            System.out.printf("Sam died at %d, %d%n",samRow,samCol);
            printMatrix(matrix);
        } else {
            System.out.println("Nikoladze killed!");
            printMatrix(matrix);
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

    private static boolean isSamAlive(String[][] matrix, int samRow,int samCol) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("d")){
                    if(j - 1 < 0){
                        matrix[i][j] = "b";
                        if(samRow == i){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                        break;
                    } else {
                        matrix[i][j] = ".";
                        matrix[i][j - 1] = "d";
                        break;
                    }

                } else if (matrix[i][j].equals("b")){
                    if(j + 1 > matrix[i].length - 1){
                        matrix[i][j] = "d";
                        if(samRow == i){
                            matrix[samRow][samCol] = "X";
                            return false;
                        }
                        break;
                    } else {
                        matrix[i][j] = ".";
                        matrix[i][j + 1] = "b";
                        break;
                    }
                }
            }
        }
        return true;
    }
}
