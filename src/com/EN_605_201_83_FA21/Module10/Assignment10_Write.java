
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment10_Write {


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

//        Scanner keyboardInput = new Scanner(System.in);
//        System.out.println("Enter the name of the text file (with .txt): ");
//        String fileName = keyboardInput.next();
        String fileName = "hello.txt";

        File f = new File(fileName);

        // write records for two parts to the file & close it
        PrintWriter output = new PrintWriter(f);

        StringBuffer header = new StringBuffer();

        header.append("State");
        addWhiteSpace(header, 8).toString();

        header.append("District Id");
        addWhiteSpace(header, 22).toString();

        header.append("District Name");
        addWhiteSpace(header, 88).toString();

        header.append("Total Population");
        addWhiteSpace(header, 107).toString();

        header.append("Child Population");
        addWhiteSpace(header, 126).toString();

        header.append("Child Poverty Population");
        addWhiteSpace(header, 153).toString();

        header.append("Tag");
        addWhiteSpace(header, 173).toString();

        output.println(header);


        StringBuffer headerLine = new StringBuffer();

        headerLine.append("-----");
        addWhiteSpace(headerLine, 8).toString();

        headerLine.append("-----------");
        addWhiteSpace(headerLine, 22).toString();

        headerLine.append("-------------");
        addWhiteSpace(headerLine, 88).toString();

        headerLine.append("----------------");
        addWhiteSpace(headerLine, 107).toString();

        headerLine.append("----------------");
        addWhiteSpace(headerLine, 126).toString();

        headerLine.append("------------------------");
        addWhiteSpace(headerLine, 153).toString();

        headerLine.append("---");
        addWhiteSpace(headerLine, 17).toString();

        output.println(headerLine);

        for (int i = 0; i < fipsStateCode.length; i++) {
            StringBuffer text = new StringBuffer();

            text.append(fipsStateCode[i]);
            addWhiteSpace(text, 8).toString();

            text.append(districtId[i]);
            addWhiteSpace(text, 22).toString();

            text.append(districtName[i]);
            addWhiteSpace(text, 88).toString();

            text.append(totalPopulation[i]);
            addWhiteSpace(text, 107).toString();

            text.append(popByChildren[i]);
            addWhiteSpace(text, 126).toString();

            text.append(popByChildrenInPoverty[i]);
            addWhiteSpace(text, 153).toString();

            text.append(tag[i]);
            addWhiteSpace(text, 17).toString();

            output.println(text);
        }
        output.close();

    }

    static StringBuffer addWhiteSpace(StringBuffer stringBuffer, int maxLength) {
//        int counter = 1;
        while (stringBuffer.length() < maxLength) {
//            stringBuffer.append(counter);
            stringBuffer.append(" ");

//            counter++;
        }

        return stringBuffer;


    }
}
