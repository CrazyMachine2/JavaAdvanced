import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> recourses = new LinkedHashMap<>();

        while (true) {
            String recourse = scan.nextLine();

            if (recourse.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scan.nextLine());

            if (!recourses.containsKey(recourse)) {
                recourses.put(recourse, quantity);
            } else {
                recourses.put(recourse, recourses.get(recourse) + quantity);
            }
        }

        recourses.entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
