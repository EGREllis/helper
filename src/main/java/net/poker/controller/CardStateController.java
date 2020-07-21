package net.poker.controller;

import net.poker.model.CardSink;
import net.poker.model.CardState;

public interface CardStateController extends CardSink {
    CardState getCardState();
}
