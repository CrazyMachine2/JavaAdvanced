import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long factorial = Integer.parseInt(scan.nextLine());

        System.out.println(fact(factorial));
    }

    private static long fact(long factorial) {
        if (factorial == 1){
            return 1;
        }

        return factorial * fact(factorial - 1);
    }
}
