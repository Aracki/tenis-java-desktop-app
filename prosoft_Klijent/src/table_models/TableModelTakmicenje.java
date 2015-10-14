/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import domen.IOpstiDomenskiObjekat;
import domen.Takmicenje;
import domen.TipTakmicenja;
import java.sql.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raca420
 */
public class TableModelTakmicenje extends AbstractTableModel {

    private List<Takmicenje> lista;
    private String[] niz;

    public TableModelTakmicenje(List<Takmicenje> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        String[] niz = {"Naziv takmicenja", "Datum početka", "Tip takmicenja"};
        return niz[column];
    }

    @Override
    public int getColumnCount() {
//        if (!lista.isEmpty()) {
        return 3;
//        } else {
//            return 0;
//        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getNaziv();
            case 1:
                return lista.get(rowIndex).getDatum_pocetka().toString();
            case 2:
                return lista.get(rowIndex).getTiptakmicenja().getNaziv_tipa();
        }
        return "Greska";
    }

   
}
