package net.poker.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public final Rank rank;
    public final Suit suit;

    public Card(final Rank rank, final Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static List<Card> allCards() {
        List<Card> cards = new ArrayList<>(Rank.values().length * Suit.values().length);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        return cards;
    }

    public static String[] allCardsAsArray() {
        String[] values = new String[Rank.values().length * Suit.values().length];
        int i = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                values[i++] = rank.name()+" of "+suit.name();
            }
        }
        return values;
    }
}
