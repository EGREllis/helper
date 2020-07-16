package net.poker.swing;

import net.poker.model.Card;
import net.poker.model.Rank;
import net.poker.model.Suit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardSelector {
    private final JFrame frame;
    private final CardSelectorCanvas canvas;
    private CardListener listener;

    public CardSelector() {
        this.frame = new JFrame();
        frame.setLayout(new BorderLayout());
        this.canvas = new CardSelectorCanvas();
        frame.add(canvas, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conceal();
            }
        });
        buttonPanel.add(cancel);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(false);
        frame.pack();
    }

    public void setCardListener(CardListener cardListener) {
        this.listener = cardListener;
    }

    private void reveal() {
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }

    private void conceal() {
        frame.setAlwaysOnTop(false);
        frame.setVisible(false);
    }

    public void selectCard() {
        reveal();
    }

    private class CardSelectorCanvas extends Canvas {
        private final Image image;

        CardSelectorCanvas() {
            super();
            image = new ImageIcon(ClassLoader.getSystemResource("cards/cards.png")).getImage();
            this.addMouseListener(new CardSelectorMouseListener());
            this.setBounds(new Rectangle(0, 0, 950, 392));
        }

        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, 950, 392, 0, 0, getWidth(), getHeight(), null);
        }
    }

    private class CardSelectorMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int rankOrdinal = (int)Math.floor(1.0 * e.getX() / (CardSelector.this.canvas.getWidth() / 13));
            int suitOrdinal = (int)Math.floor(1.0 * e.getY() / (CardSelector.this.canvas.getHeight() / 4));
            Rank rank = Rank.getRankFromOrdinal(rankOrdinal);
            Suit suit = Suit.getSuitFromOrdinal(suitOrdinal);
            Card card = new Card(rank, suit);
            CardSelector.this.listener.cardSelected(card);
            CardSelector.this.conceal();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public interface CardListener {
        void cardSelected(Card card);
    }
}
