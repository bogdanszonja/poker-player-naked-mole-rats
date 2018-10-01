package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "0.1";

    public static int betRequest(JsonElement request) {

        JsonObject jsonObject = request.getAsJsonObject();

        int money = jsonObject.get("stack").getAsInt();

        return money / 2;

    }

    public static void showdown(JsonElement game) {
    }
}
