/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import domen.Mec;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raca420
 */
public class TableModelMecevi extends AbstractTableModel {

    private List<Mec> lista;

    public TableModelMecevi(List<Mec> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        String[] niz = {"Redni broj", "Domacin", "Gost", "Rezultat"};
        return niz[column];
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return lista.get(rowIndex).getTakmicarDID().getIme() + " " + lista.get(rowIndex).getTakmicarDID().getIme();
            case 2:
                return lista.get(rowIndex).getTakmicarGID().getIme() + " " + lista.get(rowIndex).getTakmicarGID().getIme();
            case 3:
                return lista.get(rowIndex).getRezultat();
        }
        return "Greska";
    }

}
