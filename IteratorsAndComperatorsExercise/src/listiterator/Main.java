package listiterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        List<String> elements = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
//        elements.remove(0);
//        String[] elementsArray = new String[elements.size()];
//
//        for (int i = 0; i < elements.size(); i++) {
//            elementsArray[i] = elements.get(i);
//        }

        String[] elements = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1)
                .toArray(String[]::new);

        ListIterator listIterator = new ListIterator(elements);

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }

            switch (input) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "PrintAll":
                    for (String s : listIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }
        }

    }
}
