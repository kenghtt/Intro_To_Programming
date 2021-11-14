package com.Module11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Assignment1 {


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Please provide an absolute path to file:");
        Scanner scanner = new Scanner(System.in);
        String destinationFile = scanner.nextLine();

        TreeMap<String, Contact> contactTreeMap = new TreeMap<>();

        readFile(destinationFile, contactTreeMap);


        String choice = "";

        while (!choice.equals("0")) {
            System.out.println("These are your options: ");
            System.out.println("1: Add contacts ");
            System.out.println("2: Delete a contact ");
            System.out.println("3: Display entire contact list ");
            System.out.println("4: Exit Program ");
            choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    // Add a contact
                    addContacts(destinationFile, contactTreeMap);
                    break;
                case "2":
                    // Delete a contact
                    deleteContact(destinationFile, contactTreeMap);
                    break;
                case "3":
                    // Display All Contacts
                    displayAllContacts(destinationFile, contactTreeMap);
                    break;
                case "4":
                    // Display entire contact list
                    choice = "0";
                    break;
                default:

                    continue;
            }

        }


        System.out.println("Thank You and Good Bye!");


///   /Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/Module11/output.txt

    }

    static void displayAllContacts(String destinationFile, TreeMap<String, Contact> treeMap) throws FileNotFoundException {
        File file = new File(destinationFile);

        Scanner sc = new Scanner(file);
        String line;

        addWhiteSpace("Last Name", 15);

        addWhiteSpace("First Name", 30);
        addWhiteSpace("Phone Number", 45);
        addWhiteSpace("Email Address", 60);
        System.out.println();
        addWhiteSpace("---------", 15);
        addWhiteSpace("----------", 30);
        addWhiteSpace("------------", 45);
        addWhiteSpace("-------------", 60);
        System.out.println();

        while (sc.hasNextLine()) {  // Checks that there still text in next line, and also that counter does not exceed numberOfRecords
            line = sc.nextLine();
            String[] splited = line.split(" ");

            addWhiteSpace(splited[0], 15);
            addWhiteSpace(splited[1], 30);
            addWhiteSpace(splited[2], 45);
            addWhiteSpace(splited[3], 60);
            System.out.println();


        }
    }

    static void addWhiteSpace(String stringBuffer, int maxLength) {
        StringBuilder stringBufferBuilder = new StringBuilder(stringBuffer);
        while (stringBufferBuilder.length() < maxLength) {
            stringBufferBuilder.append(" ");
        }
        System.out.print(stringBufferBuilder.toString());
    }

    static void readFile(String destinationFile, TreeMap<String, Contact> treeMap) throws FileNotFoundException {

        File file = new File(destinationFile);

        Scanner sc = new Scanner(file);
        String line;

        // Print out file onto console
        while (sc.hasNextLine()) {  // Checks that there still text in next line, and also that counter does not exceed numberOfRecords
            line = sc.nextLine();
            String[] splited = line.split(" ");
            Contact contact = new Contact(splited[1].toUpperCase(), splited[0].toUpperCase(), splited[2].toUpperCase(), splited[3].toUpperCase());
            treeMap.put(splited[0], contact);

        }


    }

    static void deleteContact(String destinationFile, TreeMap<String, Contact> treeMap) throws FileNotFoundException {
        File f = new File(destinationFile);
        Scanner scanner = new Scanner(System.in);
        String removeAnotherContact = "T";
        String lastName;

        do {

            if (treeMap.size() > 1) {
                System.out.println("Please input a last name to delete");
                lastName = scanner.nextLine();

                if (treeMap.containsKey(lastName.toUpperCase())) {
                    // Delete
                    treeMap.remove(lastName.toUpperCase());
                    System.out.println("Successfully Deleted Contact ");
                    System.out.println("");

                } else {
                    System.out.println("Last name does not exist in file");
                }

                System.out.println("Would you like to delete another contact? ");
                removeAnotherContact = scanner.nextLine();
            } else {
                System.out.println("There are no contacts in the file!");
                removeAnotherContact = "N";
            }


        } while (removeAnotherContact.equalsIgnoreCase("Y"));

        updateFile(treeMap, destinationFile);

    }

    static void addContacts(String destinationFile, TreeMap<String, Contact> treeMap) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String addAnotherContact;

        String firstName;
        String lastName;
        String phoneNumber;
        String email;
        do {

            System.out.println("Please enter First Name: ");
            firstName = scanner.nextLine().toUpperCase();

            System.out.println("Please enter Last Name: ");
            lastName = scanner.nextLine().toUpperCase();

            System.out.println("Please enter Phone Number: ");
            phoneNumber = scanner.nextLine();

            System.out.println("Please enter Email : ");
            email = scanner.nextLine().toUpperCase();

            Contact contact = new Contact(firstName, lastName, phoneNumber, email);
            treeMap.put(lastName, contact);

            System.out.println("Would you like to add another contact? ");
            addAnotherContact = scanner.nextLine();

        } while (addAnotherContact.equalsIgnoreCase("Y"));


        updateFile(treeMap, destinationFile);

    }

    static void updateFile(TreeMap<String, Contact> treeMap, String destinationFile) throws FileNotFoundException {
        File f = new File(destinationFile);

        PrintWriter output = new PrintWriter(f);

        // Display the TreeMap which is naturally sorted
        for (Map.Entry<String, Contact> entry : treeMap.entrySet()) {
            String info = entry.getValue().getLastName() +
                    " " + entry.getValue().getFirstName() +
                    " " + entry.getValue().getPhoneNumber() +
                    " " + entry.getValue().getEmail();
            output.println(info);
        }


        output.close();

    }

//    static void saveToFile(String someString, String destinationFile) throws FileNotFoundException {
//
//        File f = new File(destinationFile);
//
//        PrintWriter output = new PrintWriter(f);
//        output.println(someString);
//        output.close();
//    }

}
