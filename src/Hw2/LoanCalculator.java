package Hw2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class LoanCalculator extends CalculatorNew {

    LoanCalculator() {
        super.setType("Loan Calculator\n");
    }

    public static double getDoubleLoanAmountRange(Scanner sc, String prompt, double min, double max) {
        System.out.print(prompt);
        String loanAmountStr = sc.nextLine();

        double loanAmount;
        try {
            loanAmount = Double.parseDouble(loanAmountStr);
        } catch(Exception e) {
            throw new InputMismatchException("Error! Invalid decimal value. Try again.");
        }

        if (loanAmount <= min) {
            throw new InputMismatchException("Error! Number must be greater than 0.0");
        } else if (loanAmount >= max) {
            throw new InputMismatchException("Error! Number must be less than 1000000.0");
        } else {
            return loanAmount;
        }
    }

    public static double getDoubleYearlyInerestRateRange(Scanner sc, String prompt, double min, double max) {
        System.out.print(prompt);
        String yearlyInterestRateStr = sc.nextLine();

        double yearlyInterestRate;
        try {
            yearlyInterestRate = Double.parseDouble(yearlyInterestRateStr);
        } catch(Exception e) {
            throw new InputMismatchException("Error! Invalid decimal value. Try again.");
        }

        if (yearlyInterestRate <= min) {
            throw new InputMismatchException("Error! Number must be greater than 0.0");
        } else if (yearlyInterestRate >= max) {
            throw new InputMismatchException("Error! Number must be less than 20.0");
        } else {
            return yearlyInterestRate;
        }
    }

    public static int getIntnumberOfYearsRange(Scanner sc, String prompt, int min, int max) {
        System.out.print(prompt);
        String numberOfYearsStr = sc.nextLine();

        int numberOfYears;
        try {
            numberOfYears = Integer.parseInt(numberOfYearsStr);
        } catch(Exception e) {
            throw new InputMismatchException("Error! Invalid decimal value. Try again.");
        }

        if (numberOfYears <= min) {
            throw new InputMismatchException("Error! Number must be greater than 0");
        } else if (numberOfYears >= max) {
            throw new InputMismatchException("Error! Number must be less than 100");
        } else {
            return numberOfYears;
        }
    }

    void logic() {
        System.out.println("DATA ENTRY");
        Scanner sc = new Scanner(System.in);
        double loanAmount;
        double yearlyInterestRate;
        int numberOfYears;
        //getLoanAmount
        while (true) {
            try {
                loanAmount = getDoubleLoanAmountRange(sc, "Enter loan amount:\t", 0.0, 1000000.0);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        //getInterestRate
        while (true) {
            try {
                yearlyInterestRate = getDoubleYearlyInerestRateRange(sc, "Enter yearly interest rate:\t", 0.0, 20.0);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        //getNumberOfYearsStr
        while (true) {
            try {
                numberOfYears = getIntnumberOfYearsRange(sc, "Enter number of years:\t", 0, 100);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        //loanAmountDecimal
        BigDecimal loanAmountDecimal = new BigDecimal(Double.toString(loanAmount));
        loanAmountDecimal = loanAmountDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat loanFormatter = new DecimalFormat("#,###.00");
        //monthlyPayment
        double monthlyInterestRate = yearlyInterestRate/ 100 / 12;
        int months = numberOfYears * 12;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, months));
        BigDecimal monthlyPaymentDecimal = new BigDecimal(Double.toString(monthlyPayment));
        monthlyPaymentDecimal = monthlyPaymentDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat monthlyPaymentFormatter = new DecimalFormat("#,###.00");

        System.out.println("\nFORMATTED RESULTS");
        System.out.println("Loan amount:\t\t\t$" + loanFormatter.format(loanAmountDecimal));
        System.out.println("Yearly interest rate:\t" + yearlyInterestRate + "%");
        System.out.println("Number of years:\t\t" + numberOfYears);
        System.out.println("Monthly payment:\t\t$" + monthlyPaymentFormatter.format(monthlyPaymentDecimal));
    }
}
