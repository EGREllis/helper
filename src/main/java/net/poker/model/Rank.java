package net.poker.model;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    public static Rank getRankFromOrdinal(int ordinal) {
        Rank rank = null;
        for (Rank r :  Rank.values()) {
            if (ordinal == r.ordinal()) {
                rank = r;
                break;
            }
        }
        return rank;
    }
}
