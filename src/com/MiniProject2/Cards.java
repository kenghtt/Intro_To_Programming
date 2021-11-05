package com.MiniProject2;

public class Cards {

    private int number;
    private String suit;

    Cards(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }
}
