import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename1 = basePath + "\\words.txt";
        String inputFilename2 = basePath + "\\text.txt";
        String outputFilename = basePath + "\\result.txt";

        Path inputPath1 = Paths.get(inputFilename1);

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilename2));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String text = Files.readString(inputPath1);
            String[] words = text.split(" ");

            String line = reader.readLine();

            int countOf = 0;
            int countWhich = 0;
            int countThe = 0;

            while (line != null){
                String[] lineWords = line.split(" ");

                for (String word : lineWords) {
                    if (word.equals(words[0])){
                        countOf++;
                    } else if (word.equals(words[1])){
                        countWhich++;
                    } else if (word.equals(words[2])){
                        countThe++;
                    }
                }
                line = reader.readLine();
            }
            writer.printf("%s - %d%n",words[0], countOf);
            writer.printf("%s - %d%n",words[1], countWhich);
            writer.printf("%s - %d%n",words[2], countThe);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                reader.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}
