package org.leanpoker.player;

import com.codecool.leanpoker.Card;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "1.2";

    public static int betRequest(JsonElement request) {

        JsonObject jsonObject = request.getAsJsonObject();

        Random random = new Random();
        try {
            JsonArray players = jsonObject.get("players").getAsJsonArray();
            int stack = players.get(2).getAsJsonObject().get("stack").getAsInt();
            JsonArray myCards = players.get(2).getAsJsonObject().get("hole_cards").getAsJsonArray();
            Card firstCard = new Card(myCards.get(0).getAsJsonObject().get("suit").getAsString(), myCards.get(0).getAsJsonObject().get("rank").getAsString());
            Card secondCard = new Card(myCards.get(1).getAsJsonObject().get("suit").getAsString(), myCards.get(1).getAsJsonObject().get("rank").getAsString());
            JsonArray communityCardsJson = jsonObject.get("community_cards").getAsJsonArray();
            int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
            List<Card> communityCards = new ArrayList<>();
            for (int i = 0; i < communityCardsJson.size() ; i++) {
                String CommunityCardRank = communityCardsJson.get(i).getAsJsonObject().get("rank").getAsString();
                String CommunityCardSuit = communityCardsJson.get(i).getAsJsonObject().get("suit").getAsString();
                communityCards.add(new Card(CommunityCardSuit, CommunityCardRank));
            }

            if (communityCards.size() == 0) {
                if (firstCard.getValue() > 11 || secondCard.getValue() > 11 || firstCard.pairInHand(secondCard)) {
                    if (currentBuyIn > 800) {
                        return 0;
                    }
                    return currentBuyIn;
                } else if (communityCards.size() == 3) {
                    if (communityCards.get(0).getValue() == firstCard.getValue() || communityCards.get(0).getValue() == secondCard.getValue()
                            || communityCards.get(1).getValue() == firstCard.getValue() || communityCards.get(1).getValue() == secondCard.getValue() ||
                            communityCards.get(2).getValue() == firstCard.getValue() || communityCards.get(2).getValue() == secondCard.getValue()) {
                        return currentBuyIn + 50;
                    }
                } else if (communityCards.size() == 4) {
                    return 0;
                } else {
                    return 0;
                }

            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
            return random.nextInt(1000);
        }
    }

    public static void showdown(JsonElement game) {
    }
}
