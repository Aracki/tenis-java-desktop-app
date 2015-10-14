/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import domen.Takmicar;
import domen.Takmicenje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raca420
 */
public class TableModelTakmicariZaLigu extends AbstractTableModel {

    private List<Takmicar> lista;
    private String[] niz;

    public TableModelTakmicariZaLigu(List<Takmicar> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        String[] niz = {"Ime i prezime", "Pozicija", "Broj pobeda", "Broj izgubljenih", "Broj poena", "+Set", "-Set", "+Gem", "-Gem", "Opis"};
        return niz[column];
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getIme() + " " + lista.get(rowIndex).getPrezime();
            case 1:
                return lista.get(rowIndex).getPozicija();
            case 2:
                return lista.get(rowIndex).getBroj_pobeda();
            case 3:
                return lista.get(rowIndex).getBroj_izgubljenih();
            case 4:
                return lista.get(rowIndex).getBroj_poena();
            case 5:
                return lista.get(rowIndex).getSet_plus();
            case 6:
                return lista.get(rowIndex).getSet_plus();
            case 7:
                return lista.get(rowIndex).getGem_plus();
            case 8:
                return lista.get(rowIndex).getGem_minus();
            case 9:
                return lista.get(rowIndex).getOpis();
        }
        return "Greska";
    }

}
