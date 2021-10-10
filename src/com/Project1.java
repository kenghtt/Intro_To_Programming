package com;

/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Mini Project 1
 */


class Project1 {
    public static void main(String[] args) throws InterruptedException {

        int maxPosition = 50;   // Maximum Position to reach the finish line

        int harePosition = 1;   // Starting position for Hare
        int tortoisePosition = 1;   // Starting position for Tortoise

        // Initial Display Information
        System.out.println("AND THEY'RE OFF");
        System.out.println("H");
        System.out.println("T");
        System.out.println();

        while (harePosition < maxPosition && tortoisePosition < maxPosition) {

            Thread.sleep(500);

            harePosition += getHareNextPosition(); // Get Hare's next position

            if (harePosition < 1) { // Reset Hare position if it goes below 1
                harePosition = 1;
            }

            tortoisePosition += getTortoiseNextPosition(); // Get Tortoise's next position

            if (tortoisePosition < 1) { // Reset Tortoise position if it goes below 1
                tortoisePosition = 1;
            }

            displayPosition(harePosition, "H"); // Display Hare's position
            System.out.println();
            displayPosition(tortoisePosition, "T"); // Display Tortoise's position
            System.out.println();

            if (harePosition == tortoisePosition) { // Display OUCHH when both are in same position
                System.out.println("OUCH!!");
            }
            System.out.println();

        }

        // Result of Race
        if (harePosition > tortoisePosition) {
            System.out.println("HARE WINS!!");
        } else if (harePosition < tortoisePosition) {
            System.out.println("TORTOISE WINS!!");
        } else {
            System.out.println("IT'S A TIE!!");
        }


    }

    static int getHareNextPosition() {
        int num = generateRandomNumber(); // Generate random number between 1-10

        if (num == 1 || num == 2) {
            // BIG HOP
            return 9;
        } else if (num == 3 || num == 4 || num == 5) {
            // SMALL HOP
            return 1;
        } else if (num == 6) {
            // BIG SLIP
            return -12;
        } else if (num == 7 || num == 8) {
            // SMALL SLIP
            return -2;
        } else {
            // FALL ASLEEP
            return 0;
        }
    }

    static int getTortoiseNextPosition() {
        int num = generateRandomNumber(); // Generate random number between 1-10

        if (num <= 5) {
            // FAST PLOD
            return 3;
        } else if (num == 6 || num == 7 || num == 8) {
            // SLOW PLOD
            return 1;
        } else {
            // SLIP
            return -6;
        }
    }

    static int generateRandomNumber() {
        return (int) (10 * Math.random()) + 1;
    }

    static void displayPosition(int position, String letter) {
        for (int i = 0; i < position; i++) {
            if(i != position-1){
                System.out.print("_");
            } else
                System.out.print(letter);
        }

    }

}

