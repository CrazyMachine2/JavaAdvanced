import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Double[]> gradesByStudent = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            String[] grades = scan.nextLine().split(" ");
            Double[] scores = new Double[grades.length];

            for (int j = 0; j < grades.length; j++) {
                scores[j] = Double.parseDouble(grades[j]);
            }
            gradesByStudent.put(name,scores);

        }
        for (Map.Entry<String,Double[]> entry : gradesByStudent.entrySet()){
            System.out.printf("%s is graduated with ",entry.getKey());
            double sum = 0;
            for (Double grade : entry.getValue()){
                sum += grade;
            }
            double avg = sum / entry.getValue().length;
            DecimalFormat df = new DecimalFormat("#.########################");
            System.out.printf("%s%n",df.format(avg));
        }
    }
}
