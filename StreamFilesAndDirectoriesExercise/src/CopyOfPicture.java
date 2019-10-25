import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyOfPicture {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\Java-logo.jpg";
        String outputFilename = basePath + "\\copy-java.jpg";


        try {
            FileInputStream inputStream = new FileInputStream(inputFilename);
            byte[] buffer = inputStream.readAllBytes();

            FileOutputStream outputStream = new FileOutputStream(outputFilename);
            outputStream.write(buffer);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
