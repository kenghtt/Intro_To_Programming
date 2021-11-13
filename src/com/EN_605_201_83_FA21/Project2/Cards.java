/**
 * This class represents a standard 52 playing card
 *
 * @author Jeremy Yang
 */

public class Cards {
    private int number;
    private String suit;

    /**
     * @param number The number value of the card
     * @param suit The suit of the card
     */
    Cards(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    /**
     * @return The current number value of the card
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return The current suit of the card
     */
    public String getSuit() {
        return suit;
    }
}
