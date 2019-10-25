import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFilename = basePath + "\\newInput.txt";
        String outputFilename = basePath + "\\06.SortLinesOutput.txt";

        Path inputPath = Paths.get(inputFilename);
        Path outputPath = Paths.get(outputFilename);

        try {
            List<String> allLines = Files.readAllLines(inputPath);
            Collections.sort(allLines);
            Files.write(outputPath,allLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
