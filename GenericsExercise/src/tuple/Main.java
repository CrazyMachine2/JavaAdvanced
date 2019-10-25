package tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String[] input = scan.nextLine().split(" ");

            if (i == 0) {
                String name = input[0] + " " + input[1];
                Tuple<String, String, String> tuple = new Tuple(name, input[2],input[3]);
                System.out.println(tuple.toString());

            } else if (i == 1) {
                boolean isDrunk = input[2].equals("drunk");

                Tuple<String,Integer,Boolean> tuple = new Tuple<>(input[0],Integer.parseInt(input[1]),isDrunk);
                System.out.println(tuple.toString());

            } else {
                Tuple<String,Double, String> tuple = new Tuple<>(input[0],Double.parseDouble(input[1]),input[2]);
                System.out.println(tuple.toString());
            }
        }
    }
}
