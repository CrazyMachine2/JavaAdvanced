import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> cars = new HashSet<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            String[] data = input.split(", ");

            if (data[0].equals("IN")) {
                cars.add(data[1]);
            } else {
                cars.remove(data[1]);
            }
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
