import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedAritmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<Integer> print = x -> System.out.print(x + " ");

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }

            if (input.equals("print")) {
                numbers.forEach(print);
                System.out.println();
            } else {
                Function<Integer, Integer> applyOperation = getTypeOfOperation(input);
                numbers = numbers.stream().map(applyOperation).collect(Collectors.toList());
            }
        }
    }

    private static Function<Integer, Integer> getTypeOfOperation(String input) {
        if (input.equals("add")) {
            return x -> x + 1;
        } else if (input.equals("multiply")) {
            return x -> x * 2;
        } else {
            return x -> x - 1;
        }
    }
}