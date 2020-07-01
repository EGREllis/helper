package net.poker.swing;

import net.poker.model.Card;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingView implements Runnable {
    private final ImageIcon[] imageIcons;

    public SwingView() {
        imageIcons = new ImageIcon[1];
        imageIcons[0] = new ImageIcon(ClassLoader.getSystemResource("cards/cards.png"));

        System.out.flush();
    }

    @Override
    public void run() {
        JFrame main = new JFrame("Poker helper");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridBagLayout());

        String[] cards = Card.allCardsAsArray();

        JLabel label1 = new JLabel("Hand:");
        JComboBox hand1 = new JComboBox(cards);
        JComboBox hand2 = new JComboBox(cards);

        JLabel label2 = new JLabel("Flop:");
        JComboBox card1 = new JComboBox(cards);
        JComboBox card2 = new JComboBox(cards);
        JComboBox card3 = new JComboBox(cards);

        JLabel label3 = new JLabel("Turn:");
        JComboBox card4 = new JComboBox(cards);

        JLabel label4 = new JLabel("River:");
        JComboBox card5 = new JComboBox(cards);

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
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setShowGrid(true);
        main.add(table, constraints);

        constraints.gridx = 3;
        main.add(new JLabel(imageIcons[0]), constraints);
        //main.add(new JLabel(resize(imageIcons[0], 43, 66)), constraints);

        main.pack();
        main.setVisible(true);
    }

    private ImageIcon resize(ImageIcon icon, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = resizedImg.createGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.drawImage(icon.getImage(), 0, 0, width, height, null);
        graphics.dispose();

        return new ImageIcon(resizedImg);
    }
}
