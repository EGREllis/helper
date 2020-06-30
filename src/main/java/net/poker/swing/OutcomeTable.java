package net.poker.swing;

import net.poker.model.Hand;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class OutcomeTable {
    private final String[] columnNames = {"Hand", "Chance you get it", "Chance they have it", "Chance you win"};

    public TableModel getOutcomeTableModel() {
        return new OutcomeTableModel();
    }

    private class OutcomeTableModel extends AbstractTableModel {
        private Object data[][] = {
                {Hand.STRAIGHT_FLUSH, 1.0, 0.0, 0.0},
                {Hand.FOUR_KIND, 1.0, 1.0, 1.0},
                {Hand.FULL_HOUSE, 1.0, 1.0, 1.0},
                {Hand.FLUSH, 1.0, 1.0, 1.0},
                {Hand.STRAIGHT, 1.0, 1.0, 1.0},
                {Hand.THREE_KIND, 1.0, 1.0, 1.0},
                {Hand.TWO_PAIR, 1.0, 1.0, 1.0},
                {Hand.PAIR, 1.0, 1.0, 1.0},
                {Hand.HIGH_CARD, 1.0, 0.0, 0.0}
        };

        public int getRowCount() {
            return Hand.values().length;
        }

        public int getColumnCount() {
            return OutcomeTable.this.columnNames.length;
        }

        public String getColumnName(int i) {
            return OutcomeTable.this.columnNames[i];
        }

        public Object getValueAt(int row, int column) {
            return this.data[row][column];
        }
    }
}
