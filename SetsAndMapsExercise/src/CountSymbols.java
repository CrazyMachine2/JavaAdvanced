import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character, Integer> symbols = new TreeMap<>();

        String text = scan.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (!symbols.containsKey(symbol)) {
                symbols.put(symbol, 1);
            } else {
                symbols.put(symbol, symbols.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}
