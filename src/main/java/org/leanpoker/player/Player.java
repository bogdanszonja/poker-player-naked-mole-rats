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
//        JsonArray players = jsonObject.get("players").getAsJsonArray();
//        stack = players.get(0).get("stack").getAsInt();
//        System.out.println("stack: " + stack);

        return random.nextInt(1000);
    }

    public static void showdown(JsonElement game) {
    }
}
