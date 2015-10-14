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
public class Mec implements IOpstiDomenskiObjekat {

    private int mecID;
    private String rezultat;
    private Takmicar takmicarDID;
    private Takmicar takmicarGID;

    public Mec() {
        takmicarDID = new Takmicar();
        takmicarGID = new Takmicar();
    }

    public Mec(int mecID, String rezultat, Takmicar takmicarDID, Takmicar takmicarGID) {
        this.mecID = mecID;
        this.rezultat = rezultat;
        this.takmicarDID = takmicarDID;
        this.takmicarGID = takmicarGID;
    }

    public int getMecID() {
        return mecID;
    }

    public void setMecID(int mecID) {
        this.mecID = mecID;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Takmicar getTakmicarDID() {
        return takmicarDID;
    }

    public void setTakmicarDID(Takmicar takmicarDID) {
        this.takmicarDID = takmicarDID;
    }

    @Override
    public String toString() {
        return "Domacin > " + getTakmicarDID() + " gost > " + getTakmicarGID() + " rez > " + getRezultat();
    }

    public Takmicar getTakmicarGID() {
        return takmicarGID;
    }

    public void setTakmicarGID(Takmicar takmicarGID) {
        this.takmicarGID = takmicarGID;
    }

    @Override
    public String vratiPodatkeZaInsert() {
        return "DEFAULT, " + takmicarDID.getTakmicarID() + ", "
                + "" + takmicarGID.getTakmicarID() + ", "
                + "'" + rezultat + "'";
    }

    @Override
    public String vratiImenaKolona() {
        return "takmicarDID" + ", "
                + "" + "takmicarGID" + ", "
                + "'" + "rezultat " + "'";
    }

    @Override
    public String vratiImeTabele() {
        return "mec";
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) {
        List<IOpstiDomenskiObjekat> listaObjekata = new ArrayList<>();

        try {
            while (rs.next()) {
                Mec m = new Mec();
                m.setRezultat(rs.getString("rezultat"));
//                m.setTakmicarDID(takmicarDID);
//                m.setTakmicarGID(takmicarGID);
                listaObjekata.add(m);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Mec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaObjekata;
    }

    @Override
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata() {
        List<IOpstiDomenskiObjekat> l = new ArrayList<>();
        l.add(takmicarDID);
        l.add(takmicarGID);
        return l;
    }

//    @Override
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs) {
        Mec m = new Mec();
        try {
            m.setMecID(rs.getInt("mecID"));
            m.setRezultat(rs.getString("rezultat"));

            Takmicar td = new Takmicar();
            td.setTakmicarID(rs.getInt("takmicarDID"));
            Takmicar tg = new Takmicar();
            tg.setTakmicarID(rs.getInt("takmicarGID"));
            m.setTakmicarDID(td);
            m.setTakmicarGID(tg);

        } catch (SQLException ex) {
            Logger.getLogger(Mec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

    @Override
    public Object vratiID() {
        return mecID;
    }

    @Override
    public String vratiNazivID() {
        return "mecID";
    }

    @Override
    public void napuniObjekat(ResultSet rs1) {
        try {
            mecID = rs1.getInt("mecID");
            rezultat = rs1.getString("rezultat");
            takmicarDID.setTakmicarID(rs1.getInt("takmicarDID"));
            takmicarGID.setTakmicarID(rs1.getInt("takmicarGID"));
        } catch (SQLException ex) {
            Logger.getLogger(Mec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
