package com.Module11;

/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 11 part 2
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Assignment11_2 {

    public static void main(String args[]) {

        int id = 0; // Print Job  Id
        String addPrintJob = "";
        Scanner scanner = new Scanner(System.in);
        LinkedList<Job> linkedList = new LinkedList<>();    // A list to store the jobs in the queue

        do {
            System.out.println("Adding Job to Print Queue!!!");
            Random ran = new Random();  // Creates a random number between 10-1000
            int printTime = ran.nextInt(1000) + 10;     // This is the print time in seconds

            linkedList.add(new Job(id, printTime));
            id++;
            System.out.println("Would you like to add another print job to the Queue ");
            addPrintJob = scanner.nextLine();

            while (!addPrintJob.equalsIgnoreCase("Y") && !addPrintJob.equalsIgnoreCase("N")) {   // Validation for proper response
                System.out.println("Invalid Choise. Type in Y or N ");
                addPrintJob = scanner.nextLine();
            }
        } while (addPrintJob.equalsIgnoreCase("Y"));


        displayPrintJobQueue(linkedList);   // Display Print Jobs in Queue
    }

    /**
     * This method displays the print jobs remaining in queue
     *
     * @param linkedList contains the print jobs in a list
     */
    static void displayPrintJobQueue(LinkedList<Job> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            Job job = linkedList.get(i);
            System.out.println("Job#: " + job.getId() + ", Print Time: " + job.getPrintTime() + " seconds");
        }
    }
}
