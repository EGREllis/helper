package net.poker.swing;

import net.poker.io.CardReader;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SwingView implements Runnable {
    private final CardSelector cardSelector;

    public SwingView() {
        cardSelector = new CardSelector();
    }

    public void createAndShowGUI() {
        JFrame main = new JFrame("Poker helper");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridBagLayout());

        CardReader reader = new CardReader();
        List<ImageIcon> cardImages = reader.loadCards();

        MouseListener cardSelectListener = new CardSelectorListener();
        JLabel label1 = new JLabel("Hand:");

        JLabel hand1 = new JLabel(cardImages.get(0));
        hand1.addMouseListener(cardSelectListener);
        JLabel hand2 = new JLabel(cardImages.get(0));
        hand2.addMouseListener(cardSelectListener);

        JLabel label2 = new JLabel("Flop:");
        JLabel card1 = new JLabel(cardImages.get(0));
        card1.addMouseListener(cardSelectListener);
        JLabel card2 = new JLabel(cardImages.get(0));
        card2.addMouseListener(cardSelectListener);
        JLabel card3 = new JLabel(cardImages.get(0));
        card3.addMouseListener(cardSelectListener);

        JLabel label3 = new JLabel("Turn:");
        JLabel card4 = new JLabel(cardImages.get(0));
        card4.addMouseListener(cardSelectListener);

        JLabel label4 = new JLabel("River:");
        JLabel card5 = new JLabel(cardImages.get(0));
        card5.addMouseListener(cardSelectListener);

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

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        main.add(new JLabel(cardImages.get(0)), constraints);

        constraints.gridx = 1;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 2;
        main.add(new JLabel(cardImages.get(1)), constraints);

        constraints.gridx = 3;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 4;
        main.add(new JLabel(cardImages.get(2)), constraints);

        constraints.gridx = 5;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 6;
        main.add(new JLabel(cardImages.get(3)), constraints);

        constraints.gridx = 7;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 8;
        main.add(new JLabel(cardImages.get(4)), constraints);

        constraints.gridx = 9;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 10;
        main.add(new JLabel(cardImages.get(5)), constraints);

        constraints.gridx = 11;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 12;
        main.add(new JLabel(cardImages.get(6)), constraints);

        constraints.gridx = 13;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);
        constraints.gridx = 14;
        main.add(new JLabel(cardImages.get(52)), constraints);

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
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(String.format("Image clicked: (%1$d, %2$d)", e.getX(), e.getY()));
            SwingView.this.cardSelector.selectCard();
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
}
