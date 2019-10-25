import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        int sum = arraySum(arr,0);
        System.out.println(fib(5));
    }

    private static int arraySum(int[] arr,int index) {

        if (index == arr.length - 1){
            return arr[index];
        }

        return arr[index] + arraySum(arr,index + 1);
    }

    private static int fib(int index) {

        if (index == 0){
            return 0;
        } else if (index == 1){
            return 1;
        }

        return fib(index - 1) + fib(index - 2);
    }


}
















