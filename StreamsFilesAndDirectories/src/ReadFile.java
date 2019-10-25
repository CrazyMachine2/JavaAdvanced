import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream input = null;

        try {
            input = new FileInputStream(path);

            int oneByte = input.read();

            while(oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = input.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
