package net.poker.swing;

import net.poker.io.CardReader;
import net.poker.model.Card;

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
        SwingView view = new SwingView(cardImages);
        view.run();
    }
}
