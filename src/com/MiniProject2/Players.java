package com.MiniProject2;

import java.util.ArrayList;

/**
 * This class represents the players at the black jack table
 *
 * @author Jeremy Yang
 */
public class Players {

    private ArrayList<Cards> cards;

    /**
     * @param cards This is a constructor and initialize cards for player
     */
    public Players(ArrayList<Cards> cards) {
        this.cards = cards;
    }

    /**
     * This method retrieves the cards for player
     *
     * @return an Arraylist of cards for player
     */
    public ArrayList<Cards> getCards() {
        return cards;
    }
}
