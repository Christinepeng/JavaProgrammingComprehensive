package Hw1;

import java.util.Scanner;

public class LetterGradeConverter extends Calculator {
    LetterGradeConverter() {
        super.setType("Letter Grade Converter");
    }

    void logic() {
        char letterGrade;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter numerical grade: ");
        int grade = sc.nextInt();
        if (88 <= grade && grade <= 100) {
            letterGrade = 'A';
        } else if (80 <= grade && grade <= 87) {
            letterGrade = 'B';
        } else if (67 <= grade && grade <= 79) {
            letterGrade = 'C';
        } else if (60 <= grade && grade <= 66) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        System.out.println("Letter grade: " + letterGrade);
    }
}
