package com.MiniProject2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BlackJackGameSimulator {

    public static void main(String[] args) {


        ArrayList<Cards> fullDeck = generateDeck();
        Stack<Cards> deck = shuffleDeck(new ArrayList<Cards>(fullDeck));

        System.out.println("Welcome To The Black Jack Table!");
        System.out.println("How much would you like to start off with?");
        System.out.println("Please input a positive integer: ");


        Scanner scanner = new Scanner(System.in);
        int cashAmount = Integer.parseInt(scanner.nextLine());

//        while (cashAmount > 0) {
        if (deck.size() < 10) {
            deck = shuffleDeck(new ArrayList<Cards>(fullDeck));
        }
        ArrayList<Cards> dealerHand = new ArrayList<>();
        ArrayList<Cards> playerHand = new ArrayList<>();

        System.out.println("How much will you bet this round?: ");
        int betAmount = Integer.parseInt(scanner.nextLine());
        dealInitialCards(deck, playerHand, dealerHand);


//        }


        System.out.println();


    }

    static void dealInitialCards(Stack<Cards> deck, ArrayList<Cards> playerHand, ArrayList<Cards> dealerHand) {

        Cards card1 = deck.pop();
        playerHand.add(card1);

        Cards card2 = deck.pop();
        dealerHand.add(card2);

        Cards card3 = deck.pop();
        playerHand.add(card3);

        Cards card4 = deck.pop();
        dealerHand.add(card4);

//        System.out.println("Dealer Hand: " + dealerHand.get(1).getNumber() + ":?");
//        System.out.println("");
//        System.out.println("Player Hand: " + playerHand.get(0).getNumber() + ":" + playerHand.get(1).getNumber());


        getUnrevealedDealerHand(dealerHand);
        System.out.println("");
        getPlayerHand(playerHand);


    }

    private static void getUnrevealedDealerHand(ArrayList<Cards> dealerHand) {
        System.out.println("?");
        System.out.println("Dealer Hand: " + dealerHand.get(1).getNumber() + ":?");

    }

    private static int getPlayerHand(ArrayList<Cards> playerHand) {
        int sumOfCards = 0;
        System.out.println("Player Hand: ");
        for (Cards card : playerHand
        ) {
            sumOfCards += card.getNumber();
            System.out.println(card.getNumber() + " " + card.getSuit());
        }
        System.out.println("---");
        System.out.println("total: "+ sumOfCards);
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
