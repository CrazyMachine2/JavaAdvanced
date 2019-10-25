import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '{' || symbol == '(' || symbol == '['){
                stack.push(symbol);
            } else if (symbol == '}'){
                if (stack.isEmpty() || stack.pop() != '{'){
                    System.out.println("NO");
                    return;
                }
            } else if (symbol == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    System.out.println("NO");
                    return;
                }
            }else if (symbol == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
