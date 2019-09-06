package Hw7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMaintApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Customer Maintenance application\n");
        System.out.println("COMMAND MENU");
        System.out.println("list  -  List all customers\n" +
                "add   -  Add a customer\n" +
                "del   -  Delete a customer\n" +
                "help  -  Show this menu\n" +
                "exit  -  Exit this application\n");

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator(scanner);
        String command = "";

        CustomerDB customerDB = new CustomerDB();

        while (!command.equals("exit")) {
            command = validator.getRequiredString("Enter a command: ");
            switch (command) {
                case "list":
                    customerDB.getCustomerList();
                    break;
                case "add":
                    String email = validator.getRequiredString("Enter customer email address: ");
                    String firstName = validator.getRequiredString("Enter first name: ");
                    String lastName = validator.getRequiredString("Enter last name: ");

                    customerDB.addCustomer(new Customer(email, firstName, lastName));
                    break;
                case "del":
                    String delEamil = validator.getRequiredString("Enter customer email to delete: ");
                    customerDB.delCustomer(delEamil);
                    break;
                case "help":
                    System.out.println("list  -  List all customers\n" +
                            "add   -  Add a customer\n" +
                            "del   -  Delete a customer\n" +
                            "help  -  Show this menu\n" +
                            "exit  -  Exit this application\n");
                    break;
            }
        }
        System.out.println("Bye.");
    }
}





