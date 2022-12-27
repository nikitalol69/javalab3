package bsu.rfe.voznuk.lab3.var3;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public int getRowCount() {
        return (int) Math.ceil((to - from) / step) + 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        double x = from + step * rowIndex;

        switch (columnIndex) {
            case 0 -> {
                return x;
            }

            case 1 -> {
                Double result = .0;

                for (int i = 0; i < coefficients.length; i++) {
                    result = coefficients[i] + x * result;
                }

                return result;
            }

            default -> {
                Boolean isNumLittle = false;
                Double result = .0;

                for (int i = 0; i < coefficients.length; i++) {
                    result = coefficients[i] + x * result;
                }

                if (result.intValue() == result)
                    isNumLittle = true;

                return isNumLittle;
            }
        } //switch
    } //getValueAt

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Значение Х";
            case 1:
                return "Значение многочлена";
            default:
                return "Целое число?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2)
            return  Boolean.class;

        return Double.class;
    }


}
