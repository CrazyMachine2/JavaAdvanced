import java.util.*;

public class ProductStore2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> productsByStore = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Revision")) {
                break;
            }
            String[] data = input.split(", ");
            String store = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!productsByStore.containsKey(store)) {
                productsByStore.put(store, new LinkedHashMap<>());
            }
            productsByStore.get(store).put(product, price);

        }

        for (Map.Entry<String, Map<String, Double>> entry : productsByStore.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> entry1 : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry1.getKey(), entry1.getValue());
            }
        }
    }
}
