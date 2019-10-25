import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        List<String> evenNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(x -> x %2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));

        if (!evenNumbers.isEmpty()){
            List<String> sortedNumbers = evenNumbers.stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            System.out.println(String.join(", ", sortedNumbers));
        }
    }
}
