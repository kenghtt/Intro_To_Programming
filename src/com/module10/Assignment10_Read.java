package com.module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment10_Read {

    public static void main(String[] args) throws FileNotFoundException {

        // pass the path to the file as a parameter
        File file = new File("/Users/jeremytouch/IdeaProjects/Intro_To_Programming/hello.txt");
        Scanner sc = new Scanner(file);
        String line = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine();

            System.out.println(line);

        }

    }


}
