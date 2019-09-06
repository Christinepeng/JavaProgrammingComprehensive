package HW5;

import java.util.Scanner;

class Validator {
    static int studentAmount(Scanner sc, String prompt) {
        int sScore = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            sScore = sc.nextInt();
            if (sScore <= 0) {
                System.out.println("Error! Please enter a number of students that is a positive integer");
            }
            else {
                isValid = true;
            }
        }
        return sScore;
    }

    static String name(Scanner sc, String prompt) {
        Scanner input = new Scanner(System.in);
        String  StudentName = "";
        boolean isvalid = false;


        while (!isvalid) {
            System.out.print(prompt);
            StudentName = input.nextLine();
            if (StudentName == null || StudentName.equals("")) {
                System.out.println("Error! You must enter a name.");
            }
            else {
                isvalid = true;
            }
        }
        return StudentName;
    }

    static int score(Scanner sc, String prompt) {
        int sScore = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            sScore = sc.nextInt();
            if (sScore > 100 || sScore < 0) {
                System.out.println("Error! Please enter a score that is between 0 to 100");
            }
            else {
                isValid = true;
            }
        }
        return sScore;
    }
}