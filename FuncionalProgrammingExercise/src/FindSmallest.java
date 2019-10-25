import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<List<Integer>,Integer> minIndex = FindSmallest::findMin;

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(minIndex.apply(numbers));

    }

    private static Integer findMin(List<Integer> list) {
        int minNum = Integer.MAX_VALUE;
        int indexOf = 0;
        for (Integer num : list) {
            if (num <= minNum) {
                minNum = num;
                indexOf = list.lastIndexOf(num);
            }
        }
        return indexOf;
    }
}