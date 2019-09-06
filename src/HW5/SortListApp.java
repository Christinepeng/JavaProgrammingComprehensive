package HW5;

import java.util.Arrays;
import java.util.Scanner;

public class SortListApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the HW5.Student Scores Application.\n");
        Scanner sc = new Scanner(System.in);
        int numberofStudent = Validator.studentAmount(sc,"Enter number of students to enter: ");

        Student[] student = new Student[numberofStudent];
        int y = 0;
        for (int i = 1; i <= numberofStudent; i++) {
            String StudentFirstName = Validator.name(sc , "\nHW5.Student " + i + " First name: ");
            String studentLastName = Validator.name(sc , "HW5.Student " + i + " Last  name: ");
            int studentScore = Validator.score(sc,"HW5.Student " + i + " score : ");

            student[y] = new Student(StudentFirstName, studentLastName , studentScore);
            y++;
        }

        System.out.println();
        Arrays.sort(student,0,numberofStudent);
        for (Student s : student) {
            System.out.println(s.getLastName() + ", " + s.getFirstName() + ": " + s.getScore());
        }
    }
}
