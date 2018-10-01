package com.codecool.leanpoker;

public enum Rank {
    J,
    Q,
    K,
    A;

    public int getValue(Rank rank) {
        return rank.ordinal() + 11;
    }
}
