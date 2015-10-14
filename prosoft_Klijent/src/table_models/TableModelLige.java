/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import domen.Liga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raca420
 */
public class TableModelLige extends AbstractTableModel {

    private List<Liga> lista;
    private String[] niz;

    public TableModelLige(List<Liga> lista) {

        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        String[] niz = {"Naziv lige", "Broj takmicara", "Naziv takmicenja"};
        return niz[column];
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getNaziv();
            case 1:
                return String.valueOf(lista.get(rowIndex).getBroj_takmicara());
            case 2:
                return lista.get(rowIndex).getTakmicenje().getNaziv();
        }
        return "Greska";
    }

}
