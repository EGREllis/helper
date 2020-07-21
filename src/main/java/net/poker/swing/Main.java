package net.poker.swing;

import net.poker.controller.CardStateController;
import net.poker.controller.CardStateControllerImpl;
import net.poker.io.CardReader;
import net.poker.model.Card;
import net.poker.model.CardState;

import javax.swing.*;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        CardReader reader = new CardReader();
        Map<Card, ImageIcon> cardImages = reader.loadCards();
        CardState cardState = CardState.newBlankState();
        CardStateController controller = new CardStateControllerImpl(cardState);
        SwingView view = new SwingView(cardImages, controller);
        view.run();
    }
}
