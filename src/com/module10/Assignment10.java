package com.module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Assignment10 {


    public static void main(String[] args) throws FileNotFoundException {


        // pass the path to the file as a parameter
        File file = new File("/Users/jeremytouch/IdeaProjects/Intro_To_Programming/src/com/module10/test.txt");
        Scanner sc = new Scanner(file);
        String line = "";
        int counter = 0;

        String[] fipsStateCode = new String[13486]; //FIPS State code (00 for US record)
        String[] districtId = new String[13486];  //District ID
        String[] districtName = new String[13486];   //District Name
        String[] totalPopulation = new String[13486];    //Total Population
        String[] popByChildren = new String[13486];   //Population of Relevant Children 5 to 17 years of Age
        String[] popByChildrenInPoverty = new String[13486]; //Estimated Number of Relevant Children 5 to 17 years old in Poverty Related to the Householder
        String[] tag = new String[13486];    //A tag indicating the file name and date of creation

        while (sc.hasNextLine()) {


            line = sc.nextLine();
            fipsStateCode[counter] = line.substring(0, 2).trim();
            districtId[counter] = line.substring(3, 8).trim();
            districtName[counter] = line.substring(9, 81).trim();
            totalPopulation[counter] = line.substring(82, 90).trim();
            popByChildren[counter] = line.substring(91, 99).trim();
            System.out.println(line.substring(91, 99).trim());

            if(line.substring(91, 99).trim().equals("327")){
                System.out.println("");
            }

            popByChildrenInPoverty[counter] = line.substring(100, 108).trim();
            tag[counter] = line.substring(109, 129).trim();
//
//            System.out.println(counter);
//
            counter++;


        }

        System.out.println();

    }


}
