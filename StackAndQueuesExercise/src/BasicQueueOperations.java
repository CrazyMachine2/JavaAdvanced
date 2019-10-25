import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] operations = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int remove = operations[1];
        int number = operations[2];

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> numbersQueue = new ArrayDeque<>();

        for (Integer num : numbers) {
            numbersQueue.offer(num);
        }

        for (int i = 0; i < remove; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.contains(number)) {
            System.out.println("true");
        } else {
            if (numbersQueue.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(numbersQueue));
            }
        }
    }
}
