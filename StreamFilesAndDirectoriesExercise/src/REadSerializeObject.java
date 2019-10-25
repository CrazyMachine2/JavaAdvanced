import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class REadSerializeObject {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\list.ser";

        try {
            FileInputStream inputStream = new FileInputStream(inputFilename);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            java.util.List<Double> list = (java.util.ArrayList<Double>) objectInputStream.readObject();

            for (Double number : list) {
                System.out.println(number);
            }
          objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
