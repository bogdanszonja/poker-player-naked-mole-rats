package com.codecool.leanpoker;

public class Card {

    private Suit suit;
    private int value;


    public Card(String suit, String value) {
        this.suit = Suit.valueOf(suit);
        try {
            this.value = Integer.parseInt(value);
        } catch (Exception e) {
            this.value = Rank.getValue(Rank.valueOf(value));
        }
    }


    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}
