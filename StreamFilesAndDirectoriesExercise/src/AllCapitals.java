import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\input.txt";
        String outputFilename = basePath + "\\01output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilename));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String line = reader.readLine();

            while (line != null){
                writer.println(line.toUpperCase());
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
