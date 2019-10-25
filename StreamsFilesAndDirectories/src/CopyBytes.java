import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\03.CopyBytesOutput.txt";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(inputPath);
            outputStream = new FileOutputStream(outputPath);

            int oneByte = inputStream.read();

            while (oneByte >= 0) {

                if (oneByte == ' ' || oneByte == '\n') {
                 outputStream.write(oneByte);

                } else {
                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
