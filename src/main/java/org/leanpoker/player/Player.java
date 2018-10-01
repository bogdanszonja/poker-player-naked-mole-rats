package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Map;
import java.util.Random;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {


        Random random = new Random();
        return random.nextInt(50);
    }

    public static void showdown(JsonElement game) {
    }
}
