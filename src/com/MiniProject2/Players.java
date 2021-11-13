package com.MiniProject2;

import java.util.ArrayList;

public class Players {

    private ArrayList<Cards> cards;

    public Players(ArrayList<Cards> cards) {
        this.cards =  cards;
    }

    public ArrayList<Cards> getCards() {
        return cards;
    }
}
