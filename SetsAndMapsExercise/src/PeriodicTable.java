import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] chemicals = scan.nextLine().split(" ");
            for (String chemical : chemicals) {
                elements.add(chemical);
            }
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
