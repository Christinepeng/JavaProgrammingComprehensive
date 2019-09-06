package Hw3;

import java.util.Scanner;

public abstract class CircleApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Circle Tester\n");

        Scanner sc = new Scanner(System.in);
        char choice = 'y';
        while (choice == 'y' || choice == 'Y') {
            double radius = ValidatorOld.getDouble(sc, "Enter radius:\t");
            Circle.objectCount++;

            Circle circle = new Circle(radius);
            System.out.println("Circumference:\t" + circle.getCircumfenrence());
            System.out.println("Area:\t\t\t" + circle.getArea());

            System.out.print("\nContinue? (y/n): ");
            choice = sc.nextLine().charAt(0);
            System.out.println();
        }
        System.out.println("\nGoodbye. You created " + Circle.getObjectCount() + " Circle object(s).");
    }
}
