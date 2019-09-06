package Hw7;

import java.util.Scanner;

class OOValidator {
    Scanner mScanner;

    OOValidator(Scanner scanner) {
        this.mScanner = scanner;
    }

    public int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (mScanner.hasNextInt()) {
                i = mScanner.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            mScanner.nextLine();
        }
        return i;
    }

    public int getIntWithinRange(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i < min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (i > max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    public double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (mScanner.hasNextDouble()) {
                d = mScanner.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            mScanner.nextLine();
        }
        return d;
    }

    public double getDoubleWithinRange(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d < min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (d > max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return d;
    }

}
