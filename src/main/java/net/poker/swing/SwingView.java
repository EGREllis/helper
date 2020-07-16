package net.poker.swing;

import net.poker.model.Card;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SwingView implements Runnable {
    private final Map<Card, ImageIcon> cardImages;

    public SwingView(Map<Card, ImageIcon> cardImages) {
        this.cardImages = cardImages;
    }

    private JLabel newCardLabel() {
        JLabel cardLabel = new JLabel(cardImages.get(Card.BLANK));
        CardSelector cardSelector = new CardSelector();

        MouseListener mouseListener = new CardSelectorListener(cardSelector);
        cardLabel.addMouseListener(mouseListener);
        cardSelector.setCardListener(new CardSelectedListener(cardLabel, cardImages));

        return cardLabel;
    }

    public void createAndShowGUI() {
        JFrame main = new JFrame("Poker helper");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridBagLayout());

        JLabel label1 = new JLabel("Hand:");
        JLabel hand1 = newCardLabel();
        JLabel hand2 = newCardLabel();

        JLabel label2 = new JLabel("Flop:");
        JLabel card1 = newCardLabel();
        JLabel card2 = newCardLabel();
        JLabel card3 = newCardLabel();

        JLabel label3 = new JLabel("Turn:");
        JLabel card4 = newCardLabel();

        JLabel label4 = new JLabel("River:");
        JLabel card5 = newCardLabel();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridwidth = 2;
        main.add(label1, constraints);
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        main.add(hand1, constraints);
        constraints.gridx = 1;
        main.add(hand2, constraints);

        constraints.gridwidth = 3;
        constraints.gridx = 2;
        constraints.gridy = 0;
        main.add(label2, constraints);
        constraints.gridwidth = 1;
        constraints.gridx = 2;
        constraints.gridy = 1;
        main.add(card1, constraints);
        constraints.gridx = 3;
        main.add(card2, constraints);
        constraints.gridx = 4;
        main.add(card3, constraints);

        constraints.gridy = 0;
        constraints.gridx = 5;
        main.add(label3, constraints);
        constraints.gridy = 1;
        constraints.gridx = 5;
        main.add(card4, constraints);

        constraints.gridx = 6;
        constraints.gridy = 0;
        main.add(label4, constraints);
        constraints.gridx = 6;
        constraints.gridy = 1;
        main.add(card5, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 7;
        main.add(new JSeparator(SwingConstants.HORIZONTAL), constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 7;
        OutcomeTable outcomeTable = new OutcomeTable();
        TableModel tableModel = outcomeTable.getOutcomeTableModel();
        JTable table = new JTable(tableModel);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(table);
        main.add(scrollPane, constraints);

        main.pack();
        main.setVisible(true);
    }

    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    createAndShowGUI();
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
            System.err.flush();
        }
    }

    private class CardSelectorListener implements MouseListener {
        private final CardSelector cardSelector;

        public CardSelectorListener(CardSelector cardSelector) {
            this.cardSelector = cardSelector;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(String.format("Image clicked: (%1$d, %2$d)", e.getX(), e.getY()));
            cardSelector.selectCard();
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

    private static class CardSelectedListener implements CardSelector.CardListener {
        private final JLabel label;
        private final Map<Card,ImageIcon> cardMap;

        public CardSelectedListener(JLabel label, Map<Card,ImageIcon> cardMap) {
            this.label = label;
            this.cardMap = cardMap;
        }

        @Override
        public void cardSelected(Card card) {
            ImageIcon cardIcon = cardMap.get(card);
            label.setIcon(cardIcon);
        }
    }
}
