import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBraclet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();
        Deque<Integer> brackets = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                brackets.push(i);
            } else if (symbol == ')') {
                int startIndex = brackets.pop();
                String contents = expression.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}