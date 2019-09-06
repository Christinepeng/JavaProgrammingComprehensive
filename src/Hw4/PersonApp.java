package Hw4;

import java.util.Scanner;

public class PersonApp {
    public static void print(Person person) {
        System.out.println("\nYou entered:");
        System.out.println(person.getDisplayText());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hw4.Person Tester application\n");

        Scanner sc = new Scanner(System.in);
        char continueOrNot = 'y';
        while (continueOrNot == 'y' || continueOrNot == 'Y') {
            String choice = Validator.getChoiceString(
                    sc,
                    new String[] {"c", "e"},
                    "Create customer or employee? (c/e): "
            );

            String firstName = Validator.getChoiceString(
                    sc,
                    null,
                    "Enter first name: "
            );

            String lastName = Validator.getChoiceString(
                    sc,
                    null,
                    "Enter last name: "
            );

            String emailAddress = Validator.getChoiceString(
                    sc,
                    null,
                    "Enter email address: "
            );

            Person person;
            if (choice.equals("c")) {
                String customerNumber = Validator.getChoiceString(
                        sc,
                        null,
                        "Hw4.Customer number: "
                );
                person = new Customer();
                ((Customer) person).setCustomerNumber(customerNumber);

            } else {
                String socialSecurityNumber = Validator.getChoiceString(
                        sc,
                        null,
                        "Social security number: "
                );
                person = new Employee();
                ((Employee) person).setSocialSecurityNumber(socialSecurityNumber);
            }
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmailAddress(emailAddress);

            print(person);

            System.out.print("\nContinue? (y/n): ");
            continueOrNot = sc.nextLine().charAt(0);
            System.out.println();
        }
    }
}

abstract class Person {
    private String firstName;
    private String lastName;
    private String emailAddress;

    private String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return  "Name: " + getFirstName() + " " + getLastName() + "\n" + "Email: " + getEmailAddress();
    }

    abstract String getDisplayText();
}

class Customer extends Person {
    private String customerNumber;

    private String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    String getDisplayText() {
        return toString() + "\nHw4.Customer number: " + getCustomerNumber();
    }
}

class Employee extends Person {
    private String  socialSecurityNumber;

    private String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    String getDisplayText() {
        return toString() + "\nSocial security number: " + getSocialSecurityNumber();
    }
}