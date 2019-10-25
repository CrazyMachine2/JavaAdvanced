import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        int round = 1;

        while (children.size() > 1) {

            for (int i = 0; i < n - 1; i++) {
                String removed = children.poll();
                children.offer(removed);
            }

            if(isPrime(round)){
                String peeked = children.peek();
                System.out.printf("Prime %s%n", peeked);
            } else {
                String removed = children.poll();
                System.out.printf("Removed %s%n", removed);
            }

            round++;
        }
        System.out.printf("Last is %s%n", children.poll());
    }

    private static boolean isPrime(int round) {

        if (round == 1) {
            return false;
        }

        for (int i = 2; i < round; i++){
            if (round % i == 0){
                return false;
            }
        }
        return true;
    }


}




