/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 3 part 2
 */

import java.util.Scanner;

public class Assignment3_2 {

    public static void main(String[] args) {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the highest number the secret number can be: ");
        int maxNumber = scanner.nextInt();
        System.out.println("\n");
        System.out.print("Please enter the maximum number of attempts: ");
        int maxAttempt = scanner.nextInt();
        System.out.println("\n");

        int currentAttempt = 0;

        String tryAgain;

        int randomNumber;

        do {
            currentAttempt = 0;
            randomNumber = (int) (maxNumber * Math.random()) + 1;
            while (currentAttempt < maxAttempt) {

                System.out.print("Please guess the secret number between 1 - " + maxNumber + ": ");
                int currentNumber = scanner.nextInt();

                if (randomNumber == currentNumber) {
                    System.out.println("“correct”");
                    break;
                } else if (randomNumber < currentNumber) {
                    System.out.println("too high");
                } else {
                    System.out.println("too low");
                }

                currentAttempt++;
            }

            System.out.print("Would you like to play again? Y or N : ");
            tryAgain = scanner.next();

        } while (tryAgain.toUpperCase().equals("Y"));

    }

}
