import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String outputFilename = basePath + "\\list.ser";

        java.util.List<Double> list = new java.util.ArrayList<>();
        list.add(433.514);
        list.add(233.154);
        list.add(1433.144);
        list.add(3413.124);
        list.add(323.414);

        try {
            FileOutputStream outputStream = new FileOutputStream(outputFilename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
