package net.poker.model;


public class CardState {
    private final Card hand1;
    private final Card hand2;
    private final Card flop1;
    private final Card flop2;
    private final Card flop3;
    private final Card turn;
    private final Card river;

    public static CardState newBlankState() {
        return new CardState(Card.BLANK, Card.BLANK, Card.BLANK, Card.BLANK, Card.BLANK, Card.BLANK, Card.BLANK);
    }

    public CardState(Card hand1, Card hand2, Card flop1, Card flop2, Card flop3, Card turn, Card river) {
        this.hand1 = hand1;
        this.hand2 = hand2;
        this.flop1 = flop1;
        this.flop2 = flop2;
        this.flop3 = flop3;
        this.turn = turn;
        this.river = river;
    }

    public Card getHand1() {
        return hand1;
    }

    public Card getHand2() {
        return hand2;
    }

    public Card getFlop1() {
        return flop1;
    }

    public Card getFlop2() {
        return flop2;
    }

    public Card getFlop3() {
        return flop3;
    }

    public Card getTurn() {
        return turn;
    }

    public Card getRiver() {
        return river;
    }

    public CardState setHand1(Card hand1) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setHand2(Card hand2) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setFlop1(Card flop1) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setFlop2(Card flop2) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setFlop3(Card flop3) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setTurn(Card turn) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }

    public CardState setRiver(Card river) {
        return new CardState(hand1, hand2, flop1, flop2, flop3, turn, river);
    }
}
