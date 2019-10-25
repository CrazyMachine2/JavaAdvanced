import java.util.*;

public class AverageStudentGrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> studentByGrades = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentByGrades.containsKey(name)){
                studentByGrades.put(name,new ArrayList<>());
                studentByGrades.get(name).add(grade);
            } else {
                studentByGrades.get(name).add(grade);
            }

        }

        for (Map.Entry<String,List<Double>> entry : studentByGrades.entrySet()){
            double sum = 0;

            System.out.printf("%s -> ",entry.getKey());
            for(Double grade : entry.getValue()){
                sum += grade;
                System.out.printf("%.2f ",grade);
            }
            double avg = sum / entry.getValue().size();
            System.out.printf("(avg: %.2f)%n",avg);

        }
    }
}
