import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> productsByStore = new TreeMap<>();
        Map<String, Double> productsByPrice = new HashMap<>();


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
                productsByStore.put(store, new ArrayList<>());
            }
            productsByStore.get(store).add(product);
            productsByPrice.put(product, price);

        }

        for (Map.Entry<String, List<String>> entry : productsByStore.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (String product : entry.getValue()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, productsByPrice.get(product));
            }
        }
    }
}
