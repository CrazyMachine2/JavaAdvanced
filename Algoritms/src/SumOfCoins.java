import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String coinsLine = scan.nextLine();
        Map<Integer,Integer> coinUsage = new LinkedHashMap<>();

       Arrays.stream(coinsLine.replaceAll("Coins: ", "")
                .split(", "))
                .map(Integer::parseInt)
                .sorted((a,b) -> Integer.compare(b,a))
                .forEach((num) -> coinUsage.put(num,0));

        int sum = Integer.parseInt(scan.nextLine().split(": ")[1]);
        int totalCount = 0;

        for (Integer coinValue : coinUsage.keySet()) {
            int count = sum / coinValue;
            coinUsage.replace(coinValue, count);

            totalCount += count;
            sum -= count * coinValue;
        }

        if (sum != 0) {
            System.out.println("Error");
            return;
        }

        System.out.println("Number of coins to take: " + totalCount);
        coinUsage.entrySet().stream()
                .filter((entry) -> entry.getValue() != 0)
                .forEach((entry) -> {
            System.out.println(entry.getValue() + " coin(s) with value " + entry.getKey());
        });
    }
}
