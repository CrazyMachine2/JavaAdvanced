import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        String outputFilename = basePath + "\\01output.txt";

        File folderToRead = new File(basePath);
        PrintWriter writer = null;

        long sum = Arrays.stream(folderToRead.listFiles()).filter(e -> e.isFile())
                .mapToLong(e -> e.length())
                .sum();

        int sum1 = 0;

        for (File file : folderToRead.listFiles()){
            if (file.isFile()){
                sum1 += file.length();
            }
        }

        System.out.println(sum1);


    }
}
