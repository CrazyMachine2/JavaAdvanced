import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scan.nextLine());
        Deque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {

            String cmd = scan.nextLine();

            if (cmd.equals("3")) {
              //  int max = getMax(numbers);
                // System.out.println(max);
                System.out.println(Collections.max(numbers));

            } else if (cmd.equals("2")) {
                if (!numbers.isEmpty()) {
                    numbers.pop();
                }

            } else {
                String[] data = cmd.split("\\s+");
                int number = Integer.parseInt(data[1]);
                numbers.push(number);
            }
        }
    }

    private static int getMax(Deque numbers) {
        int max = Integer.MIN_VALUE;

        if (numbers.isEmpty()) {
            return 0;
        }

        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            int num = (int) numbers.pop();
            if (num > max) {
                max = num;
            }
            numbers.offer(num);
        }
        return max;
    }
}
