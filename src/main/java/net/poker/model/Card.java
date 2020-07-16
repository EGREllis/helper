package net.poker.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public static final Card BLANK = new Card(null, null);
    public final Rank rank;
    public final Suit suit;

    public Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == BLANK && obj == BLANK) {
            result = true;
        } else if ((this == BLANK && obj != BLANK) || (this != BLANK) && (obj == BLANK)) {
            result = false;
        } else if (obj instanceof Card) {
            Card other = (Card)obj;
            result = rank.equals(other.rank) && suit.equals(other.suit);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (rank == null ? 0 : rank.ordinal()) + (suit == null ? 0 : suit.ordinal()) * 13;
    }

    @Override
    public String toString() {
        return String.format("Rank: %1$s; Suit: %2$s;", rank, suit);
    }

    public static List<Card> allCards() {
        List<Card> cards = new ArrayList<>(Rank.values().length * Suit.values().length + 1);
        cards.add(Card.BLANK);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        return cards;
    }

    public static String[] allCardsAsArray() {
        String[] values = new String[Rank.values().length * Suit.values().length + 1];
        int i = 1;
        values[0] = "";
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                values[i++] = rank.name()+" of "+suit.name();
            }
        }
        return values;
    }
}
