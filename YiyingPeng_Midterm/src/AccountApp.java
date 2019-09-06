import java.util.Scanner;

public class AccountApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Account application\n");
        System.out.println("Starting Balances\nChecking:\t$1,000.00\nSavings:\t$1,000.00\n");
        System.out.println("Enter the transactions for the month\n");

        Scanner sc = new Scanner(System.in);
        char continueOrNot = 'y';
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingAccount savingAccount = new SavingAccount();
        while (continueOrNot == 'y' || continueOrNot == 'Y') {
            String choiceAction = Validation.getChoiceString(
                    sc,
                    new String[] {"w", "d"},
                    "Withdrawal or deposit? (w/d): "
            );
            String choiceAccount = Validation.getChoiceString(
                    sc,
                    new String[] {"c", "s"},
                    "Checking or savings? (c/s): "
            );
            double amount = Validation.getDoubleWithinRange(
                    sc,
                    0.00,
                    null,
                    "Amount?: "
            );


            if (choiceAction.equals("w")) {
                if (choiceAccount.equals("c")) {
                    checkingAccount.withdraw(amount);
                } else {
                    savingAccount.withdraw(amount);
                }
            } else {
                if (choiceAccount.equals("c")) {
                    checkingAccount.deposit(amount);
                } else {
                    savingAccount.deposit(amount);
                }
            }

            System.out.print("\nContinue? (y/n): ");
            continueOrNot = sc.nextLine().charAt(0);
            System.out.println();
        }

        savingAccount.getInterestPayment();
        System.out.println("Monthly Payments and Fees");
        System.out.println("Checking fee:\t\t\t\t$" + 1.00 + "\nSavings interest payment:\t$" + savingAccount.getInterestPayment());
        System.out.println("\nFinal Balances");
        System.out.println("Checking:\t$" + checkingAccount.getBalance() + "\nSavings:\t$" + savingAccount.getBalance());
    }
}
