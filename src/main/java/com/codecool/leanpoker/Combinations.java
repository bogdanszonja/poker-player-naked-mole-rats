package com.codecool.leanpoker;

import java.util.List;

public class Combinations {

    public static boolean isTheSameRank(Card card1, Card card2) {
        return card1.getValue() == card2.getValue();
    }

    public static boolean isTheSameColor(Card card1, Card card2) {return card1.getSuit() == card2.getSuit();}


    public static boolean onePair(List<Card> myCards, List<Card> cardsOnDeck) {
        for (Card cardHand : myCards) {
            for (Card cardDeck : cardsOnDeck) {
                if (Combinations.isTheSameRank(cardHand, cardDeck)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean twoPairs(List<Card> myCards, List<Card> cardsOnDeck) {
        if (Combinations.isTheSameRank(myCards.get(0), myCards.get(1))) {
            return false;
        }

        int currentPairNum = 0;

        for (Card cardHand : myCards) {
            for (Card cardDeck : cardsOnDeck) {
                if (Combinations.isTheSameRank(cardHand, cardDeck)) {
                    currentPairNum++;
                    break;
                }
            }
        }

        return currentPairNum >= 2;
    }

    public static boolean is3OfAKind(List<Card> myCards, List<Card> cardsOnDeck) {
        for (Card cardDeck : cardsOnDeck) {
            if (isTheSameRank(myCards.get(0), myCards.get(1)) && isTheSameRank(myCards.get(0), cardDeck) ||
                    isTheSameRank(myCards.get(0), myCards.get(1)) && isTheSameRank(myCards.get(1), cardDeck)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean isTheSameColor(List<Card> myCards, List<Card> cardsOnDeck) {
        int numOfSameColors = 0;
        if(isTheSameColor(myCards.get(0), myCards.get(1))) {
            numOfSameColors = 2;
            for(Card cardDeck: cardsOnDeck) {
                if(isTheSameColor(myCards.get(0), cardDeck)) {
                    numOfSameColors++;
                }
            }
            if(numOfSameColors >= 5) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
