import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ListFiles {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFilename = basePath + "\\Files-and-Streams";
        String outputFilename = basePath + "\\output.txt";

        File folderToread = new File(inputFilename);
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(outputFilename));

            File[] files = folderToread.listFiles();
            for (File file : files) {
                if (!file.isDirectory()){
                    writer.printf("%s: [%d]%n",file.getName(),file.length());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}
