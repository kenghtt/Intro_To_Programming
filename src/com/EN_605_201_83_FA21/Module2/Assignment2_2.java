/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 2 part 2
 */


import java.util.Scanner;

public class Assignment2_2 {
    public static void main(String[] args) {
        // Define and initialize variables for values to be input
        double weightInPounds = 0;      // First value to be input
        double heightInInches = 0;      // Second value to be input
        double weightInKilos = 0;
        double heightInMeters = 0;
        double bmi = 0;

        // Use a Scanner to input integer values
        Scanner input = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Enter a weight by pounds:");
        weightInPounds = input.nextInt();     // Input first value
        System.out.print("Enter a height by inches:");
        heightInInches = input.nextInt();     // Input second value

        // Given that one pound is 0.45359237 kilograms and one inch is 0.0254 meters.
//        Formula: 703 x weight (lbs) / [height (in)]2

        weightInKilos = weightInPounds * 0.45359237;
        heightInMeters = heightInInches * 0.0254;
        bmi = weightInKilos / (heightInMeters * heightInMeters);

        System.out.println("\n");

        System.out.println("Your BMI is: "+ bmi);



        // Output using System.out.println()
        System.out.println("\n");
        System.out.println("Underweight: less than 18.5 ");
        System.out.println("Normal: 18.5 – 24.9 ");
        System.out.println("Overweight: 25 – 29.9 ");
        System.out.println("Obese: 30 or greater ");
        System.out.println("\n\n");
    }
}
