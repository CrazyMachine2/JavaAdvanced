import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CountCharacterType {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\input.txt";
        String outputFilename = basePath + "\\01output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        List<Character> vowels =Arrays.asList('a','o','u','e','i');
        List<Character> punctuation =Arrays.asList('.',',','!','?');

        int vowelCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        try {
            reader = new BufferedReader(new FileReader(inputFilename));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String line = reader.readLine();

            while (line != null){
                for (char c : line.toCharArray()){
                    if (c == ' '){
                        continue;
                    } else {
                        if (vowels.contains(c)){
                            vowelCount++;
                        } else if (punctuation.contains(c)){
                            punctuationCount++;
                        } else {
                            consonantCount++;
                        }
                    }
                }
                line = reader.readLine();
            }
            writer.printf("Vowels: %d%n",vowelCount);
            writer.printf("Consonants: %d%n",consonantCount);
            writer.printf("Punctuation: %d",punctuationCount);

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
