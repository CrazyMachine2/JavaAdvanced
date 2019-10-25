import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("PARTY")) {
                break;
            }

            guests.add(input);
        }

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            if (guests.contains(input)) {
                guests.remove(input);
            }
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}
