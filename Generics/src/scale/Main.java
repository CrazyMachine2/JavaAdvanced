package scale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("kolio","mishoo");

        System.out.print(scale.getHeavier());
    }
}
