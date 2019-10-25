import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvenOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int lower = numbers[0];
        int upper = numbers[1];
        int num = 0;

        String condition = scan.nextLine();
        Predicate<Integer> tester = createTester(num,condition);
        for (int i = lower; i <= upper ; i++) {
            num = i;
            if (tester.test(Math.abs(num))){
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createTester(int number, String condition) {
        switch (condition){
            case "even":
                return x -> x %2 == 0;
        }
        return x -> x %2 == 1;
    }
}
