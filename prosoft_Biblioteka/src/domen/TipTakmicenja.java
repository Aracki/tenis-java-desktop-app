/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raca420
 */
public class TipTakmicenja implements IOpstiDomenskiObjekat {

    private int tiptakmicenjaID;
    private String naziv_tipa;
    private int vrsta_sistema;
    private List<Takmicenje> listaTakmicenja;

    public TipTakmicenja(int tiptakmicenjaID, String naziv_tipa, int vrsta_sistema, List<Takmicenje> listaTakmicenja) {
        this.tiptakmicenjaID = tiptakmicenjaID;
        this.naziv_tipa = naziv_tipa;
        this.vrsta_sistema = vrsta_sistema;
        this.listaTakmicenja = listaTakmicenja;
    }

    public TipTakmicenja() {
        listaTakmicenja = new ArrayList<>();
    }

    public List<Takmicenje> getListaTakmicenja() {
        return listaTakmicenja;
    }

    public void setListaTakmicenja(List<Takmicenje> listaTakmicenja) {
        this.listaTakmicenja = listaTakmicenja;
    }

    public int getTiptakmicenjaID() {
        return tiptakmicenjaID;
    }

    public void setTiptakmicenjaID(int tiptakmicenjaID) {
        this.tiptakmicenjaID = tiptakmicenjaID;
    }

    public String getNaziv_tipa() {
        return naziv_tipa;
    }

    public void setNaziv_tipa(String naziv_tipa) {
        this.naziv_tipa = naziv_tipa;
    }

    public int getVrsta_sistema() {
        return vrsta_sistema;
    }

    public void setVrsta_sistema(int vrsta_sistema) {
        this.vrsta_sistema = vrsta_sistema;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return "DEFAULT, '" + naziv_tipa + "', "
                + "'" + vrsta_sistema + "'";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        return new ArrayList();
    }

    @Override
    public String vratiImeTabele() {
        return "tiptakmicenja";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {

        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {
                TipTakmicenja tt = new TipTakmicenja();
                tt.setNaziv_tipa(rs.getString("naziv_tipa"));
                tt.setVrsta_sistema(rs.getInt("vrsta_sistema"));
//                tt.setli
                listaObjekata.add(tt);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TipTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaObjekata;
    }

    @Override
    public String toString() {
        return naziv_tipa + " ";
    }

    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        TipTakmicenja tt = new TipTakmicenja();
        try {
            tt.setVrsta_sistema(rs.getInt("vrsta_sistema"));
            tt.setNaziv_tipa(rs.getString("naziv_tipa"));
            tt.setTiptakmicenjaID(rs.getInt("tiptakmicenjaID"));

//            tt.setListaTakmicenja(listaTakmicenja);
        } catch (SQLException ex) {
            Logger.getLogger(TipTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }

    @Override
    public Object vratiID() {
        return tiptakmicenjaID;
    }

    @Override
    public String vratiNazivID() {
        return "tiptakmicenjaID";
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            naziv_tipa = rs1.getString("naziv_tipa");
            vrsta_sistema = rs1.getInt("vrsta_sistema");
            tiptakmicenjaID = rs1.getInt("tiptakmicenjaID");
        } catch (SQLException ex) {
            Logger.getLogger(TipTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String vratiImenaKolona() {
        return "naziv_tipa, "
                + "vrsta_sistema"; 
    }
    
    
    

}
