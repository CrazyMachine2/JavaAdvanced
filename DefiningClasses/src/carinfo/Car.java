package carinfo;

public class Car {
    private static final String undefinedValue = "unknown";
    private static final int undefinedHorsePower = -1;

    private String make;
    private String model;
    private int horsepower;

    public Car(){
        this.make = undefinedValue;
        this.model = undefinedValue;
        this.horsepower = undefinedHorsePower;
    }

    public Car(String made) {
        this();
        this.make = made;
    }

    public Car(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",this.make,this.model,this.horsepower);
    }
}
