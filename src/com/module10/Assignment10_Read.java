/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 10
 */

package com.module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment10_Read {

    public static void main(String[] args) throws FileNotFoundException, FileException {

        // Validates for 1 exact runtime parameters
        if (args.length != 1) {
            throw new FileException("ERROR: Missing Runtime Parameter. Must include only 1 runtime parameter \n" +
                    "1: Source File (Absolute Path)");
        }

        // Pass the path to the file as a parameter
        String path = args[0];
//        File file = new File("/Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/module10/read.txt");
        File file = new File(path);

        Scanner sc = new Scanner(file);
        String line;

        // Print out file onto console
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);

        }
    }
}
