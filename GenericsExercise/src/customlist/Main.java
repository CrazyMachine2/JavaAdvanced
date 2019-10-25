package customlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        CustomList customList = new CustomList();

        while (true){
            String input = scan.nextLine();

            if (input.equals("END")){
                break;
            }

            String[] data = input.split(" ");

            switch (data[0]){
                case "Add":
                    customList.add(data[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(data[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                    break;
                case "Greater":
                    customList.printGreater(data[1]);
                    break;
                case "Max":
                    customList.printMax();
                    break;
                case "Min":
                    customList.printMin();
                    break;
                case "Print":
                    customList.print();
                    break;
                    default:
                       Sort.sort(customList);
            }
        }
    }
}
