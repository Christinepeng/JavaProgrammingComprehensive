package Hw2;

import java.util.Scanner;

public class SquaresAndCubesTable extends CalculatorNew {
    SquaresAndCubesTable() {
        super.setType("Squares and Cubes table");
    }

    void logic() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter an integer: ");
        int inputNumber = sc.nextInt();
        System.out.println("\nNumber\tSquared\tCubed");
        System.out.println("======\t=======\t=====");

        for (int i = 1; i <= inputNumber; i++) {
            System.out.println(i + "\t\t" + (int)Math.pow(i, 2) + "\t\t" + (int)Math.pow(i, 3));
        }
    }
}