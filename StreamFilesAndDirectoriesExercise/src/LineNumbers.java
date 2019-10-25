import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\inputLineNumbers.txt";
        String outputFilename = basePath + "\\01output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilename));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String line = reader.readLine();
            int countLine = 1;

            while (line != null){
               writer.printf("%d. %s%n",countLine++,line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                reader.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}
