package net.poker.model;

public enum Suit {
    CLUBS,
    SPADES,
    HEARTS,
    DIAMONDS;

    public static Suit getSuitFromOrdinal(int ordinal) {
        Suit suit = null;
        for (Suit t : Suit.values()) {
            if (t.ordinal() == ordinal) {
                suit = t;
                break;
            }
        }
        return suit;
    }
}
