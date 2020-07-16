package net.poker.io;

import net.poker.model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardReader {
    private static final String CARD_PATH = "cards/cards.png";

    public Map<Card,ImageIcon> loadCards() {
        System.out.println(ClassLoader.getSystemResource(CARD_PATH));
        Image allCards = new ImageIcon(ClassLoader.getSystemResource(CARD_PATH)).getImage();

        int cardWidth = 73;
        int cardHeight = 98;
        Map<Card, ImageIcon> cards = new HashMap<>();
        BufferedImage blankCard = new BufferedImage(cardWidth, cardHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = blankCard.createGraphics();
        graphics.setColor(new Color(255,255,255, 0));
        graphics.draw3DRect(0, 0, cardWidth, cardHeight, false);
        graphics.setColor(new Color(0,0,0,0));
        graphics.drawString("?",10, 10);
        graphics.setColor(new Color(255, 0,0,0));
        graphics.drawRect(8, 8, 68, 92);
        graphics.dispose();
        blankCard.flush();
        cards.put(Card.BLANK, new ImageIcon(blankCard));

        int cardStartX = 0;
        int cardStartY = 0;
        List<Card> cardIndex = Card.allCards();
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 13; i++) {
                BufferedImage card = new BufferedImage(cardWidth, cardHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graph2D = card.createGraphics();
                int originX = cardStartX + (cardWidth * i);
                int originY = cardStartY + (cardHeight * j);
                int originWidth = originX + cardWidth;
                int originHeight = originY + cardHeight;

                System.out.println(String.format("Copying card %1$d from (%2$d,%3$d) (%4$d,%5$d) to (%6$d,%7$d)", i + 13*j, originX, originY, originWidth, originHeight, cardWidth, cardHeight));
                graph2D.drawImage(allCards, 0, 0, cardWidth, cardHeight, originX, originY, originWidth, originHeight, null);
                graph2D.dispose();

                ImageIcon imageIcon = new ImageIcon(card);
                cards.put(cardIndex.get(j * 13 + i + 1), imageIcon);
            }
        }

        return cards;
    }
}
