/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Date;
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
public class Takmicenje implements IOpstiDomenskiObjekat {

    private int takmicenjeID;
    private String naziv;
    private Date datum_pocetka;
    private TipTakmicenja tiptakmicenja;
    private List<Liga> listaLiga;

    public Takmicenje() {
        listaLiga = new ArrayList<>();
        tiptakmicenja = new TipTakmicenja();
    }

    public Takmicenje(int takmicenjeID, String naziv, Date datum_pocetka, TipTakmicenja tiptakmicenja, List<Liga> listaLiga) {
        this.takmicenjeID = takmicenjeID;
        this.naziv = naziv;
        this.datum_pocetka = datum_pocetka;
        this.tiptakmicenja = tiptakmicenja;
        this.listaLiga = listaLiga;
    }

    public List<Liga> getListaLiga() {
        return listaLiga;
    }

    public void setListaLiga(List<Liga> listaLiga) {
        this.listaLiga = listaLiga;
    }

    public int getTakmicenjeID() {
        return takmicenjeID;
    }

    public void setTakmicenjeID(int takmicenjeID) {
        this.takmicenjeID = takmicenjeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatum_pocetka() {
        return datum_pocetka;
    }

    public void setDatum_pocetka(Date datum_pocetka) {
        this.datum_pocetka = datum_pocetka;
    }

    public TipTakmicenja getTiptakmicenja() {
        return tiptakmicenja;
    }

    public void setTiptakmicenja(TipTakmicenja tiptakmicenja) {
        this.tiptakmicenja = tiptakmicenja;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return "DEFAULT, '" + naziv + "', "
                + "'" + datum_pocetka + "', "
                + "" + tiptakmicenja.getTiptakmicenjaID();
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        List<IOpstiDomenskiObjekat> l = new ArrayList<>();
        l.add(tiptakmicenja);
        return l;
    }

    @Override
    public String vratiImeTabele() {
        return "takmicenje";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {

        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {

                Takmicenje t = new Takmicenje();
                t.setDatum_pocetka(rs.getDate("datum_pocetka"));
                t.setNaziv(rs.getString("naziv"));
//                t.setListaLiga(listaLiga);
                TipTakmicenja tt = new TipTakmicenja();
                tt.setTiptakmicenjaID(rs.getInt("tiptakmicenja"));

//                tt.napuniObjekat(rs);
                t.setTiptakmicenja(tt);

                listaObjekata.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Takmicenje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjekata;
    }

    @Override
    public String toString() {
        return getNaziv() + "";
    }

//    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        Takmicenje t = new Takmicenje();
        try {
            t.setDatum_pocetka(rs.getDate("datum_pocetka"));
            t.setNaziv(rs.getString("naziv"));
            t.setTakmicenjeID(rs.getInt("takmicenjeID"));

            //tip takmicenja ID
            TipTakmicenja tt = new TipTakmicenja();
            tt.setTiptakmicenjaID(rs.getInt("tiptakmicenja"));
            t.setTiptakmicenja(tt);

        } catch (SQLException ex) {
            Logger.getLogger(Takmicenje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public Object vratiID() {
        return takmicenjeID;
    }

    @Override
    public String vratiNazivID() {
        return "takmicenjeID";
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            datum_pocetka = rs1.getDate("datum_pocetka");
            naziv = rs1.getString("naziv");
            takmicenjeID = rs1.getInt("takmicenjeID");
            tiptakmicenja.setTiptakmicenjaID(rs1.getInt("tiptakmicenja"));
        } catch (SQLException ex) {
            Logger.getLogger(Takmicenje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String vratiImenaKolona() {
        return "naziv, "
                + "datum_pocetka, "
                + "tiptakmicenja";
    }

}
