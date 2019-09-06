package Hw1;

import java.util.Scanner;

public class AreaPerimeterCalculator extends Calculator {
    AreaPerimeterCalculator() {
        super.setType("Area and Perimeter Calculator");
    }

    void logic() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter length:\t");
        double length = sc.nextDouble();
        System.out.print("Enter width:\t");
        double width  = sc.nextDouble();
        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("Area:\t\t\t" + area);
        System.out.println("Perimeter:\t\t" + perimeter);
    }
}
