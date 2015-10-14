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
public class Takmicar implements IOpstiDomenskiObjekat {

    private int takmicarID;
    private String ime;
    private String prezime;
    private String opis;
    private String fb_link;
    private int pozicija;
    private int broj_pobeda;
    private int broj_izgubljenih;
    private int broj_poena;
    private int gem_plus;
    private int gem_minus;
    private int set_plus;
    private int set_minus;
    private Liga liga;
    private Mesto mesto;

    public Takmicar() {
        liga = new Liga();
        mesto = new Mesto();
    }

    public Takmicar(int takmicarID, String ime, String prezime, String opis, String fb_link, int pozicija, int broj_pobeda, int broj_izgubljenih, int broj_poena, int gem_plus, int gem_minus, int set_plus, int set_minus, Liga liga, Mesto mesto) {
        this.takmicarID = takmicarID;
        this.ime = ime;
        this.prezime = prezime;
        this.opis = opis;
        this.fb_link = fb_link;
        this.pozicija = pozicija;
        this.broj_pobeda = broj_pobeda;
        this.broj_izgubljenih = broj_izgubljenih;
        this.broj_poena = broj_poena;
        this.gem_plus = gem_plus;
        this.gem_minus = gem_minus;
        this.set_plus = set_plus;
        this.set_minus = set_minus;
        this.liga = liga;
        this.mesto = mesto;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getFb_link() {
        return fb_link;
    }

    public void setFb_link(String fb_link) {
        this.fb_link = fb_link;
    }

    public int getPozicija() {
        return pozicija;
    }

    public void setPozicija(int pozicija) {
        this.pozicija = pozicija;
    }

    public int getBroj_pobeda() {
        return broj_pobeda;
    }

    public void setBroj_pobeda(int broj_pobeda) {
        this.broj_pobeda = broj_pobeda;
    }

    public int getBroj_izgubljenih() {
        return broj_izgubljenih;
    }

    public void setBroj_izgubljenih(int broj_izgubljenih) {
        this.broj_izgubljenih = broj_izgubljenih;
    }

    public int getBroj_poena() {
        return broj_poena;
    }

    public void setBroj_poena(int broj_poena) {
        this.broj_poena = broj_poena;
    }

    public int getGem_plus() {
        return gem_plus;
    }

    public void setGem_plus(int gem_plus) {
        this.gem_plus = gem_plus;
    }

    public int getGem_minus() {
        return gem_minus;
    }

    public void setGem_minus(int gem_minus) {
        this.gem_minus = gem_minus;
    }

    public int getSet_plus() {
        return set_plus;
    }

    public void setSet_plus(int set_plus) {
        this.set_plus = set_plus;
    }

    public int getSet_minus() {
        return set_minus;
    }

    public void setSet_minus(int set_minus) {
        this.set_minus = set_minus;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getTakmicarID() {
        return takmicarID;
    }

    public void setTakmicarID(int takmicarID) {
        this.takmicarID = takmicarID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return "DEFAULT, '" + ime + "', "
                + "'" + prezime + "', "
                + "'" + opis + "', "
                + "'" + fb_link + "', "
                + pozicija + ", "
                + broj_pobeda + ", "
                + broj_izgubljenih + ", "
                + broj_poena + ", "
                + gem_plus + ", "
                + gem_minus + ", "
                + set_plus + ", "
                + set_minus + ", "
                + liga.getLigaID() + ", "
                + mesto.getMestoID();
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        List<IOpstiDomenskiObjekat> l = new ArrayList<>();
        l.add(mesto);
        l.add(liga);
        return l; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeTabele() {
        return "takmicar";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {

        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {
                Takmicar t = new Takmicar();
                t.setBroj_izgubljenih(rs.getInt("broj_izgubljenih"));
                t.setBroj_pobeda(rs.getInt("broj_pobeda"));
                t.setBroj_poena(rs.getInt("broj_poena"));
                t.setFb_link(rs.getString("fb_link"));
                t.setGem_minus(rs.getInt("gem_minus"));
                t.setGem_plus(rs.getInt("gem_plus"));
                t.setIme(rs.getString("ime"));
                t.setOpis(rs.getString("opis"));
                t.setPozicija(rs.getInt("pozicija"));
                t.setPrezime(rs.getString("prezime"));
                t.setSet_minus(rs.getInt("set_minus"));
                t.setSet_plus(rs.getInt("set_plus"));
//                t.setTakmicarID(takmicarID);
//                t.setLiga(liga);
//                t.setMesto(mesto);
                listaObjekata.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Takmicar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjekata;
    }

    @Override
    public Object vratiID() {
        return takmicarID;
    }

    @Override
    public String vratiNazivID() {
        return "takmicarID";
    }

    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        Takmicar t = new Takmicar();

        try {
            t.setTakmicarID(rs.getInt("takmicarID"));
            t.setSet_plus(rs.getInt("set_plus"));
            t.setBroj_izgubljenih(rs.getInt("broj_izgubljenih"));
            t.setBroj_pobeda(rs.getInt("broj_pobeda"));
            t.setBroj_poena(rs.getInt("broj_poena"));
            t.setFb_link(rs.getString("fb_link"));
            t.setGem_minus(rs.getInt("gem_minus"));
            t.setGem_plus(rs.getInt("gem_plus"));
            t.setIme(rs.getString("ime"));
            t.setOpis(rs.getString("opis"));
            t.setPozicija(rs.getInt("pozicija"));
            t.setPrezime(rs.getString("prezime"));
            t.setSet_minus(rs.getInt("set_minus"));
            Liga l = new Liga();
            l.setLigaID(rs.getInt("liga"));
            Mesto m = new Mesto();
            m.setMestoID(rs.getInt("mesto"));
            t.setMesto(m);
            t.setLiga(l);
        } catch (SQLException ex) {
            Logger.getLogger(Takmicar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            broj_izgubljenih = rs1.getInt("broj_izgubljenih");
            broj_pobeda = rs1.getInt("broj_pobeda");
            broj_poena = rs1.getInt("broj_poena");
            gem_minus = rs1.getInt("gem_minus");
            gem_plus = rs1.getInt("gem_plus");
            set_minus = rs1.getInt("set_minus");
            set_plus = rs1.getInt("set_plus");
            takmicarID = rs1.getInt("takmicarID");
            fb_link = rs1.getString("fb_link");
            opis = rs1.getString("opis");
            ime = rs1.getString("ime");
            prezime = rs1.getString("prezime");
            pozicija = rs1.getInt("pozicija");

            liga.setLigaID(rs1.getInt("liga"));
            mesto.setMestoID(rs1.getInt("mesto"));

        } catch (SQLException ex) {
            Logger.getLogger(Takmicar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String vratiImenaKolona() {
        return "" + "ime" + ", "
                + "" + "prezime " + ", "
                + "" + "opis" + ", "
                + "" + "fb_link" + ", "
                + "pozicija" + ", "
                + "broj_pobeda " + ", "
                + "broj_izgubljenih " + ", "
                + "broj_poena " + ", "
                + "gem_plus " + ", "
                + "gem_minus " + ", "
                + "set_plus " + ", "
                + "set_minus " + ", "
                + "liga" + ", "
                + "mesto";
    }

    @Override
    public String toString() {
        return "" + getIme() + " " + getPrezime();//To change body of generated methods, choose Tools | Templates.
    }

}
