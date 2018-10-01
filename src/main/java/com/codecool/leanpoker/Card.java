package com.codecool.leanpoker;

public class Card {

    private Suit suit;
    private int value;


    public Card(String suit, String rank) {
        this.suit = Suit.valueOf(suit.toUpperCase());
        try {
            this.value = Integer.parseInt(rank);
        } catch (Exception e) {
            this.value = Rank.getValue(Rank.valueOf(rank));
        }
    }


    public boolean pairInHand(Card card) {
        return this.value == card.value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

}
