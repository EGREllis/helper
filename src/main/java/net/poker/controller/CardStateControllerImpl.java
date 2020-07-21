package net.poker.controller;

import net.poker.model.CardState;

public class CardStateControllerImpl implements CardStateController {
    private volatile CardState state;

    public CardStateControllerImpl(CardState state) {
        this.state = state;
    }

    @Override
    public void setCardState(CardState cardState) {
        this.state = cardState;
    }

    public CardState getCardState() {
        return state;
    }
}
