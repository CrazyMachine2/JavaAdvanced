import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class NestedFolders {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputFilename = basePath + "\\Files-and-Streams";
        String outputFilename = basePath + "\\output.txt";

        File folderToRead = new File(inputFilename);
        PrintWriter writer = null;
        int folderCount = 0;

        try {
            writer = new PrintWriter(new FileWriter(outputFilename));

            ArrayDeque<File> filesToTraverse = new ArrayDeque<>(Arrays.asList(folderToRead));

            while(!filesToTraverse.isEmpty()){
                File currentFile = filesToTraverse.poll();
                if (currentFile.isDirectory()){
                    folderCount++;
                    filesToTraverse.addAll(Arrays.asList(currentFile.listFiles()));
                    writer.println(currentFile.getName());
                }
            }
            writer.println(folderCount + " " + "folders");



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}
