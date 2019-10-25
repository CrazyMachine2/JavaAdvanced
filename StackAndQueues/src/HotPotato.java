import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        String [] names = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children,names);

        while (children.size() > 1){
            for (int i = 0; i < n - 1; i++) {
                String removed = children.poll();
                children.offer(removed);
            }
            String removed = children.poll();
            System.out.printf("Removed %s%n", removed);
        }
        System.out.printf("Last is %s%n", children.poll());
    }
}
