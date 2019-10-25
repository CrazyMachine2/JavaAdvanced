import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        int[] firstPlayerCards = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondPlayerCards = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (Integer card : firstPlayerCards) {
            firstPlayer.add(card);
        }

        for (Integer card : secondPlayerCards) {
            secondPlayer.add(card);
        }

        int count = 1;

        for (int i = 0; i < 50; i++) {

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
            count++;
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else{
            System.out.println("Draw!");
        }
    }
}
