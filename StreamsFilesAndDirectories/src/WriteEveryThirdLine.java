import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader bf = null;
        PrintWriter writer = null;
        int row = 1;
        try {
            bf = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(new FileWriter(outputPath));

            String line = bf.readLine();

            while (line != null){
                if (row %3 == 0){
                    writer.println(line);
                }
                row++;
                line = bf.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null){
                bf.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}
