import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BiPredicate<String, String> startsWith = (name, letter) -> name.startsWith(letter);
        BiPredicate<String, String> endsWith = (name, letter) -> name.endsWith(letter);
        BiPredicate<String, Integer> hasLength = (name, length) -> name.length() == length;


        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> doubleNames = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("Party!")) {
                break;
            }

            String[] commands = input.split("\\s+");

            if (commands[0].equals("Remove")) {
                if (commands[1].equals("StartsWith")) {
                    String letter = commands[2];
                    guests = guests.stream().filter(g -> !startsWith.test(g, letter)).collect(Collectors.toList());

                } else if (commands[1].equals("EndsWith")) {
                    String letter = commands[2];
                    guests = guests.stream().filter(g -> !endsWith.test(g, letter)).collect(Collectors.toList());

                } else {
                    int length = Integer.parseInt(commands[2]);
                    guests = guests.stream().filter(g -> !hasLength.test(g, length)).collect(Collectors.toList());
                }
            } else {
                if (commands[1].equals("StartsWith")) {
                    String letter = commands[2];
                    doubleNames = guests.stream().filter(g -> startsWith.test(g, letter)).collect(Collectors.toList());
                    if (!doubleNames.isEmpty()) {
                        guests.addAll(doubleNames);
                    }

                } else if (commands[1].equals("EndsWith")) {
                    String letter = commands[2];
                    doubleNames = guests.stream().filter(g -> endsWith.test(g, letter)).collect(Collectors.toList());
                    if (!doubleNames.isEmpty()) {
                        guests.addAll(doubleNames);
                    }
                } else {
                    int length = Integer.parseInt(commands[2]);
                    doubleNames = guests.stream().filter(g -> hasLength.test(g, length)).collect(Collectors.toList());
                    if (!doubleNames.isEmpty()) {
                        guests.addAll(doubleNames);
                    }
                }
            }
        }

        if (!guests.isEmpty()) {
            guests.sort(String::compareTo);
            System.out.printf("%s are going to the party!", String.join(", ", guests));
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
