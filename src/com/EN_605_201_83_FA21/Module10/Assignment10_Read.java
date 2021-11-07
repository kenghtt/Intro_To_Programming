/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 10
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment10_Read {
    public static void main(String[] args) throws FileNotFoundException, FileException {
        // Validates for 1 exact runtime parameters
        if (args.length != 2) {
            throw new FileException("ERROR: Incorrect Runtime Parameter. Must include only 2 runtime parameters \n" +
                    "1: Source File (Absolute Path) \n" +
                    "2: Integer of records printed (1-51)");
        }
        if (Integer.parseInt(args[1]) > 51 || Integer.parseInt(args[1]) <= 0) {
            throw new FileException("ERROR: Number of records must be an Integer of 1-51");
        }
        String path = args[0];  // Path of Source File
        File file = new File(path); // Pass the path to the file as a parameter

        int numberOfRecords = Integer.parseInt(args[1]) + 2; // Number of records plus 2  to accomodate for first two lines which includes header title and header line
        int counter = 0;    // counter to track number of records being printed

        Scanner sc = new Scanner(file);
        String line;
        System.out.println("");
        System.out.println("");
        System.out.println("File: " + path); // Prints out Path of Source File
        System.out.println("");

        // Print out file onto console
        while (sc.hasNextLine() && counter < numberOfRecords) {  // Checks that there still text in next line, and also that counter does not exceed numberOfRecords
            line = sc.nextLine();
            System.out.println(line);   // Print current line onto console
            counter++;  // increment counter
        }
    }
}
