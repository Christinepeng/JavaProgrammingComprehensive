package Hw6;

import java.util.ArrayList;
import java.util.Scanner;
public class ConversionsApp
{
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Length Converter\n");
        // create the Scanner object
        Scanner sc = new Scanner(System.in);
        // create the Data Access object
        ConversionsTextFile conversionsDAO = new ConversionsTextFile();
        // continue until the user enters 4
        int menuNumber = 0;
        while (menuNumber != 4)
        {
            // display menu
            System.out.println("1 - Convert a length");
            System.out.println("2 - Add a type of conversion");
            System.out.println("3 - Delete a type of conversion");
            System.out.println("4 - Exit\n");
            // get input from user
            menuNumber = Validator.getIntWithinRange(sc, "Enter menu number: ", 0, 5);
            System.out.println();
            int conversionNumber = 0;
            switch (menuNumber)
            {
                case 1:
                {
                    // read the conversion list from the file
                    ArrayList<Conversion> conversionsList =
                            conversionsDAO.getConversions();
                    // display the list of conversions
                    displayList(conversionsList);
                    // get menu choice from user
                    conversionNumber = Validator.getIntWithinRange(
                            sc, "Enter conversion number: ", 0, conversionsList.size()+1);
                    System.out.println();
                    // get the Conversion object
                    int index = conversionNumber - 1;
                    Conversion c = conversionsList.get(index);
                    // get from value, calculate to value, and display result
                    double fromValue = Validator.getDouble(sc, "Enter " + c.getFromUnit()
                            + ": ");
                    c.calculateConversion(fromValue);
                    System.out.println(c.getCalculationString());
                    System.out.println();
                    break;
                }
                case 2:
                {
                    // get data from user
                    String fromUnit = Validator.getRequiredString(sc, "Enter 'From' unit: ");
                            String toUnit = Validator.getRequiredString(sc, "Enter 'To' unit: ");
                    double ratio = Validator.getDouble(sc, "Enter the conversion ratio: ");
                            // read the conversion types list from the file
                            ArrayList<Conversion> conversionsList = conversionsDAO.getConversions();
                    // create Conversion objec and fill it with data
                    Conversion c = new Conversion(fromUnit, toUnit, ratio);
                    // add the Conversion objec to the array list
                    conversionsList.add(c);
                    // save the array list and display confirmation message
                    conversionsDAO.saveConversions(conversionsList);
                    System.out.println();
                    System.out.println("This entry has been saved.\n");
                    break;
                }
                case 3:
                {
                    // read the conversion types list from the file
                    ArrayList<Conversion> conversionsList =
                            conversionsDAO.getConversions();
                    // display the list with numbers
                    displayList(conversionsList);
                    // get data from user
                    conversionNumber = Validator.getIntWithinRange(
                            sc, "Enter number of conversion to delete: ", 0,
                            conversionsList.size()+1);
                    int index = conversionNumber - 1;
                    // get the Conversion objec
                    Conversion c = conversionsList.get(index);
                    // delete the Conversion objec
                    conversionsList.remove(index);
                    // save the array list and display confirmation message
                    conversionsDAO.saveConversions(conversionsList);
                    System.out.println();
                    System.out.println(c + " has been deleted.\n");
                    break;
                }
                case 4:
                {
                    System.out.println("Goodbye.\n");
                    break;
                }
            }
        }
    }
    // display the conversions list with numbers
    private static void displayList(ArrayList<Conversion> conversionsList)
    {
        int j = 0;
        for (int i = 0; i < conversionsList.size(); i++)
        {
            Conversion c = conversionsList.get(i);
            j++;
            System.out.println(j + " - " + c);
        }
        System.out.println();
    }
} 