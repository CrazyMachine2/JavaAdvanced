import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        List<Integer> pairs = new ArrayList<>();

        int[] leftSocks = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] rightSocks = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (Integer n : leftSocks){
            left.push(n);
        }

        for (Integer n : rightSocks){
            right.offer(n);
        }

       while (true){

           if (right.isEmpty() || left.isEmpty()){
               break;
           }

           if(left.peek() == right.peek()){
               right.poll();
               int updated = left.pop() + 1;
               left.push(updated);

           } else if (left.peek() < right.peek()){
               left.pop();

           } else if (left.peek() > right.peek()){
               int pair = left.pop() + right.poll();
               pairs.add(pair);
           }
       }

        System.out.println(Collections.max(pairs));
       pairs.forEach(p -> System.out.print(p + " "));
    }
}
