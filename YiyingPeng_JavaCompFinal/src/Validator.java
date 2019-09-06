import java.util.Scanner;

class Validator {

    static String getRequiredString(String prompt, Scanner sc) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again. \n");
            } else {
                isValid = true;
            }
        }
        return s;
    }

    private static int getInt(Scanner sc, String prompt) {
        int number = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                isValid = true;
            } else {
                sc.next();
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return number;
    }

    static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int number = 0;
        boolean isValid = false;

        while(!isValid) {
            number = getInt(sc, prompt);

            if (number < min) {
                System.out.println("Error! Number must be greater than " + (min - 1));
            } else if (number > max) {
                System.out.println("Error! Number must be less than " + (max + 1));
            } else {
                isValid = true;
                break;
            }
        }
        return number;
    }

}
