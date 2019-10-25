package speed.racing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        
        Map<String,Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            Car car = new Car(Double.parseDouble(data[1]),Double.parseDouble(data[2]));

            if (!cars.containsKey(data[0])){
                cars.put(data[0],car);
            }
        }

        while (true){
            String input = scan.nextLine();

            if (input.equals("End")){
                break;
            }

            String model = input.split(" ")[1];
            int kmAmount = Integer.parseInt(input.split(" ")[2]);

            if (cars.get(model).canDrive(kmAmount)){
                cars.get(model).setTraveledDistance(kmAmount);
                cars.get(model).setFuelAmount(kmAmount);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        for (Map.Entry<String,Car> entry : cars.entrySet()){
            System.out.printf("%s %.2f %d%n",entry.getKey(),entry.getValue().getFuelAmount()
                    ,entry.getValue().getTraveledDistance());
        }
    }
}
