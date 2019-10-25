package bank.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (true) {
            String input = scan.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] data = input.split(" ");
            String result = "";

            if (data[0].equals("Create")) {
                BankAccount account = new BankAccount();
                bankAccounts.put(account.getId(), account);
                result = String.format("Account ID%d created", account.getId());

            } else if (data[0].equals("Deposit")) {
                int id = Integer.parseInt(data[1]);
                double amount = Double.parseDouble(data[2]);

                if (bankAccounts.containsKey(id)) {
                    bankAccounts.get(id).deposit(amount);
                    result = String.format("Deposited %.0f to ID%d", amount, bankAccounts.get(id).getId());
                } else {
                    result = "Account does not exist";
                }

            } else if (data[0].equals("SetInterest")) {
                double interest = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interest);

            } else {
                int id = Integer.parseInt(data[1]);
                int years = Integer.parseInt(data[2]);

                if (bankAccounts.containsKey(id)){
                   double interest = bankAccounts.get(id).getInterest(years);
                    result = String.format("%.2f",interest);
                } else {
                    result = "Account does not exist";
                }
            }

            if (!result.isEmpty()){
                System.out.println(result);
            }

        }
    }
}
