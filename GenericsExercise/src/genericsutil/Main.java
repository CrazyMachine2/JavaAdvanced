package genericsutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> values = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            values.add(scan.nextLine());
        }

        String element = scan.nextLine();
        int count = Utils.compare(values, element);
        System.out.println(count);


//        int[] indexes = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt)
//                .toArray();
//
//        Utils.swap(values,indexes[0],indexes[1]);

    }
}
