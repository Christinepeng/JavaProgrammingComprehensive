package HW5;

import java.util.*;
import java.util.Scanner;

public class StackCalculator {
    LinkedList<Double> stack = new LinkedList<>();
    void push(double x) {
        stack.add(x);
        display();
    }

    double pop() {
        return stack.removeLast();
    }

    double add() {
        double valOne = stack.removeLast();
        double valTwo = stack.removeLast();
        double res = valOne + valTwo;
        stack.add(res);
        display();
        return res;
    }

    double subtract() {
        double valOne = stack.removeLast();
        double valTwo = stack.removeLast();
        double res = valTwo - valOne;
        stack.add(res);
        display();
        return res;
    }

    double multiply() {
        double valOne = stack.removeLast();
        double valTwo = stack.removeLast();
        double res = valOne * valTwo;
        stack.add(res);
        display();
        return res;
    }

    double divide() {
        double valOne = stack.removeLast();
        double valTwo = stack.removeLast();
        double res = valTwo / valOne;
        stack.add(res);
        display();
        return res;
    }

    void clear() {
        stack.clear();
        display();
    }

    void display() {
        double[] lst = getValues();
        if (size() == 0) {
            System.out.println("empty");
        } else {
            for (int i = size()-1; i >= 0; i--) {
                System.out.println(lst[i]);
            }
        }
    }

    double[] getValues() {
        return Arrays.stream(
                stack.toArray(new Double[size()])
        ).mapToDouble(Double::doubleValue).toArray();
    }

    int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackCalculator stackCalculator = new StackCalculator();
        System.out.println("Welcome to the Stack Calculator.\n\nCommands: push n, add, sub, mult, div, clear, or quit.\n");
        System.out.print("? ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        while (!choice.equalsIgnoreCase("quit")) {
            String [] lst = choice.split(" ");
            if (lst.length == 2 && lst[0].equals("push")) {
                stackCalculator.push(Double.parseDouble(lst[1]));
            } else if (choice.equals("pop")) {
                stackCalculator.pop();
            } else if (choice.equals("add")) {
                stackCalculator.add();
            } else if (choice.equals("sub")) {
                stackCalculator.subtract();
            } else if (choice.equals("mult")) {
                stackCalculator.multiply();
            } else if (choice.equals("div")) {
                stackCalculator.divide();
            } else if (choice.equals("clear")) {
                stackCalculator.clear();
            } else {
                System.out.println("No such operator");
            }

            System.out.print("\n? ");
            choice = sc.nextLine();
        }
    }
}
