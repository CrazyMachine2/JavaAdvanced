package raw.data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int n = Integer.parseInt(scan.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");

            Engine engine = new Engine(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            Cargo cargo = new Cargo (data[4],Integer.parseInt(data[3]));
            List<Tire> tires = createTires(data);
            Car car = new Car (data[0],engine,cargo,tires);
            cars.add(car);
        }
        String cmd = scan.nextLine();

        if (cmd.equals("fragile")){

            for (Car car : cars){
                boolean isFragile = false;

                if (!car.getCargo().getType().equals("fragile")){
                    continue;
                }

                for (Tire tire : car.getTires()){
                    if (tire.getPresure() < 1){
                        isFragile = true;
                        break;
                    }
                }

                if (isFragile){
                    System.out.println(car.getModel());
                }
            }

        } else {
            for (Car car : cars){
                if (!car.getCargo().getType().equals("flamable")){
                    continue;
                }

                if (car.getEngine().getPower() > 250){
                    System.out.println(car.getModel());
                }
            }
        }


    }

    private static List<Tire> createTires(String[] data) {
        List<Tire> tires = new ArrayList<>();

        tires.add(new Tire(Integer.parseInt(data[6]),Double.parseDouble(data[5])));
        tires.add(new Tire(Integer.parseInt(data[8]),Double.parseDouble(data[7])));
        tires.add(new Tire(Integer.parseInt(data[10]),Double.parseDouble(data[9])));
        tires.add(new Tire(Integer.parseInt(data[12]),Double.parseDouble(data[11])));

        return tires;
    }
}
