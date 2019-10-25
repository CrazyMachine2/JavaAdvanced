import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbers = scan.nextLine().split(" ");
        int n1 = Integer.parseInt(numbers[0]);
        int n2 = Integer.parseInt(numbers[1]);

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < n1; i++) {
            int n = Integer.parseInt(scan.nextLine());
            set1.add(n);
        }

        for (int i = 0; i < n2; i++) {
            int n = Integer.parseInt(scan.nextLine());
            set2.add(n);
        }

        if (n1 >= n2) {
            for (Integer integer : set1) {
                if (set2.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        } else {
            for (Integer integer : set2) {
                if (set1.contains(integer)) {
                    System.out.print(integer + " ");
                }
            }
        }
    }
}
