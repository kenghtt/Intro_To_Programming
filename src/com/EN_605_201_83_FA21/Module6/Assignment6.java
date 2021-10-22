/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 6
 */

import java.util.ArrayList;
import java.util.Scanner;

class Assignment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean createNewEmployee;                  // Boolean to capture if a new employee will be created
        int employeeId = 1;

        ArrayList<Employee> employeeArrayList = new ArrayList<>();      // Array to capture all Employees

        do {
            System.out.println("");
            System.out.println("Employee Information");
            System.out.println("Please type in the First Name: ");      // Prompt First Name
            String firstName = validateString(scanner, "");
            System.out.println("Please type in the Last Name: ");       // Prompt Last Name
            String lastName = validateString(scanner, "");

            Name name = new Name(firstName, lastName);

            System.out.println("Please type in the Street Address: ");     // Prompt Street Address
            String street = validateString(scanner, "");
            System.out.println("Please type in the City: ");                // Prompt City
            String city = validateString(scanner, "c");
            System.out.println("Please type in the State Code (State Abbreviation): ");      // Prompt State Abbreviation
            String state = validateString(scanner, "state");
            System.out.println("Please type in the Zip Code: ");                // Prompt Zip Code
            int zipCode = Integer.parseInt(validateString(scanner, "zip"));

            Address address = new Address(street, city, state, zipCode);

            System.out.println("Please type in the hire month: ");              // Prompt Hire Month
            int month = Integer.parseInt(validateString(scanner, "month"));
            System.out.println("Please type in the hire day: ");
            int day = Integer.parseInt(validateString(scanner, "day"));     // Prompt Hire Day
            System.out.println("Please type in the hire year: ");
            int year = Integer.parseInt(validateString(scanner, "year"));       // Prompt Hire year

            Date date = new Date(month, day, year);

            Employee employee = new Employee(name, address, date, employeeId);          // Create new Employee
            employeeArrayList.add(employee);                                // Store new Employee in Array
            employeeId++;


            System.out.println("Would you like to type in another Employee information? Y or N: ");     // Prompt User for new Employee
            String tryAgain = validateString(scanner, "");
            createNewEmployee = tryAgain.equalsIgnoreCase("Y");


        } while (createNewEmployee);

        for (int i = 0; i < employeeArrayList.size(); i++) {        // Loop through Employee Array List and prints Employee information
            Employee currEmployee = employeeArrayList.get(i);

            System.out.println();
            currEmployee.getName();
            currEmployee.getAddress();
            currEmployee.getDate();
            System.out.println("Employee Id: " + currEmployee.getId());
            System.out.println("Name: " + currEmployee.getName());
            System.out.println("Address: " + currEmployee.getAddress());
            System.out.println("Date: " + currEmployee.getDate());

        }


    }


    /**
     * This method validates that the input is valid for each Employee Information.
     *
     * @param scanner is used to capture user input
     * @param type    of validation needed for specific inputs
     * @return type string for Employee information is returned
     */
    static String validateString(Scanner scanner, String type) {

        String employeeInfo;

        boolean isValid;
        do {
            isValid = true;
            employeeInfo = scanner.nextLine();         // Prompts for input

            if (employeeInfo.isEmpty()) {              // Validate if input is blank
                isValid = false;
            } else if (type.equals("state")) {      // Validate for valid state abbreviation

                String states = "|AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|";
                isValid = states.contains(employeeInfo.toUpperCase());

            } else if (type.equals("zip")) {        // Validate that zipcode is length of 5

                isValid = employeeInfo.length() == 5;

            } else if (type.equals("month")) {          // Validate that month is from 1-12

                isValid = Integer.parseInt(employeeInfo) > 0 && Integer.parseInt(employeeInfo) <= 12;

            } else if (type.equals("day")) {            // Validate that Day is from 1-31

                isValid = Integer.parseInt(employeeInfo) > 0 && Integer.parseInt(employeeInfo) <= 31;
            } else if (type.equals("year")) {           // Validate that year is between 1900 and 2021
                isValid = Integer.parseInt(employeeInfo) > 1900 && Integer.parseInt(employeeInfo) < 2021;
            }

            if (!isValid) {                     // When invalid , let user know that there was an invalid input
                System.out.println("Input is invalid, please try again!");
            }
        } while (!isValid);     // Retry if input was invalid

        return employeeInfo;       // return employee information
    }


}


class Employee {
    private int id;
    private Name name;
    private Address address;
    private Date date;

    Employee(Name name, Address address, Date date, int id) {

        this.name = name;
        this.address = address;
        this.date = date;
        this.id = id;
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

    int getId(){
        return this.id;
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
