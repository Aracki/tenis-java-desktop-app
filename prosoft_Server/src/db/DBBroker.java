/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IOpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raca420
 */
public class DBBroker {

    Connection conn;

    public void otvoriKonekaciju() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/ps_baza";
        String USER = "ivan";
        String PASS = "ivan";
        conn = DriverManager.getConnection(URL, USER, PASS);

        //AKO KORISTIMO commit() i rollback()
        conn.setAutoCommit(false);
    }

    public void zatvoriKonekciju() throws SQLException {
        conn.close();
    }

    public void commit() throws SQLException {
        conn.commit();
    }

    public void rollback() throws SQLException {
        conn.rollback();
    }

    public List vratiListuSvihObjekata(IOpstiDomenskiObjekat odo) throws Exception {

        String upit = "Select * FROM " + odo.vratiImeTabele();
        System.out.println("UPIT > " + upit);
        Statement naredba = conn.createStatement();

        ResultSet rs = naredba.executeQuery(upit);
        List<IOpstiDomenskiObjekat> objekti = new ArrayList<>();
        while (rs.next()) {
            System.out.println("ODO1 " + odo.napraviObjekat(rs));
            IOpstiDomenskiObjekat odo1 = odo.napraviObjekat(rs);
            napuniObjekatDB(odo1);
            objekti.add(odo1);
        }
        System.out.println("Objekti (" + odo.vratiImeTabele() + ") >>> " + objekti.toString());
        return objekti;
    }

    public void napuniObjekatDB(IOpstiDomenskiObjekat odo) {
        if (odo.vratiListuPovezanihObjekata().size() > 0) {
            for (IOpstiDomenskiObjekat o : odo.vratiListuPovezanihObjekata()) {
                try {
                    String u = "Select * FROM " + o.vratiImeTabele() + " where " + o.vratiNazivID() + " = " + o.vratiID();
                    Statement n = conn.createStatement();

                    ResultSet rs1 = n.executeQuery(u);
                    if (rs1.next()) {

                        o.napuniObjekat(rs1);
                    }
                    napuniObjekatDB(o);
                } catch (SQLException ex) {
                    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public int deleteObjekat(IOpstiDomenskiObjekat odo) throws SQLException {

        String upit = "DELETE FROM " + odo.vratiImeTabele() + " WHERE " + odo.vratiNazivID() + " = " + odo.vratiID();
        Statement st = conn.createStatement();

        int x = st.executeUpdate(upit);
        return x;
    }

    // ogi i raca kreatori
    public int updateObjekta(IOpstiDomenskiObjekat odo) throws SQLException {
        String[] nizKolona = odo.vratiImenaKolona().split(",");
        String[] vrednostiKolona = odo.vratiPodatkeZaInsert().split(",");
        Statement st = conn.createStatement();

        String upit = "UPDATE " + odo.vratiImeTabele()
                + " SET ";

        for (int i = 0; i < nizKolona.length; i++) {
            upit += nizKolona[i].trim() + " = " + vrednostiKolona[i + 1].trim() + ",";
        }
        upit = upit.substring(0, upit.length() - 1);
        upit += " WHERE " + odo.vratiNazivID() + " = " + odo.vratiID();
        System.out.println(upit);
        return st.executeUpdate(upit);
    }

    public int insertObjekta(IOpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO " + odo.vratiImeTabele()
                + " VALUES(" + odo.vratiPodatkeZaInsert() + ")";
        System.out.println("odo > " + odo.vratiImeTabele() + " podaci > " + odo.vratiPodatkeZaInsert());
        Statement st = conn.createStatement();
        return st.executeUpdate(upit);
    }

}
