/**
 * @author Jeremy Yang
 * EN.605.201.81.FA21
 * Mini Project 2
 * This the main class for the Black Jack Game Simulator
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BlackJackGameSimulator {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Cards> fullDeck = generateDeck();        // Generate deck with 52 cards
        Stack<Cards> deck = shuffleDeck(new ArrayList<Cards>(fullDeck));    // Shuffle Deck into a Stack

        System.out.println("Welcome To The Black Jack Table!");
        System.out.println("How much would you like to start off with?");
        System.out.println("Please input a positive integer: ");
        String result;
        int cashAmount = 0;
        int betAmount = 0;

        Scanner scanner = new Scanner(System.in);

        while (cashAmount <= 0) {
            cashAmount = Integer.parseInt(scanner.nextLine());
            if (cashAmount <= 0) {
                System.out.println("You must input an integer greater than 0. Please try again!");
            }
        }

        while (cashAmount > 0) {
            if (deck.size() < 10) {      // If the current deck is less than 10 cards, re shuffle deck to 52 cards
                deck = shuffleDeck(new ArrayList<Cards>(fullDeck));
            }
            System.out.println("How much will you bet this round?: ");
            betAmount = Integer.parseInt(scanner.nextLine());

            while (betAmount > cashAmount || betAmount <= 0) {      // Validate Bet Amount
                if (betAmount <= 0) {
                    System.out.println("You cannot bet a negative amount. Please try again!: ");
                } else {
                    System.out.println("You cannot bet more than what you have. Please try again!: ");
                }
                betAmount = Integer.parseInt(scanner.nextLine());
            }
            result = playRound(deck);        // Play the round

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
                // Draw
                System.out.println("It was a draw");
            }
            System.out.println("");
            System.out.println("Player remaining amount: $" + cashAmount);

            if (cashAmount <= 0) {      // Quit game if Player does not have enough cash to continue
                System.out.println("You do not have enough to continue!");
                break;
            }
            System.out.println("");
            System.out.println("Do you want to play another round?: ");     // Prompt Player for another round
            System.out.println("Y for Yes ");
            System.out.println("N for No ");

            String playAgain = scanner.nextLine();

            while (!playAgain.equalsIgnoreCase("N") && !playAgain.equalsIgnoreCase("Y")) {  // Validate proper response
                System.out.println("YOU MUST ENTER A VALID NUMBER! Please Try again!!!!!");
                System.out.println("Do you want to play another round?: ");
                System.out.println("Y for Yes ");
                System.out.println("N for No ");
                playAgain = scanner.nextLine();
            }

            if (playAgain.equalsIgnoreCase("N")) {      // Quit Game
                break;
            }
        }
        System.out.println("Thank You for playing!!!");
    }

    /**
     * This method simulates the round for the player and dealer
     *
     * @param cardStack This is the current deck available for this round
     * @return A string value is returned indicating whether the player Won, Lost, or Draw
     * @throws InterruptedException Exception is thrown for the thread sleeper, this allows turn to slow down for Dealer's turn
     */
    static String playRound(Stack<Cards> cardStack) throws InterruptedException {
        Players player = new Players(new ArrayList<>());    // Create Player object
        Players dealer = new Players(new ArrayList<>());    // Create Dealer object

        int playerScore = 0;
        int dealerScore = 0;
        boolean stand = false;

        // Deal initial cards to Dealer and Player
        dealCard(cardStack, dealer.getCards());
        dealCard(cardStack, player.getCards());
        dealCard(cardStack, dealer.getCards());
        dealCard(cardStack, player.getCards());

        // Display Dealer's Initial Hand
        dealerScore = getUnrevealedDealerHand(dealer.getCards());
        System.out.println("");

        // Display Player's Initial hand
        playerScore = getHand(player.getCards(), "Player");

        if (playerScore == 21) {
            return "Win";    // Player gets a Black Jack, player wins automatically
        }
        // Deal for player
        while (playerScore < 21 && !stand) {
            System.out.println("");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("Please enter 1 or 2: ");

            Scanner scanner = new Scanner(System.in);
            String choice;
            choice = scanner.nextLine();

            while (!choice.equals("1") && !choice.equals("2")) {        // Validate player option for HIT or STAND
                System.out.println("");
                System.out.println("YOU MUST ENTER A VALID OPTION! Please Try again!!!!!");
                System.out.println("1. Hit");
                System.out.println("2. Stand");
                System.out.println("Please enter 1 or 2: ");

                choice = scanner.nextLine();
            }

            if (choice.equals("2")) {           // Stand
                stand = true;
            } else {                            // Hit
                dealCard(cardStack, player.getCards());
                playerScore = getHand(player.getCards(), "Player");
                if (playerScore > 21) {
                    System.out.println("");
                    System.out.println("BUST!!!!");
                    return "Lose";              // Player loses
                } else if (playerScore == 21) {
                    continue;                   // Player will default to stand if they get a score of 21
                }
            }
        }

        if (dealerScore >= 16) {
            Thread.sleep(2000);
            dealerScore = getHand(dealer.getCards(), "Dealer");
        }
        while (dealerScore < 16) {
            dealCard(cardStack, dealer.getCards());
            dealerScore = getHand(dealer.getCards(), "Dealer");
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

    /**
     * This method prints the dealer's initial hand, which includes one card faced up and one hidden. This also calculates the inital
     * score of the dealer's hand.
     *
     * @param dealerHand This is the cards that the dealer was dealt
     * @return An int value indicating the score of the hand is returned
     */
    private static int getUnrevealedDealerHand(ArrayList<Cards> dealerHand) {
        int dealerScore = 0;
        int aceCounter = 0;
        System.out.println("");
        System.out.println("Dealer Hand: ");
        System.out.println("? Hidden");
        int firstHand = dealerHand.get(0).getNumber();
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

        if (firstHand == 1) {
            dealerScore += 11;
            aceCounter++;
        } else dealerScore += Math.min(firstHand, 10);

        if (secondHand == 1) {
            dealerScore += 11;
            aceCounter++;
        } else dealerScore += Math.min(secondHand, 10);

        if (aceCounter == 2) {
            dealerScore -= 10;
        }

        dealerScore += Math.min(dealerHand.get(0).getNumber(), 10);
        dealerScore += Math.min(dealerHand.get(1).getNumber(), 10);

        return dealerScore;
    }

    /**
     * This method prints the player/dealer hand. This also calculates the score for the player/dealer
     *
     * @param playerHand This is the cards that is delt to the player/dealer
     * @param hand This indicates who the hand belongs to (dealer/player)
     * @return An int value indicating the current score value is returned
     */
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

    /**
     * This method generates a standard 52 deck with 4 suits.
     * @return An arraylist of type Card is returned.
     */
    public static ArrayList<Cards> generateDeck() {
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

    /**
     * This method shuffles the deck by randomly selecting indexes in the Arraylist of cards, and pushing it into the Stack
     * @param arrayDeck This is the deck of 52 cards.
     * @return A stack of type Cards is returned which contains 52 cards in random order.
     */
    public static Stack<Cards> shuffleDeck(ArrayList<Cards> arrayDeck) {
        Stack<Cards> cards = new Stack<>();
        while (arrayDeck.size() > 1) {
            int index = (int) ((arrayDeck.size() - 1) * Math.random()) + 1;
            cards.push(arrayDeck.get(index));
            arrayDeck.remove(index);
        }
        cards.push(arrayDeck.get(0));
        return cards;
    }

    /**
     * This method deals a card to the player/dealer
     * @param deck A stack containing the remaining cards in the deck
     * @param hand An arraylist containing the player/dealer's current hand
     */
    public static void dealCard(Stack<Cards> deck, ArrayList<Cards> hand) {
        hand.add(deck.pop());
    }

}
