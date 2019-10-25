import java.io.*;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04.ExtractIntegersOutput.txt";

        Scanner scan = null;
        PrintWriter writer = null;

        try {
            scan = new Scanner(new FileInputStream(inputPath));
            writer = new PrintWriter(outputPath);

            while (scan.hasNext()){
                if (scan.hasNextInt()){
                    writer.println(scan.nextInt());
                }
                scan.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scan != null){
                scan.close();
            }
            if (writer != null){
                writer.close();
            }
        }


    }
}
