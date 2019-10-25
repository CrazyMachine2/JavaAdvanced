package raw.data;

public class Tire {
    private int age;
    private double presure;

    public Tire(int age, double presure) {
        this.age = age;
        this.presure = presure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPresure() {
        return presure;
    }

    public void setPresure(double presure) {
        this.presure = presure;
    }
}
