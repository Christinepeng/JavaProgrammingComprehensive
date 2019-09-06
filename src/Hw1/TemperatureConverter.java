package Hw1;

import java.util.Scanner;

public class TemperatureConverter extends Calculator {
    TemperatureConverter() {
        super.setType("Temperature Converter");
    }

    void logic() {
        double fahrenheit;
        double celsius;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter degrees in Fahrenheit: ");
        fahrenheit = sc.nextDouble();
        celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("Degrees in Celsius: " + String.format( "%.2f", celsius ));
    }
}
