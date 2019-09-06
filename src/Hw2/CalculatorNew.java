package Hw2;

import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class CalculatorNew {
    private Scanner sc;
    private String type;

    CalculatorNew() {
        sc = new Scanner(System.in);
        type =  "";
    }

    public void setType(String type) { this.type = type; }

    abstract void logic();

    void printPreMessage() {
        System.out.printf("\nWelcome to the %s\n", type);
    }

    void validateResponse(String response) {
        if ("".equals(response)) {
            throw new InputMismatchException("Error! This entry is required. Try again.");
        }
        else if (!response.equalsIgnoreCase("y") &&
            !response.equalsIgnoreCase("n")) {
            throw new InputMismatchException("Error! Entry must be 'y' or 'n'. Try again.");
        }
    }

    public void run() {
        printPreMessage();

        String response;
        do {
            logic();
            while (true) {
                try {
                    System.out.print("\nContinue? (y/n): ");
                    response = sc.nextLine();
                    validateResponse(response);
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }
        } while (response.equalsIgnoreCase("y"));
    }
}