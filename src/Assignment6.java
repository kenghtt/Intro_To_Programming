import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 6
 */

class Assigment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean createNewEmployee = false;

        ArrayList<Employee> array = new ArrayList<>();

        do {

            System.out.println("Please type in the First Name: ");
            String firstName = validateString(scanner, "");
            System.out.println("Please type in the Last Name: ");
            String lastName = validateString(scanner, "");

            Name name = new Name(firstName, lastName);

            System.out.println("Please type in the Street Name: ");
            String street = validateString(scanner, "");
            System.out.println("Please type in the City: ");
            String city = validateString(scanner, "c");
            System.out.println("Please type in the State Code (2 letters): ");
            String state = validateString(scanner, "state");
            System.out.println("Please type in the Zip Code:: ");
            int zipCode = Integer.parseInt(validateString(scanner, "zip"));

            Address address = new Address(street, city, state, zipCode);

            System.out.println("Please type in the hire month: ");
            int month = Integer.parseInt(validateString(scanner, "month"));
            System.out.println("Please type in the hire day: ");
            int day = Integer.parseInt(validateString(scanner, "day"));
            System.out.println("Please type in the hire year: ");
            int year = Integer.parseInt(validateString(scanner, "year"));

            Date date = new Date(month, day, year);

            Employee employee = new Employee(name, address, date);
            array.add(employee);


            System.out.println("Would you like to type in another Employee information? Y or N: ");
            String tryAgain = validateString(scanner, "");
            createNewEmployee = tryAgain.equalsIgnoreCase("Y");


        } while (createNewEmployee);

        for (int i = 0; i < array.size(); i++) {
            Employee currEmployee = array.get(i);
            int employeeNumber = i + 1;

            System.out.println();
            currEmployee.getName();
            currEmployee.getAddress();
            currEmployee.getDate();
            System.out.println("Employee #" + employeeNumber + ": ");
            System.out.println("Name: " + currEmployee.getName());
            System.out.println("Address: " + currEmployee.getAddress());
            System.out.println("Date: " + currEmployee.getDate());

        }


    }

    static String validateString(Scanner scanner, String type) {

        String value = "";
        boolean isValid;
        do {
            isValid = true;
            value = scanner.nextLine();

            if (value.isBlank()) {
                isValid = false;
            } else if (type.equals("state")) {

                String states = "|AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|";
                isValid = states.contains(value.toUpperCase());

            } else if (type.equals("zip")) {

                isValid = value.length() == 5;

            } else if (type.equals("month")) {

                isValid = Integer.parseInt(value) > 0 && Integer.parseInt(value) <= 12;

            } else if (type.equals("day")) {

                isValid = Integer.parseInt(value) > 0 && Integer.parseInt(value) <= 31;
            } else if (type.equals("year")) {
                isValid = Integer.parseInt(value) > 1900 && Integer.parseInt(value) < 2021;
            }

            if (!isValid) {
                System.out.println("Value is either blank or invalid, please try again");
            }
        } while (!isValid);

        return value;
    }


}


class Employee {
    public Name name;
    public Address address;
    public Date date;

    Employee(Name name, Address address, Date date) {

        this.name = name;
        this.address = address;
        this.date = date;
    }

    String getName() {
        return this.name.getName();
    }

    String getAddress() {
        return this.address.getAddress();
    }

    String getDate() {
        return this.date.getDate();
    }


}

class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}

class Address {
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return street + " " + city + " " + state + ", " + zipCode;
    }
}

class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getDate() {
        return month + "/" + day + "/" + year;
    }
}
