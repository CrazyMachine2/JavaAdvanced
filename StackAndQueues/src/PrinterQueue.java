import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        while (true){
            String input = scan.nextLine();

            if (input.equals("print")){
                break;
            }

            if (input.equals("cancel")){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    String canceled = queue.pollFirst();
                    System.out.printf("Canceled %s%n",canceled);
                }
            } else {
                queue.offer(input);
            }
        }

        while (!queue.isEmpty()){
            System.out.println(queue.pollFirst());
        }
    }
}
