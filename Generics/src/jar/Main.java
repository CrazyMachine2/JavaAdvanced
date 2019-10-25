package jar;

public class Main {
    public static void main(String[] args) {
        Jar<String> names = new Jar<>();

        names.add("pesho");
        names.add("gosho");

        System.out.println(names.remove());
    }
}
