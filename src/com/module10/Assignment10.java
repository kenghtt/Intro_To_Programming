package com.module10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
            popByChildrenInPoverty[counter] = line.substring(100, 108).trim();
            tag[counter] = line.substring(109, 129).trim();
            counter++;
        }


        // test if the file already exists
//        if( f.exists() )
//        {
//            System.out.println( "File already exists. Program ending." );
//            System.exit( 1 );
//        }
//        else
//            System.out.println( "New file being created." );

        saveToFile(fipsStateCode, districtId, districtName, totalPopulation, popByChildren, popByChildrenInPoverty, tag);


        System.out.println();

    }


    static void saveToFile(String[] fipsStateCode, String[] districtId, String[] districtName, String[] totalPopulation, String[] popByChildren, String[] popByChildrenInPoverty, String[] tag) throws FileNotFoundException {

        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Enter the name of the text file (with .txt): ");
        String fileName = keyboardInput.next();
        File f = new File( fileName );

        // write records for two parts to the file & close it
        PrintWriter output = new PrintWriter(f);
        output.println(fipsStateCode[0]+" "+districtId[0]+" "+ districtName[0]+" "+totalPopulation[0]+ " "+ popByChildren[0]+" " + popByChildrenInPoverty[0] + " " + tag[0]);
        output.print("PartNumber100 ");
        output.close();


//        for(int i = 0; i<fipsStateCode.length; i++){
//
//            output.println(fipsStateCode[i]+ "  ");
//            output.print("PartNumber100 ");
//            output.close();
//
//
//        }
    }
}
