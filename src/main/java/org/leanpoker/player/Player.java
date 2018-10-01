package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "1.1";

    public static int betRequest(JsonElement request) {

        JsonObject jsonObject = request.getAsJsonObject();

        int money = jsonObject.get("stack").getAsInt();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: " + money);
        Random random = new Random();

        return random.nextInt(500);
    }

    public static void showdown(JsonElement game) {
    }
}
