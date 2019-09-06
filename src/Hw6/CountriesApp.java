package Hw6;

import java.util.ArrayList;
import java.util.Scanner;
public class CountriesApp {
    public static void main(String args[]) {
        System.out.println("Welcome to the Countries Maintenance application\n");
        Scanner sc = new Scanner(System.in);
        CountriesTextFile countriesDAO = new CountriesTextFile();
        int menuNumber = 0;
        while (menuNumber != 3) {
            System.out.println("1 - List countries");
            System.out.println("2 - Add a country");
            System.out.println("3 - Exit\n");
            menuNumber = Validator.getIntWithinRange(sc, "Enter menu number: ", 0, 4);
            System.out.println();
            switch (menuNumber) {
                case 1: {
                    ArrayList<String> countries = countriesDAO.getCountries();
                    for (int i = 0; i < countries.size(); i++) {
                        String country = countries.get(i);
                        System.out.println(country);
                    }
                    System.out.println();
                    break;
                } case 2: {
                    ArrayList<String> countries = countriesDAO.getCountries();
                    String country = Validator.getRequiredString(sc, "Enter country: ");
                    countries.add(country);
                    countriesDAO.saveCountries(countries);
                    System.out.println();
                    System.out.println("This country has been saved.\n");
                    break;
                } case 3: {
                    System.out.println("Goodbye.");
                    break;
                }
            }
        }
    }
}