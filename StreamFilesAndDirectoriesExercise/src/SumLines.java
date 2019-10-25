import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JavaSoftuni\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputFilename = basePath + "\\input.txt";
        String outputFilename = basePath + "\\01output.txt";

        BufferedReader bf = null;
        PrintWriter writer = null;

        long sum = 0;
        try {
            bf = new BufferedReader(new FileReader(inputFilename));
            writer = new PrintWriter(new FileWriter(outputFilename));

            String line = bf.readLine();

            while (line != null){

                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                line = bf.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null){
                bf.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}
