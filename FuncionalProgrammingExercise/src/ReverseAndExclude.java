import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<List<Integer>, List<Integer>> reverse = list -> {
            for (int i = 0; i < list.size() / 2; i++) {
                int temp = list.get(i);
                list.set(i, list.get(list.size() - 1 - i));
                list.set(list.size() - 1 - i, temp);
            }
            return list;
        };

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int num = Integer.parseInt(scan.nextLine());
        Predicate<Integer> notDivisible = x -> x % num != 0;

        reverse.apply(numbers).stream()
                .filter(notDivisible)
                .forEach(x -> System.out.print(x + " "));

    }
}

