package com;

/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 7
 */

import java.util.ArrayList;
import java.util.Scanner;

class Assignment7 {
    public static void main(String[] args) {
        boolean createNewEmployee;                  // Boolean to capture if a new employee will be created
        int employeeId = 1;
        boolean salaried;
        ArrayList<HourlyEmployee> hourlyEmployeeArrayList = new ArrayList<>();      // Array to capture all hourly Employees
        ArrayList<SalariedEmployee> salariedEmployeeArrayList = new ArrayList<>();      // Array to capture all Salaried Employees

        HourlyEmployee hourlyEmployee;
        SalariedEmployee salariedEmployee;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("Employee Information");

            System.out.println("Is this a Salaried Employee?: T or F");
            salaried = scanner.nextLine().equalsIgnoreCase("T");

            System.out.println("Please type in the First Name: ");      // Prompt First Name
            String firstName = scanner.nextLine();
            System.out.println("Please type in the Last Name: ");       // Prompt Last Name
            String lastName = scanner.nextLine();

            Name name = new Name(firstName, lastName);
            String street = "123 Arlington Street S";       // Hard Coding some details for the employee object
            String city = "Orlando";
            String state = "FL";
            int zipCode = 56789;
            Address address = new Address(street, city, state, zipCode);
            Date date = new Date(11, 22, 2017);

            if(salaried){
                System.out.println("Please type in the Annual Salary: ");       // Prompt Annual Salary
                int annualSalary = scanner.nextInt();

                salariedEmployee = new SalariedEmployee(name, address, date, employeeId, annualSalary );

                salariedEmployeeArrayList.add(salariedEmployee);
            } else{
                System.out.println("Please type in the number of hours worked: ");       // Prompt Hours Worked
                int hoursWorked = scanner.nextInt();

                System.out.println("Please type in the hourly pay rate: ");       // Prompt Hourly Pay Rate
                int payrate = scanner.nextInt();

                hourlyEmployee = new HourlyEmployee(name,address, date, employeeId, hoursWorked, payrate);

                hourlyEmployeeArrayList.add(hourlyEmployee);
            }

            employeeId++;

            System.out.println("Would you like to type in another Employee information? Y or N: ");     // Prompt User for new Employee
            createNewEmployee = new Scanner(System.in).nextLine().equalsIgnoreCase("Y");

        } while (createNewEmployee);

        System.out.println();
        System.out.println("SALARIED EMPLOYEE INFORMATION");
        for (SalariedEmployee currEmployee : salariedEmployeeArrayList) {        // Loop through Employee Array List and prints Employee information

            System.out.println("Employee Id: " + currEmployee.getId());
            System.out.println("Name: " + currEmployee.getName());
            System.out.println("Address: " + currEmployee.getAddress());
            System.out.println("Hired Date: " + currEmployee.getDate());
            System.out.println("Salary : $" + currEmployee.getAnnualSalary());
        }
        System.out.println();
        System.out.println("HOURLY EMPLOYEE INFORMATION");
        for (HourlyEmployee currEmployee : hourlyEmployeeArrayList) {        // Loop through Employee Array List and prints Employee information
            System.out.println("Employee Id: " + currEmployee.getId());
            System.out.println("Name: " + currEmployee.getName());
            System.out.println("Address: " + currEmployee.getAddress());
            System.out.println("Hired Date: " + currEmployee.getDate());
            System.out.println("Hours Worked: "+ currEmployee.getHoursWorked());
            System.out.println("Pay Rate: "+ currEmployee.getPayRate() + "/hr");
            System.out.println("Earnings: $"+ currEmployee.getEarnings());
            System.out.println();

        }


    }


}
