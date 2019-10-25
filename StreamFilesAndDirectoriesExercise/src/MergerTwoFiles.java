import java.io.*;

public class MergerTwoFiles {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename1 = basePath + "\\inputOne.txt";
        String inputFilename2 = basePath + "\\inputTwo.txt";
        String outputFilename = basePath + "\\01output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilename1));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String line = reader.readLine();

            while (line != null){
                writer.println(line);
                line = reader.readLine();
            }

            reader = new BufferedReader(new FileReader(inputFilename2));
            String line2 = reader.readLine();

            while (line2 != null){
                writer.println(line2);
                line2 = reader.readLine();
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
