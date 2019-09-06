package Hw4;

import java.util.*;

public class ValidatorTestApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Validation Tester application\n");

        System.out.println("Int Test");
        Scanner sc = new Scanner(System.in);
        OOValidator ooValidator = new OOValidator(sc);
        ooValidator.getIntWithinRange("Enter an integer between -100 and 100: ", -100, 100);

        System.out.println("\nDouble Test");
        ooValidator.getDoubleWithinRange("Enter any number between -100 and 100: ", -100, 100);

        System.out.println("\nRequired String Test");
        MyValidator myValidator = new MyValidator(sc);
        myValidator.getRequiredString("Enter your email address: ");

        System.out.println("\nString Choice Test");
        myValidator.getChoiceString("Select one (x/y): ", "x", "y");
    }
}

class OOValidator {

    Scanner sc;

    public OOValidator(Scanner sc) {
        this.sc = sc;
    }

    public int getInt(String prompt) {
        return Validator.getIntWithinRange(this.sc, null, null, prompt);
    }

    public int getIntWithinRange(String prompt, int min, int max) {
        return Validator.getIntWithinRange(this.sc, min, max, prompt);
    }

    public double getDouble(String prompt) {
        return Validator.getDoubleWithinRange(this.sc, null, null, prompt);
    }

    public double getDoubleWithinRange(String prompt, double min, double max) {
        return Validator.getDoubleWithinRange(this.sc, min, max, prompt);
    }

}

class MyValidator extends OOValidator {

    MyValidator(Scanner sc) {super(sc);}

    public String getRequiredString(String prompt) {
        return Validator.getChoiceString(sc, null, prompt);
    }

    public String getChoiceString(String prompt, String s1, String s2) {
        return Validator.getChoiceString(sc, new String[] {s1, s2}, prompt);
    }
}

class Validator {
    public static int getIntWithinRange(Scanner sc, Integer min, Integer max, String prompt) {
        while (true) {
            System.out.print(prompt);

            int value;
            String str = sc.nextLine();
            try {
                value = Integer.parseInt(str);
                boolean isValid = true;
                if (min != null && value < min) {
                    System.out.println("Error! Number must be greater than " + min + ".");
                    isValid = false;
                }
                if (max != null && value > max) {
                    System.out.println("Error! Number must be less than " + max + ".");
                    isValid = false;
                }
                if (isValid) {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Error! Invalid integer value. Try again.");
            }
        }
    }

    public static double getDoubleWithinRange(Scanner sc, Double min, Double max, String prompt) {
        while (true) {
            System.out.print(prompt);

            double value;
            String str = sc.nextLine();
            try {
                value = Double.parseDouble(str);
                boolean isValid = true;
                if (min != null && value < min) {
                    System.out.println("Error! Number must be greater than " + min + ".");
                    isValid = false;
                }
                if (max != null && value > max) {
                    System.out.println("Error! Number must be less than " + max + ".");
                    isValid = false;
                }
                if (isValid) {
                    return value;
                }
            } catch (Exception e) {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
        }
    }

    public static String getChoiceString(Scanner sc, String[] choices, String prompt) {
        while (true) {
            System.out.print(prompt);
            String str = sc.nextLine();

            if (str.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                if (choices == null) {
                    return str;
                } else {
                    assert (choices.length == 2);
                    for (String choice : choices) {
                        if (choice.equals(str)) {
                            return str;
                        }
                    }
                    System.out.println("Error! Entry must be '" + choices[0] + "' or '" + choices[1] + "'. Try again.");
                }
            }
        }
    }
}