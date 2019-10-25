import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<List<String>> matrix = new ArrayList<>();
        fillMatrix(matrix, scan);

        String[] cmd = scan.nextLine().split(" ");
        String header = cmd[1];
        int indexOfHeader = matrix.get(0).indexOf(header);

        if (cmd[0].equals("hide")) {
            hideColumn(matrix, indexOfHeader);
        } else if (cmd[0].equals("sort")) {
            matrix = sortMatrix(matrix, indexOfHeader, header);

        } else {
            filterMatrix(matrix, indexOfHeader, cmd);
        }
        printMatrix(matrix);
    }

    private static void filterMatrix(List<List<String>> matrix, int indexOfHeader, String[] cmd) {
        String value = cmd[2];
        List<String> headerList = new ArrayList<>(matrix.get(0));
        matrix.removeIf(list -> !list.get(indexOfHeader).equals(value));
        matrix.add(0, headerList);
    }

    private static List<List<String>> sortMatrix(List<List<String>> matrix, int indexOfHeader, String header) {
        List<String> sorted = new ArrayList<>();

        for (int i = 1; i < matrix.size(); i++) {
            sorted.add(matrix.get(i).get(indexOfHeader));
        }

        sorted.sort(String::compareTo);

        List<List<String>> matrix2 = new ArrayList<>();
        matrix2.add(matrix.get(0));
        int length = matrix.size();
        while (true) {

            if (matrix2.size() == length) {
                break;
            }

            for (int i = 1; i < matrix.size(); i++) {
                if (matrix.get(i).get(indexOfHeader).equals(sorted.get(0))) {
                    matrix2.add(matrix.get(i));
                    matrix.remove(i);
                    sorted.remove(0);
                    break;
                }
            }
        }
        return matrix2;
    }


    private static void hideColumn(List<List<String>> matrix, int indexOfHeader) {
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).remove(indexOfHeader);
        }
    }

    private static void printMatrix(List<List<String>> matrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (j == matrix.get(i).size() - 1) {
                    sb.append(matrix.get(i).get(j));
                } else {
                    sb.append(matrix.get(i).get(j) + " | ");
                }

            }
            sb.append("\r\n");
        }
        System.out.println(sb);
    }

    private static void fillMatrix(List<List<String>> matrix, Scanner scan) {
        int rows = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            String[] input = scan.nextLine().split(", ");
            for (int j = 0; j < input.length; j++) {
                matrix.get(i).add(input[j]);
            }
        }
    }
}

