package Hw3;

import java.util.Scanner;

public class PigLatinTranslator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Pig Latin Translator.");
        char choice = 'y';
        while (choice == 'y' || choice == 'Y') {
            System.out.println("Enter a line to be translated to Pig Latin:");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] word = input.split(" ");
            String output = "";

            for (int i = 0; i < word.length; i++) {
                String pigLatinWord = translateWord(word[i]);
                output += pigLatinWord + " ";
            }
            System.out.println("\n" + output);

            System.out.print("\nContinue? (y/n): ");
            choice = sc.nextLine().charAt(0);
            System.out.println();
        }
    }

    private static String translateWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        int len = lowerCaseWord.length();
        int firstVowel = len;
        char ch;

        for (int i = 0; i < lowerCaseWord.length(); i++) {
            ch = lowerCaseWord.charAt(i);

            if (isVowel(i, ch)) {
                firstVowel = i;
                break;
            }
        }

        if (firstVowel == 0 && lowerCaseWord.charAt(0) != 'y') {
            return lowerCaseWord + "way";
        } else {
            String a = lowerCaseWord.substring(firstVowel, len);
            String b = lowerCaseWord.substring(0, firstVowel);
            return a + b + "ay";
        }
    }

    private static Boolean isVowel(int idx, char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || (ch == 'y' && idx > 0)) {
            return true;
        }
        return false;
    }
}
