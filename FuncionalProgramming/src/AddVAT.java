import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> prices = Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        UnaryOperator<Double> addVat = value -> value * 1.2;

        System.out.println("Prices with VAT:");

        prices.forEach(v -> {
            System.out.printf("%.2f%n",addVat.apply(v));
        });

    }
}
