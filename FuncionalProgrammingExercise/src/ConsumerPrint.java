import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Consumer<String> print = System.out::println;

        Arrays.stream(scan.nextLine().split(" "))
                .forEach(print);
    }
}
