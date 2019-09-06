package Hw1;

import java.util.Scanner;

public class CoinChangeCalculator extends Calculator {
    CoinChangeCalculator() {
        super.setType("Change Calculator");
    }

    void logic() {
        int cents;
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of cents (0-99): ");
        cents = sc.nextInt();
        quarters = cents / 25;
        cents -= quarters * 25;
        dimes = cents / 10;
        cents -= dimes * 10;
        nickels = cents / 5;
        cents -= nickels * 5;
        pennies = cents;
        System.out.print("Quarters:\t" + quarters + "\n");
        System.out.print("Dimes:\t\t" + dimes + "\n");
        System.out.print("Nickels:\t" + nickels + "\n");
        System.out.print("Pennies:\t" + pennies + "\n");
    }
}
