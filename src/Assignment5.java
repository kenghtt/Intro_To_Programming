
/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Assignment 5
 */

import java.util.Scanner;

public class Assignment5 {

    // Assigning a 2D matrix with English Characters and Morse Code
    static String[][] matrix = {{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"},
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                    ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
                    ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",}};

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Choose an option");
        System.out.println("1: English to Morse Code");
        System.out.println("2: Morse Code to English");
        Scanner scanner = new Scanner(System.in);       // Prompt User for which option to choose
        int option = scanner.nextInt();

        if (option == 1) {
            englishToMorseCode();   // Translate English to Morse Code
        } else if (option == 2) {
            morseCodeToEnglish();   // Translate Morse Code to English
        }
    }

    static void englishToMorseCode() {
        System.out.println();
        System.out.println("Type in an English sentence to be translated into Morse Code: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();               // Prompt User for English Sentence

        for (int i = 0; i < sentence.length(); i++) {       // Loop through each character in Sentence
            String letter = sentence.substring(i, i + 1);   // Current letter in for loop
            if (letter.equals(" ")) {                       // When the current character is a space, print out space
                System.out.print(" ");
            } else {
                System.out.print(getMorseCode(letter.toLowerCase()));   // Print out character in Morse Code
            }
        }
    }

    static String getMorseCode(String letter) {

        for (int i = 0; i < matrix[0].length; i++) {        // Loop through 2D Matrix
            if (matrix[0][i].equals(letter)) {              // Get English Letter that is equivalent to Morse Code in Matrix
                return matrix[1][i];                        // Return Morse Code
            }
        }

        return "";
    }

    static void morseCodeToEnglish() {

        System.out.println("Type in a Morse Code sentence to be translated into English: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();               // Prompt User for Morse Code Sentence

        StringBuilder ditDahLetter = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {       // Loop through each Morse Code character in sentence
            String ditDah = sentence.substring(i, i + 1);   // Current Dit Dah character
            if (ditDah.equals("|")) {                       // When current character is a "|", print out space
                System.out.print(" ");
            } else if (ditDah.equals(" ")) {                // When current character is a space, then it is a new word
                System.out.print(getEnglishTranslation(ditDahLetter.toString()));       // Print out to English Character
                ditDahLetter = new StringBuilder();         // Reset String Builder
            } else {
                ditDahLetter.append(ditDah);                // Append to String Builder
            }
        }
        if (ditDahLetter.length() != 0) {
            System.out.print(getEnglishTranslation(ditDahLetter.toString()));   // Print out final english character
        }
    }

    static String getEnglishTranslation(String ditDahLetter) {
        for (int i = 0; i < matrix[0].length; i++) {        // Loop through 2D Matrix
            if (matrix[1][i].equals(ditDahLetter)) {        // Get Morse Code Character that is equivalent to English Character in Matrix
                return matrix[0][i];                        // Return English Character
            }
        }
        return "";
    }

}
