import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Function<String,Integer> parse = Integer::parseInt;
        String[] nums = scan.nextLine().split(", ");

        List<Integer> numbers = new ArrayList<>();

        for (String number : nums) {
            int n = parse.apply(number);
            numbers.add(n);
        }

        System.out.printf("Count = %d%n",numbers.size());

        int sum = numbers.stream().reduce(0,(a,b) -> a + b);
        System.out.printf("Sum = %d",sum);
    }
}
