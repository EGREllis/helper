package net.poker.model;

import java.util.HashSet;
import java.util.Set;

public class CardState {
    private final Set<Card> hand;
    private final Set<Card> table;

    public CardState() {
        hand = new HashSet<>();
        table = new HashSet<>();
    }
}
