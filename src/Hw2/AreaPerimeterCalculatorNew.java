package Hw2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class AreaPerimeterCalculatorNew extends CalculatorNew {

    AreaPerimeterCalculatorNew() {
        super.setType("Area and Perimeter Calculator\n");
    }

    public static double getDoubleLengthRange(Scanner sc, String prompt, double min, double max) {
        System.out.print(prompt);
        String lengthStr = sc.nextLine();

        double length;
        try {
             length = Double.parseDouble(lengthStr);
        } catch(Exception e) {
            throw new InputMismatchException("Error! Invalid decimal value. Try again.");
        }

        if (length <= min) {
            throw new InputMismatchException("Error! Number must be greater than 0.0");
        } else if (length >= max) {
            throw new InputMismatchException("Error! Number must be less than 1000000.0");
        } else {
            return length;
        }
    }

    public static double getDoubleWidthRange(Scanner sc, String prompt, double min, double max) {
        System.out.print(prompt);
        String widthStr = sc.nextLine();

        double width;
        try {
            width = Double.parseDouble(widthStr);
        } catch(Exception e) {
            throw new InputMismatchException("Error! Invalid decimal value. Try again.");
        }

        if (width <= min) {
            throw new InputMismatchException("Error! Number must be greater than 0.0");
        } else if (width >= max) {
            throw new InputMismatchException("Error! Number must be less than 1000000.0");
        } else {
            return width;
        }
    }

    void logic() {
        Scanner sc = new Scanner(System.in);
        double length;
        double width;
        //getLength
        while (true) {
            try {
                length = getDoubleLengthRange(sc, "Enter length:\t", 0.0, 1000000.0);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        //getWidth
        while (true) {
            try {
                width = getDoubleWidthRange(sc, "Enter width:\t", 0.0, 1000000.0);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("Area:\t\t\t" + area);
        System.out.println("Perimeter:\t\t" + perimeter);
    }
}
