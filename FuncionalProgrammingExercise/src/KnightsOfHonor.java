import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<String> print = x -> System.out.printf("Sir %s%n", x);

        Arrays.stream(scan.nextLine().split(" "))
                .forEach(print);
    }
}
