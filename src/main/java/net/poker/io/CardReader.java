package net.poker.io;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CardReader {
    private static final String CARD_PATH = "cards/cards.png";

    public List<ImageIcon> loadCards() {
        System.out.println(ClassLoader.getSystemResource(CARD_PATH));
        Image allCards = new ImageIcon(ClassLoader.getSystemResource(CARD_PATH)).getImage();

        int cardWidth = 76;
        int cardHeight = 100;
        List<ImageIcon> cards = new ArrayList<>(0);
        BufferedImage blankCard = new BufferedImage(cardWidth, cardHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = blankCard.getGraphics();
        graphics.setColor(new Color(255,255,255, 0));
        graphics.draw3DRect(0, 0, cardWidth, cardHeight, false);
        graphics.setColor(new Color(0,0,0,0));
        graphics.drawString("?",10, 10);
        graphics.setColor(new Color(255, 0,0,0));
        graphics.drawRect(8, 8, 68, 92);
        graphics.dispose();
        blankCard.flush();
        cards.add(new ImageIcon(blankCard));

        int cardStartX = 2;
        int cardStartY = 2;
        for (int i = 0; i < 13; i++) {
            BufferedImage card = new BufferedImage(cardWidth, cardHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph2D = card.createGraphics();
            int originX = cardStartX + (cardWidth * i);
            int originY = cardStartY + (cardHeight * i);
            int originWidth = originX + cardWidth;
            int originHeight = originY + cardHeight;

            System.out.println(String.format("Copying card %1$d from (%2$d,%3$d) (%4$d,%5$d) to (%6$d,%7$d)", i, originX, originY, originWidth, originHeight, cardWidth, cardHeight));
            boolean result = graph2D.drawImage(allCards, originX, originY, originWidth, originHeight, 0, 0, cardWidth, cardHeight, null);
            System.out.println(String.format("\tDrawImage: %1$s", result ? "true" : "false"));
            graph2D.dispose();

            ImageIcon imageIcon = new ImageIcon(card);
            System.out.println(String.format("\tIcon: %1$d x %2$d", imageIcon.getIconWidth(), imageIcon.getIconHeight()));
            cards.add(imageIcon);
        }

        return cards;
    }
}
