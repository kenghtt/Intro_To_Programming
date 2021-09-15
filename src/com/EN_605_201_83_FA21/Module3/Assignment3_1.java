
/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 3 part 1
 */


import java.util.Scanner;

class Assignment3_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number that represents the maximum number of asterisks (*) to display: ");
        int numOfAsterisk = scanner.nextInt();
        System.out.print("\n");
        System.out.println("Choice 1 - Display from smallest to largest");
        System.out.println("Choice 2 - Display from largest to smallest");
        System.out.print("Enter a number for Choice 1 or 2: ");

        int choice = scanner.nextInt();
        System.out.print("\n");


        if (choice == 1) {
            for (int row = 0; row < numOfAsterisk; row++) {
                for (int col = 0; col <= row; col++) {

                    System.out.print("*");

                }
                System.out.println();
            }
            System.out.print("\n");
        } else if (choice == 2) {
            for (int row = 0; row < numOfAsterisk; row++) {
                for (int col = row; col < numOfAsterisk; col++) {

                    System.out.print("*");

                }
                System.out.println();
            }
            System.out.print("\n");

        } else {
            System.out.println("Invalid Choice!");
        }


    }
}
