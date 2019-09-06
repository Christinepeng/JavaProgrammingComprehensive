package Hw7;

import java.util.Scanner;

class Validator extends OOValidator {
    Validator(Scanner scanner) {
        super(scanner);
    }

    @Override
    public int getInt(String prompt) {
        return super.getInt(prompt);
    }

    @Override
    public int getIntWithinRange(String prompt, int min, int max) {
        return super.getIntWithinRange(prompt, min, max);
    }

    @Override
    public double getDouble(String prompt) {
        return super.getDouble(prompt);
    }

    @Override
    public double getDoubleWithinRange(String prompt, double min, double max) {
        return super.getDoubleWithinRange(prompt, min, max);
    }

    public String getRequiredString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (mScanner.hasNextLine()) {
                s = mScanner.nextLine();
                isValid = true;
            } else {
                System.out.println("Error! This entry is required. Try again.");
            }
        }
        return s;
    }
}
