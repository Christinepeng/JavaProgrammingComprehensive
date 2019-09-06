package Hw1;

import java.util.Scanner;

public class TravelTimeCalculator extends Calculator {
    TravelTimeCalculator() {
        super.setType("Travel Time Calculator");
    }

    void logic() {
        double miles;
        double milesPerHour;
        double hours;
        double minutes;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter miles:\t\t\t");
        miles = sc.nextDouble();
        System.out.print("Enter miles per hour:\t");
        milesPerHour = sc.nextDouble();
        System.out.println("\nEstimated travel time");
        hours = miles / milesPerHour;
        minutes = miles % milesPerHour / milesPerHour * 60;
        System.out.print("Hours:\t\t" + (int)hours);
        System.out.print("\nMinutes:\t" + (int)minutes + "\n");
    }
}

