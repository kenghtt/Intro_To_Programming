package com.MiniProject2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BlackJackGameSimulator {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Cards> fullDeck = generateDeck();
        Stack<Cards> deck = shuffleDeck(new ArrayList<Cards>(fullDeck));

        System.out.println("Welcome To The Black Jack Table!");
        System.out.println("How much would you like to start off with?");
        System.out.println("Please input a positive integer: ");
        String result;
        int cashAmount = 0;
        Scanner scanner = new Scanner(System.in);
        while (cashAmount <= 0) {
            cashAmount = Integer.parseInt(scanner.nextLine());
            if (cashAmount <= 0) {
                System.out.println("You must input an integer greater than 0. Please try again!");
            }
        }


        int betAmount = 0;

        while (cashAmount > 0) {
            if (deck.size() < 10) {
                deck = shuffleDeck(new ArrayList<Cards>(fullDeck));
            }
            System.out.println("How much will you bet this round?: ");

            betAmount = Integer.parseInt(scanner.nextLine());

            while (betAmount > cashAmount || betAmount <= 0) {
                if (betAmount <= 0) {
                    System.out.println("You cannot bet a negative amount. Please try again!: ");

                } else {
                    System.out.println("You cannot bet more than what you have. Please try again!: ");
                }
                betAmount = Integer.parseInt(scanner.nextLine());
            }
            result = playRound(deck);


            if (result.equals("Win")) {
                // Win
                System.out.println("");
                System.out.println("WINNER!!!");
                System.out.println("You Won: $" + betAmount);
                cashAmount += betAmount;
            } else if (result.equals("Lose")) {
                // Lose
                System.out.println("");
                System.out.println("LOSER!!!");
                System.out.println("You Lost: $" + betAmount);
                cashAmount -= betAmount;
            } else {
                System.out.println("It was a draw");

            }
            System.out.println("");

            System.out.println("Player remaining amount: $" + cashAmount);

            if (cashAmount <= 0) {
                System.out.println("You do not have enough to continue!");
                break;
            }
            System.out.println("");
            System.out.println("Do you want to play another round?: ");
            System.out.println("Y for Yes ");
            System.out.println("N for No ");

            String playAgain = scanner.nextLine();

            while (!playAgain.equalsIgnoreCase("N") && !playAgain.equalsIgnoreCase("Y")) {

                System.out.println("YOU MUST ENTER A VALID NUMBER! Please Try again!!!!!");
                System.out.println("Do you want to play another round?: ");
                System.out.println("Y for Yes ");
                System.out.println("N for No ");

            }

            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }

        }
        System.out.println("Thank You for playing!!!");
    }

    static String playRound(Stack<Cards> deck) throws InterruptedException {
        ArrayList<Cards> dealerHand = new ArrayList<>();
        ArrayList<Cards> playerHand = new ArrayList<>();
        int playerScore = 0;
        int dealerScore = 0;
        boolean stand = false;

        // Deal initial cards
        dealCard(deck, dealerHand);
        dealCard(deck, playerHand);
        dealCard(deck, dealerHand);
        dealCard(deck, playerHand);

        getUnrevealedDealerHand(dealerHand);
        System.out.println("");
        playerScore = getHand(playerHand, "Player");

        if (playerScore == 21) {
            return "Win";    // Player wins
        }

        // Deal for player
        while (playerScore < 21 && !stand) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("Please enter 1 or 2: ");

            String choice;


            choice = scanner.nextLine();

            while (!choice.equals("1") && !choice.equals("2")) {
                System.out.println("");
                System.out.println("YOU MUST ENTER A VALID OPTION! Please Try again!!!!!");
                System.out.println("1. Hit");
                System.out.println("2. Stand");
                System.out.println("Please enter 1 or 2: ");

                choice = scanner.nextLine();

            }

            if (choice.equals("2")) {   // Stand
                stand = true;
            } else {                    // Hit
                dealCard(deck, playerHand);
                playerScore = getHand(playerHand, "Player");
                if (playerScore > 21) {
                    System.out.println("");
                    System.out.println("BUST!!!!");
                    return "Lose";   // Player loses
                } else if (playerScore == 21) {
//                    return "Win";    // Player wins
                    continue;
                }
            }
        }


        while (dealerScore < 16) {
            dealCard(deck, dealerHand);
            dealerScore = getHand(dealerHand, "Dealer");
            Thread.sleep(2000);

        }

        if (dealerScore > 21) {
            return "Win"; // player wins
        } else if (dealerScore < playerScore) {
            return "Win"; // player wins
        } else if (dealerScore == playerScore) {
            return "Draw";
        }
        return "Lose";

    }


    static void dealCard(Stack<Cards> deck, ArrayList<Cards> hand) {

        hand.add(deck.pop());

    }


    private static void getUnrevealedDealerHand(ArrayList<Cards> dealerHand) {
        System.out.println("");
        System.out.println("Dealer Hand: ");
        System.out.println("? Hidden");

        int secondHand = dealerHand.get(1).getNumber();
        if (secondHand == 1) {
            System.out.println("A " + dealerHand.get(1).getSuit());
        } else if (secondHand == 11) {
            System.out.println("J " + dealerHand.get(1).getSuit());
        } else if (secondHand == 12) {
            System.out.println("Q " + dealerHand.get(1).getSuit());
        } else if (secondHand == 13) {
            System.out.println("K " + dealerHand.get(1).getSuit());
        } else {
            System.out.println(secondHand + " " + dealerHand.get(1).getSuit());

        }


        System.out.println("---");
        System.out.println("total: " + "?");


    }

    private static int getHand(ArrayList<Cards> playerHand, String hand) {
        int sumOfCards = 0;
        int aceCounter = 0;
        System.out.println("");
        System.out.println(hand + " Hand: ");
        for (Cards card : playerHand
        ) {

            if (card.getNumber() == 1) {
                aceCounter++;
                sumOfCards += 11;
                System.out.println("A " + card.getSuit());
            } else if (card.getNumber() == 11) {
                sumOfCards += 10;
                System.out.println("J " + card.getSuit());

            } else if (card.getNumber() == 12) {
                sumOfCards += 10;
                System.out.println("Q " + card.getSuit());


            } else if (card.getNumber() == 13) {
                sumOfCards += 10;
                System.out.println("K " + card.getSuit());


            } else {
                sumOfCards += card.getNumber();
                System.out.println(card.getNumber() + " " + card.getSuit());
            }


        }

        if (sumOfCards > 21) {
            for (int i = 0; i < aceCounter; i++) {
                sumOfCards -= 10;
                if (sumOfCards <= 21) {
                    break;
                }

            }
        }


        System.out.println("---");
        System.out.println("total: " + sumOfCards);
        return sumOfCards;

    }

    private static Stack<Cards> shuffleDeck(ArrayList<Cards> arrayDeck) {
        Stack<Cards> cards = new Stack<>();
        while (arrayDeck.size() > 1) {

            int index = (int) ((arrayDeck.size() - 1) * Math.random()) + 1;
            cards.push(arrayDeck.get(index));
            arrayDeck.remove(index);

        }
        cards.push(arrayDeck.get(0));

        return cards;

    }

    static ArrayList<Cards> generateDeck() {

        ArrayList<Cards> deck = new ArrayList<>();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        String[] suits = {"Hearts", "Diamonds", "Clovers", "Spades"};

        for (String suit : suits) {
            for (int number : numbers) {
                deck.add(new Cards(number, suit));
            }

        }

        return deck;

    }
}
