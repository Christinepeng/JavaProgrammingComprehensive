package Hw3;

import java.util.Scanner;

public class NumberToWordConverter {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number to Word Converter.\n");

        char choice = 'y';
        while (choice == 'y' || choice == 'Y') {
            System.out.print("Enter the number you want to convert to words: ");
            Scanner sc = new Scanner(System.in);
            int inputNumber = sc.nextInt();

            if (inputNumber == 0) {
                System.out.println("zero");
            } else {
                System.out.println(numberToWord(inputNumber));
            }

            Scanner choiceScanner = new Scanner(System.in);
            System.out.print("\nConvert another number? (y/n): ");
            choice = choiceScanner.nextLine().charAt(0);
            System.out.println();
        }
    }

    private static String numberToWord(int number) {
        String words = "";
        String unitsArray[] = {
                "",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen" };
        String tensArray[] = {
                "",
                "ten",
                "twenty",
                "thirty",
                "forty",
                "fifty",
                "sixty",
                "seventy",
                "eighty",
                "ninety" };

        if ((number / 1000) > 0) {
            words += numberToWord(number / 1000) + " thousand ";
            number %= 1000;
        }
        if ((number / 100) > 0) {
            words += numberToWord(number / 100) + " hundred ";
            number %= 100;
        }
        if (number > 0) {
            if (number < 20) {
                words += unitsArray[number];
            } else {
                words += tensArray[number / 10];
                if ((number % 10) > 0) {
                    words += " " + unitsArray[number % 10];
                }
            }
        }
        return words;
    }
}
