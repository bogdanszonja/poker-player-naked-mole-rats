package com.codecool.leanpoker;

import java.util.List;

public class Combinations {

    public static boolean isTheSameRank(Card card1, Card card2) {
        return card1.getValue() == card2.getValue();
    }


    public static boolean pairAt3Cards(List<Card> myCards, List<Card> cardsOnDeck) {
        for (Card cardHand : myCards) {
            for (Card cardDeck : cardsOnDeck) {
                if (Combinations.isTheSameRank(cardHand, cardDeck)) {
                    return true;
                }
            }
        }

        return false;
    }

}
