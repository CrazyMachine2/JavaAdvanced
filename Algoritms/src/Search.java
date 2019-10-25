import java.util.Arrays;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(numbers);

        int number = Integer.parseInt(scan.nextLine());
        System.out.println(find(numbers, number));
    }

    private static int find(int[] numbers, int value) {
        int currentIndex = 1;
        int prevIndex = 0;

        if (numbers[0] == value){
            return 0;
        }

        while ( currentIndex < numbers.length && numbers[currentIndex] < value){
            currentIndex = prevIndex + currentIndex;
            prevIndex = currentIndex - prevIndex;
        }



        if (currentIndex >= numbers.length){
           currentIndex = numbers.length - 1;
        }

        int result = -1;
        for (int i = currentIndex; i >= prevIndex ; i--) {
            if (numbers[i] == value){
                result = i;
                break;
            }
        }
        return result;
    }
}
