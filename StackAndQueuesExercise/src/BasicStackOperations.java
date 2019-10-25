import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //reading first input of operations N,S,X
        int[] operations = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int pop = operations[1];
        int number = operations[2];

        //reading second line of numbers
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> stackNumbers = new ArrayDeque<>();

        //pushing the numbers into the stack
        for (Integer num : numbers) {
            stackNumbers.push(num);
        }

        //popping N times from the stack (pop operation)
        for (int i = 0; i < pop; i++) {
            stackNumbers.pop();
        }

        //checking if the stack contains the searched number (N), if not searching for the min value of the stack
        if (stackNumbers.contains(number)) {
            System.out.println("true");
        } else {
            if (stackNumbers.isEmpty()){
                System.out.println("0");
            } else {
                System.out.println(Collections.min(stackNumbers));
            }

//            if (stackNumbers.isEmpty()){
//                System.out.println("0");
//                return;
//            }
//
//            int min = Integer.MAX_VALUE;
//
//            while (!stackNumbers.isEmpty()) {
//                int popped = stackNumbers.pop();
//                if (popped < min) {
//                    min = popped;
//                }
//            }
//            System.out.println(min);

        }
    }
}
