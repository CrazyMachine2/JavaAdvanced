package carinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(" ");
            Car car = null;


            if (data.length > 1){
                car = new Car(data[0],data[1],Integer.parseInt(data[2]));
            } else {
                car = new Car (data[0]);
            }
            cars.add(car);
        }

        for(Car car : cars){
            System.out.println(car.toString());
        }
    }
}
