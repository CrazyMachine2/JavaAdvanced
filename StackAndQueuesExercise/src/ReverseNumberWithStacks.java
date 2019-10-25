import java.util.*;

public class ReverseNumberWithStacks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> numbers = new ArrayDeque<>();


        for (Integer num: nums) {
            numbers.push(num);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(numbers.pop() + " ");
        }

    }
}
