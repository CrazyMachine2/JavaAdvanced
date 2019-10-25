import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.Arrays.*;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<int [],Integer> min = x -> {
            sort(x);
            return x[0];
        };

        int[] numbers = stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minNumber = min.apply(numbers);
        System.out.println(minNumber);

    }
}
