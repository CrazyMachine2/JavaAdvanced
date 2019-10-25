import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numbersOfCommands = Integer.parseInt(scan.nextLine());
        StringBuilder text = new StringBuilder();

        Deque<String> mainHistory = new ArrayDeque<>();
        Deque<Integer> historyOfCommands = new ArrayDeque<>();

        for (int i = 0; i < numbersOfCommands; i++) {
            String[] cmd = scan.nextLine().split(" ");

            if (cmd[0].equals("1")) {
                String input = cmd[1];

                text.append(input);
                mainHistory.push(input);
                historyOfCommands.push(1);

            } else if (cmd[0].equals("2")) {
                int count = Integer.parseInt(cmd[1]);

                //TODO: If text is empty
                if (count >= text.length()) {
                    String undo = text.substring(0, text.length());
                    mainHistory.push(undo);
                    text.delete(0, text.length());
                    historyOfCommands.push(2);
                } else {
                    String undo = text.substring(text.length() - count, text.length());
                    mainHistory.push(undo);
                    text.delete(text.length() - count, text.length());
                    historyOfCommands.push(2);
                }

            } else if (cmd[0].equals("3")) {
                int index = Integer.parseInt(cmd[1]);

                char symbol = text.charAt(index - 1);
                System.out.println(symbol);

            } else {
                int numberCommand = historyOfCommands.pop();

                if (numberCommand == 1) {
                    String undone = mainHistory.pop();
                    text.delete(text.length() - undone.length(), text.length());
                } else {
                    String undone = mainHistory.pop();
                    text.append(undone);
                }
            }
        }
    }
}
