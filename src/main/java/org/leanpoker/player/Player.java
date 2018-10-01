package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
            System.err.println("stack: " + stack);
            JsonArray myCards = players.get(2).getAsJsonObject().get("hole_cards").getAsJsonArray();
            String firstCardRank = myCards.get(0).getAsJsonObject().get("rank").getAsString();
            String firstCardSuit = myCards.get(0).getAsJsonObject().get("suit").getAsString();
            String secondCardRank = myCards.get(1).getAsJsonObject().get("rank").getAsString();
            String secondCardSuit = myCards.get(1).getAsJsonObject().get("suit").getAsString();
            System.err.println("first card: " + firstCardRank + " " + firstCardSuit + "second card: " + secondCardRank + " " + secondCardSuit);
            return stack;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
            return random.nextInt(1000);
        }
    }

    public static void showdown(JsonElement game) {
    }
}
