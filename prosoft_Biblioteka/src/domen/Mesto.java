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
public class Mesto implements IOpstiDomenskiObjekat {

    private int ptt;
    private String naziv;
    private List<Takmicar> listaTakmicara;

    public Mesto() {
        listaTakmicara = new ArrayList<>();
    }

    public Mesto(int ptt, String naziv, List<Takmicar> listaTakmicara) {
        this.ptt = ptt;
        this.naziv = naziv;
        this.listaTakmicara = listaTakmicara;
    }

    public int getMestoID() {
        return ptt;
    }

    public void setMestoID(int mestoID) {
        this.ptt = mestoID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Takmicar> getListaTakmicara() {
        return listaTakmicara;
    }

    public void setListaTakmicara(List<Takmicar> listaTakmicara) {
        this.listaTakmicara = listaTakmicara;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return ptt + ", "
                + "'" + naziv + "'";
    }

    @Override
    public String vratiImeTabele() {
        return "mesto";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {
                Mesto m = new Mesto();
                m.setNaziv(rs.getString("naziv"));
//                m.setListaTakmicara(listaTakmicara);
                listaObjekata.add(m);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjekata;
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        return new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object vratiID() {
        return ptt;
    }

    @Override
    public String vratiNazivID() {
        return "ptt";
    }

    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        Mesto m = new Mesto();

        try {
            m.setNaziv(rs.getString("naziv"));
            m.setMestoID(rs.getInt("ptt"));

        } catch (SQLException ex) {
            System.out.println("Greska kod napraviObjekat() - mesto" + ex.getMessage());

        }
        return m;
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            naziv = rs1.getString("naziv");
            ptt = rs1.getInt("ptt");
        } catch (SQLException ex) {
            System.out.println("Greska kod napuniObjekat() - mesto" + ex.getMessage());
        }
    }

    @Override
    public String vratiImenaKolona() {
        return "naziv";
    }

    @Override
    public String toString() {
        return "" + getNaziv() + " (" + getMestoID() + ")"; //To change body of generated methods, choose Tools | Templates.
    }

}
