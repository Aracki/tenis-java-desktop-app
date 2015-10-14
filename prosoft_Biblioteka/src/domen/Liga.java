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
public class Liga implements IOpstiDomenskiObjekat {

    private int ligaID;
    private String naziv;
    private int broj_takmicara;
    private Takmicenje takmicenje;
    private List<Takmicar> listaTakmicara;

    public Liga() {
        listaTakmicara = new ArrayList<>();
        takmicenje = new Takmicenje();
    }

    public Liga(int ligaID, String naziv, int broj_takmicara, Takmicenje takmicenje, List<Takmicar> listaTakmicara) {
        this.ligaID = ligaID;
        this.naziv = naziv;
        this.broj_takmicara = broj_takmicara;
        this.takmicenje = takmicenje;
        this.listaTakmicara = listaTakmicara;
    }

    public int getLigaID() {
        return ligaID;
    }

    public void setLigaID(int ligaID) {
        this.ligaID = ligaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_takmicara() {
        return broj_takmicara;
    }

    public void setBroj_takmicara(int broj_takmicara) {
        this.broj_takmicara = broj_takmicara;
    }

    public Takmicenje getTakmicenje() {
        return takmicenje;
    }

    public void setTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }

    public List<Takmicar> getListaTakmicara() {
        return listaTakmicara;
    }

    public void setListaTakmicara(List<Takmicar> listaTakmicara) {
        this.listaTakmicara = listaTakmicara;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return "DEFAULT, '" + naziv + "', "
                + "" + broj_takmicara + ", "
                + "" + takmicenje.getTakmicenjeID();
    }

    @Override
    public String vratiImeTabele() {
        return "liga";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {

        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {
                Liga l = new Liga();
                l.setBroj_takmicara(rs.getInt("broj_takmicara"));
                l.setNaziv(rs.getString("naziv"));
//                l.setTakmicenje((Takmicenje) rs.getObject("takmicenje"));
//                l.setListaTakmicara(listaTakmicara);
                listaObjekata.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Liga.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjekata;
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        List<IOpstiDomenskiObjekat> l = new ArrayList<>();
        l.add(takmicenje);
        return l;
    }

    @Override
    public Object vratiID() {
        return ligaID;
    }

    @Override
    public String vratiNazivID() {
        return "ligaID";
    }

    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        Liga l = new Liga();
        try {
            l.setLigaID(rs.getInt("ligaID"));
            l.setNaziv(rs.getString("naziv"));
            l.setBroj_takmicara(rs.getInt("broj_takmicara"));

            //!!!
            Takmicenje t = new Takmicenje();
            t.setTakmicenjeID(rs.getInt("takmicenje"));
            l.setTakmicenje(t);

        } catch (SQLException ex) {
            System.out.println("Greska kod napraviObjekat() - liga" + ex.getMessage());

        }
        return l;
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            broj_takmicara = rs1.getInt("broj_takmicara");
            ligaID = rs1.getInt("ligaID");
            naziv = rs1.getString("naziv");
            takmicenje.setTakmicenjeID(rs1.getInt("takmicenje"));
        } catch (SQLException ex) {
            System.out.println("Greska kod napuniObjekat() - liga" + ex.getMessage());

        }
    }

    @Override
    public String vratiImenaKolona() {
        return "'" + "naziv " + "', "
                + "" + "broj_takmicara " + ", "
                + "" + "takmicenje"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Liga other = (Liga) obj;
        if (this.ligaID != other.ligaID) {
            return false;
        }
        return true;
    }

}
