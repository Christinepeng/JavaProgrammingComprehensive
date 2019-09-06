package Hw2;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InterestCalculator extends CalculatorNew {
    InterestCalculator() {
        super.setType("Interest Calculator");
    }

    void logic() {
        Scanner sc = new Scanner(System.in);
        //loan
        System.out.print("\nEnter loan amount:\t");
        double loanAmount = sc.nextDouble();
        BigDecimal loanAmountDecimal = new BigDecimal(Double.toString(loanAmount));
        loanAmountDecimal = loanAmountDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat loanFormatter = new DecimalFormat("#,###.00");
        //interest rate
        System.out.print("Enter interest rate:");
        double interestRate  = sc.nextDouble();
        //interest
        double interest = loanAmount * interestRate;
        BigDecimal interestDecimal = new BigDecimal(Double.toString(interest));
        interestDecimal = interestDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat interestFormatter = new DecimalFormat("#,###.00");

        System.out.println("\nLoan amount:\t\t$" + loanFormatter.format(loanAmountDecimal));
        System.out.println("Interest rate:\t\t" + interestRate * 100 + "%");
        System.out.println("Interest:\t\t\t$" + interestFormatter.format(interestDecimal));
    }
}