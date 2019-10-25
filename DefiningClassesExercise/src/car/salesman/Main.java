package car.salesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new LinkedList<>();

        int n1 = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n1; i++) {
            String[] data = scan.nextLine().split(" ");

            String model = data[0];
            int power = Integer.parseInt(data[1]);
            Engine engine = new Engine(model,power);

            if (data.length == 4){
                engine.setDisplacement(data[2]);
                engine.setEfficiency(data[3]);

            } else if (data.length == 3){
                if(tryParseInt(data[2])){
                    engine.setDisplacement(data[2]);
                    engine.setEfficiency("n/a");
                } else {
                    engine.setEfficiency(data[2]);
                    engine.setDisplacement("n/a");
                }
            }
            engines.putIfAbsent(model,engine);
        }

        int n2 = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n2; i++) {
            String[] data = scan.nextLine().split(" ");

            String model = data[0];
            Engine engine = engines.get(data[1]);
            Car car = car = new Car(model, engine);

            if (data.length == 4) {
                car.setWeight(data[2]);
                car.setColor(data[3]);

            } else if (data.length == 3) {
                if (tryParseInt(data[2])) {
                    car.setWeight(data[2]);
                    car.setColor("n/a");
                } else {
                    car.setColor(data[2]);
                    car.setWeight("n/a");
                }
            }
           cars.add(car);
        }

        for (Car car : cars){

            System.out.println(car.getModel()+ ":");
            System.out.println(car.getEngine().getModel()+ ":");
            System.out.println("Power: " + car.getEngine().getPower());
            System.out.println("Displacement: " + car.getEngine().getDisplacement());
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        }
    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

//public class Car {
//
//    private String model;
//    private Engine engine;
//    private String weight;
//    private String color;
//
//    public Car(String model,Engine engine){
//        this.model = model;
//        this.engine = engine;
//        this.weight = "n/a";
//        this.color = "n/a";
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public Engine getEngine() {
//        return engine;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public void setWeight(String weight) {
//        this.weight = weight;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s:%n" +
//                        "%s:%n" +
//                        "Power: %d%n" +
//                        "Displacement: %s%n" +
//                        "Efficiency: %s%n" +
//                        "Weight: %s%n" +
//                        "Color: %s%n",this.model,this.engine.getModel(),this.engine.getPower()
//                ,this.engine.getDisplacement(),this.engine.getEfficiency(),this.weight,this.color);
//    }
//}

//package car.salesman;
//
//public class Engine {
//
//    private String model;
//    private int power;
//    private String displacement;
//    private String efficiency;
//
//    public Engine(String model, int power){
//        this.model = model;
//        this.power = power;
//        this.displacement = "n/a";
//        this.efficiency = "n/a";
//    }
//
//    public Engine(String model, int power,String displacement,String efficiency){
//        this(model, power);
//        this.displacement = displacement;
//        this.efficiency = efficiency;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public void setPower(int power) {
//        this.power = power;
//    }
//
//    public String getDisplacement() {
//        return displacement;
//    }
//
//    public void setDisplacement(String displacement) {
//        this.displacement = displacement;
//    }
//
//    public String getEfficiency() {
//        return efficiency;
//    }
//
//    public void setEfficiency(String efficiency) {
//        this.efficiency = efficiency;
//    }
//}

