import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BiPredicate<String,Integer> shorter = (name,limit) -> name.length() <= limit;

        int n = Integer.parseInt(scan.nextLine());
        //Predicate<String> isShorter = name -> name.length() <= n;

        Arrays.stream(scan.nextLine().split(" "))
                .filter(x -> shorter.test(x,n))
                .forEach(System.out::println);

    }
}
