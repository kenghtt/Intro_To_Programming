/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 2 part 2
 */


import java.util.Scanner;

public class Assignment2_2 {
    public static void main(String[] args) {
        // Define and initialize variables for values to be input
        double weightInPounds = 0;
        double heightInInches = 0;

        double weightInKilos = 0;
        double heightInMeters = 0;
        double bmi = 0;

        // Use a Scanner to input values
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Enter a weight by pounds:");
        weightInPounds = input.nextInt();     // Input first value
        System.out.print("Enter a height by inches:");
        heightInInches = input.nextInt();     // Input second value

        // Given that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.
        weightInKilos = weightInPounds * 0.45359237;
        heightInMeters = heightInInches * 0.0254;

        bmi = weightInKilos / (heightInMeters * heightInMeters); //

        System.out.println("");
        // Output using System.out.println()
        System.out.println("Your BMI is: "+ bmi);
        System.out.println("");
        System.out.println("\tUnderweight: less than 18.5 ");
        System.out.println("\tNormal: 18.5 – 24.9 ");
        System.out.println("\tOverweight: 25 – 29.9 ");
        System.out.println("\tObese: 30 or greater ");
        System.out.println("");
    }
}
