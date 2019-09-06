package Hw3;

import java.util.Scanner;

public class DiceRollerApp {
    public static void main(String args[]) {
        PairOfDice pairOfDice = new PairOfDice();
        System.out.println("Welcome to the Paradise Roller application");

        int roll = 0;
        char choice;
        System.out.print("\nRoll the dice? (y/n): ");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine().charAt(0);
        while (choice == 'y' || choice == 'Y') {
            pairOfDice.roll();
            roll++;
            System.out.println("\nRoll " + roll + " :\n" + pairOfDice.getValue1() + "\n" + pairOfDice.getValue2());
            if (pairOfDice.getSum() == 7) {
                System.out.println("Craps!");
            } else if (pairOfDice.getValue1() == 1 && pairOfDice.getValue2() == 1) {
                System.out.println("Snake eyes!");
            } else if (pairOfDice.getValue1() == 6 && pairOfDice.getValue2() == 6) {
                System.out.println("Box cars!");
            }

            System.out.print("\nRoll the dice? (y/n): ");
            choice = sc.nextLine().charAt(0);
            System.out.println();
        }
    }
}