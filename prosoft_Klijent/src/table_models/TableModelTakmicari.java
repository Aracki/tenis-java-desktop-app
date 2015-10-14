/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import domen.Takmicar;
import domen.Takmicenje;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raca420
 */
public class TableModelTakmicari extends AbstractTableModel {

    private List<Takmicar> lista;
    private String[] niz;
    private List<Takmicar> visak;

    public TableModelTakmicari(List<Takmicar> lista) {
        this.lista = lista;
        visak = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public String getColumnName(int column) {
        String[] niz = {"Ime i prezime", "Takmicenje", "Liga", "Mesto", "Opis", "FBlink"};
        return niz[column];
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lista.get(rowIndex).getIme() + " " + lista.get(rowIndex).getPrezime();
            case 1:
                return lista.get(rowIndex).getLiga().getTakmicenje().getNaziv();
            case 2:
                return lista.get(rowIndex).getLiga().getNaziv();
            case 3:
                return lista.get(rowIndex).getMesto().getNaziv();

            case 4:
                return lista.get(rowIndex).getOpis();

            case 5:
                if (lista.get(rowIndex).getFb_link() == null) {
                    return "";
                } else {

                    return lista.get(rowIndex).getFb_link();
                }
        }
        return "Greska";
    }

    public void skloniSaListe(String kriterijum) {

        String s = "[\\p{Z}\\p{L}[0-9]-]*" + kriterijum.toLowerCase().trim() + "[\\p{Z}\\p{L}[0-9]-]*";
        for (int i = 0; i < lista.size(); i++) {
            String imePrezime = lista.get(i).getIme().toLowerCase() + " " + lista.get(i).getPrezime().toLowerCase();
            if (!imePrezime.matches(s)
                    && !lista.get(i).getMesto().toString().toLowerCase().matches(s)
                    && !lista.get(i).getLiga().toString().toLowerCase().matches(s)
                    && !lista.get(i).getLiga().getTakmicenje().toString().toLowerCase().matches(s)) {
                visak.add(lista.get(i));
                lista.remove(i);
                i--;
            }
        }
        fireTableDataChanged();
    }

    public void vratiNaListu(String kriterijum) {
        if (kriterijum.length() == 0) {
            for (int i = 0; i < visak.size(); i++) {
                lista.add(visak.get(i));
                visak.remove(i);
                i--;
            }
            fireTableDataChanged();
            return;
        }
        String s = "[\\p{Z}\\p{L}[0-9]-]*" + kriterijum.toLowerCase().trim() + "[\\p{Z}\\p{L}[0-9]-]*";

        for (int i = 0; i < visak.size(); i++) {
            String imePrezime = visak.get(i).getIme().toLowerCase() + " " + visak.get(i).getPrezime().toLowerCase();
            if (imePrezime.matches(s) || visak.get(i).getMesto().toString().toLowerCase().matches(s)
                    || visak.get(i).getLiga().toString().toLowerCase().matches(s)
                    || visak.get(i).getLiga().getTakmicenje().toString().toLowerCase().matches(s)) {
                lista.add(visak.get(i));
                visak.remove(i);
                i--;
            }
        }
        fireTableDataChanged();
    }
}
