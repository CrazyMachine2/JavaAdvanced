import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.putIfAbsent(name, age);
        }

        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> isOlder = number -> number >= age;
        Consumer<String> print = System.out::println;

        people = filterPeople (people,isOlder,condition);
        printIt(people,print,format);

    }

    private static Map<String, Integer> filterPeople(Map<String, Integer> people, Predicate<Integer> isOlder, String condition) {
        Map<String, Integer> filteredPeople = new LinkedHashMap<>();
        if (condition.equals("older")) {

            for (Map.Entry<String, Integer> entry : people.entrySet()) {
                if (isOlder.test(entry.getValue())) {
                    filteredPeople.put(entry.getKey(), entry.getValue());
                }
            }
        } else {
            for (Map.Entry<String, Integer> entry : people.entrySet()) {
                if (!isOlder.test(entry.getValue())) {
                    filteredPeople.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return filteredPeople;
    }

    private static void printIt(Map<String, Integer> people, Consumer<String> print, String format) {
        String message = "";
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (format.equals("age")){
                message = "" + entry.getValue();
                print.accept(message);
            } else if (format.equals("name")){
                message = entry.getKey();
                print.accept(message);
            } else {
                message = entry.getKey() + " - " + entry.getValue();
                print.accept(message);
            }
        }
    }
}
