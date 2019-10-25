import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        List<Character> punctuation = Arrays.asList('.', ',', '!', '?');

        try {
            inputStream = new FileInputStream(inputPath);
            outputStream = new  FileOutputStream(outputPath);

            int oneByte = inputStream.read();

            while(oneByte >= 0){
                if(!punctuation.contains((char) oneByte)){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }

        }
    }
}
