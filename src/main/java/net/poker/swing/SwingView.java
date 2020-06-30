package net.poker.swing;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class SwingView implements Runnable {
    @Override
    public void run() {
        JFrame main = new JFrame("Poker helper");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridBagLayout());

        JLabel label1 = new JLabel("Hand:");
        JComboBox hand1 = new JComboBox();
        JComboBox hand2 = new JComboBox();

        JLabel label2 = new JLabel("Flop:");
        JComboBox card1 = new JComboBox();
        JComboBox card2 = new JComboBox();
        JComboBox card3 = new JComboBox();

        JLabel label3 = new JLabel("Turn:");
        JComboBox card4 = new JComboBox();

        JLabel label4 = new JLabel("River:");
        JComboBox card5 = new JComboBox();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;

        main.add(label1, constraints);
        constraints.gridy = 1;
        main.add(hand1, constraints);
        constraints.gridy = 2;
        main.add(hand2, constraints);

        constraints.gridy = 3;
        main.add(label2, constraints);
        constraints.gridy = 4;
        main.add(card1, constraints);
        constraints.gridy = 5;
        main.add(card2, constraints);
        constraints.gridy = 6;
        main.add(card3, constraints);

        constraints.gridy = 7;
        main.add(label3, constraints);
        constraints.gridy = 8;
        main.add(card4, constraints);

        constraints.gridy = 9;
        main.add(label4, constraints);
        constraints.gridy = 10;
        main.add(card5, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 11;
        main.add(new JSeparator(SwingConstants.VERTICAL), constraints);

        constraints.gridx = 2;
        OutcomeTable outcomeTable = new OutcomeTable();
        TableModel tableModel = outcomeTable.getOutcomeTableModel();
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setShowGrid(true);
        main.add(table, constraints);

        main.pack();
        main.setVisible(true);
    }
}
