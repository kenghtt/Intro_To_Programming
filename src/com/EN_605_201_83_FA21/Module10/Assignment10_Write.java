/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 10
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment10_Write {

    public static void main(String[] args) throws FileNotFoundException, FileException {

        // Validates for 3 exact runtime parameters
        if (args.length != 2) {
            throw new FileException("ERROR: Missing Runtime Parameters. Must be inserted in this order: \n" +
                    "1: Source File (Absolute Path) \n" +
                    "2: Destination File (Absolute Path) \n");
        }

        // Pass the path to the file as a parameter
        File sourceFile = new File(args[0]);

        Scanner sc = new Scanner(sourceFile);
        String line = "";
        int counter = 0;
        int numOfRows = 51;

        String destinationFile = args[1];

        String[] stateCodeArray = new String[51]; // FIPS State code
        int[] totalPopulationArray = new int[51];    // Total Population
        int[] popByChildrenArray = new int[51];   // Population of Relevant Children 5 to 17 years of Age
        int[] popByChildrenInPovertyArray = new int[51]; // Estimated Number of Relevant Children 5 to 17 years old in Poverty Related to the Householder
        float[] childPovertyPercent = new float[51];    // Percent of Child Poverty

        String stateCode = "01";
        int totalPopulation = 0;
        int popByChildren = 0;
        int popByChildrenInPoverty = 0;

        while (sc.hasNextLine() && counter < numOfRows) {
            line = sc.nextLine();

            if (!line.substring(0, 2).trim().equals(stateCode) || !sc.hasNextLine()) {
                stateCodeArray[counter] = stateCode;
                totalPopulationArray[counter] = totalPopulation;
                popByChildrenArray[counter] = popByChildren;
                popByChildrenInPovertyArray[counter] = popByChildrenInPoverty;
                childPovertyPercent[counter] = (float) popByChildrenInPoverty / popByChildren * 100;

                totalPopulation = 0;
                popByChildren = 0;
                popByChildrenInPoverty = 0;

                counter++;
            }
            stateCode = line.substring(0, 2).trim();
            totalPopulation += Integer.parseInt(line.substring(82, 90).trim());
            popByChildren += Integer.parseInt(line.substring(91, 99).trim());
            popByChildrenInPoverty += Integer.parseInt(line.substring(100, 108).trim());
        }

        saveToFile(stateCodeArray, totalPopulationArray, popByChildrenArray, popByChildrenInPovertyArray, childPovertyPercent, destinationFile);
        System.out.println("Succesfully Saved!");
    }

    /**
     * @param stateCodeArray:              Array consisting of all state codes
     * @param totalPopulationArray:        Array of total population in each state
     * @param popByChildrenArray:          Array of total children population in each state
     * @param popByChildrenInPovertyArray: Array of total children population who are in poverty in each state
     * @param childPovertyPercent:         Array of percent of child poverty in each state
     * @throws FileNotFoundException: Throws exception when file not found
     */
    static void saveToFile(String[] stateCodeArray, int[] totalPopulationArray, int[] popByChildrenArray, int[] popByChildrenInPovertyArray, float[] childPovertyPercent, String destinationFile) throws FileNotFoundException {

        File f = new File(destinationFile);

        PrintWriter output = new PrintWriter(f);
        addHeaders(output);
        addBody(output, stateCodeArray, totalPopulationArray, popByChildrenArray, popByChildrenInPovertyArray, childPovertyPercent);
        output.close();
    }

    /**
     * @param output: Standard Reusable PrintWriter Output
     */
    static void addHeaders(PrintWriter output) {

        // Header Titles
        StringBuffer header = new StringBuffer();

        header.append("State");
        addWhiteSpace(header, 8);

        header.append("Total Population");
        addWhiteSpace(header, 30);

        header.append("Child Population");
        addWhiteSpace(header, 50);

        header.append("Child Poverty Population");
        addWhiteSpace(header, 80);

        header.append("% Child Poverty");
        addWhiteSpace(header, 100);

        // Print Header Title
        output.println(header);

        // Header Line
        StringBuffer headerLine = new StringBuffer();

        headerLine.append("-----");
        addWhiteSpace(headerLine, 8);

        headerLine.append("----------------");
        addWhiteSpace(headerLine, 30);

        headerLine.append("----------------");
        addWhiteSpace(headerLine, 50);

        headerLine.append("------------------------");
        addWhiteSpace(headerLine, 80);

        headerLine.append("---------------");
        addWhiteSpace(headerLine, 100);

        // Print Header Lines
        output.println(headerLine);
    }

    /**
     * @param output:                      Standard Reusable PrintWriter Output
     * @param stateCodeArray:              Array consisting of all state codes
     * @param totalPopulationArray:        Array of total population in each state
     * @param popByChildrenArray:          Array of total children population in each state
     * @param popByChildrenInPovertyArray: Array of total children population who are in poverty in each state
     * @param childPovertyPercent:         Array of percent of child poverty in each state
     */
    static void addBody(PrintWriter output, String[] stateCodeArray, int[] totalPopulationArray, int[] popByChildrenArray, int[] popByChildrenInPovertyArray, float[] childPovertyPercent) {

        for (int i = 0; i < stateCodeArray.length; i++) {
            StringBuffer text = new StringBuffer();

            text.append(stateCodeArray[i]);
            addWhiteSpace(text, 8);

            text.append(totalPopulationArray[i]);
            addWhiteSpace(text, 30);

            text.append(popByChildrenArray[i]);
            addWhiteSpace(text, 50);

            text.append(popByChildrenInPovertyArray[i]);
            addWhiteSpace(text, 80);

            text.append(childPovertyPercent[i]);
            addWhiteSpace(text, 100);

            output.println(text);
        }
    }

    /**
     * @param stringBuffer: Standard StringBuffer
     * @param maxLength:    Maximum length of including white space for each column in table
     */
    static void addWhiteSpace(StringBuffer stringBuffer, int maxLength) {
        while (stringBuffer.length() < maxLength) {
            stringBuffer.append(" ");
        }
    }
}
