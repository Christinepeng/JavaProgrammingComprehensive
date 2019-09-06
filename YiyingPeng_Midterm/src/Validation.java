import java.util.Scanner;

public class Validation {
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
}
