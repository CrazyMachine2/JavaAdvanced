package froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake lake = new Lake(numbers);
        StringBuilder sb = new StringBuilder();


        for (Integer integer : lake) {
           sb.append(integer).append(", ");
        }

        System.out.println(sb.toString().substring(0,
                sb.lastIndexOf(", ")));
    }
}
