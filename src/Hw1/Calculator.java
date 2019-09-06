package Hw1;

import java.util.Scanner;

public abstract class Calculator {
    private Scanner sc;
    private String type;

    Calculator() {
        sc = new Scanner(System.in);
        type =  "";
    }

    public void setType(String type) { this.type = type; }

    abstract void logic();

    void printPreMessage() {
        System.out.printf("\nWelcome to the %s\n", type);
    }

    public void run() {
        printPreMessage();

        char response;
        do {
            logic();

            System.out.print("\nContinue? (y/n): ");
            response = sc.next().charAt(0);
        } while (response == 'y' || response == 'Y');
    }
}
