/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import db.DBBroker;
import domen.IOpstiDomenskiObjekat;
import domen.Liga;
import domen.Mesto;
import domen.Takmicar;
import domen.Takmicenje;
import domen.TipTakmicenja;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raca420
 */
public class test {

    public static void main(String[] args) {
        db.DBBroker db = new DBBroker();
        try {
            db.otvoriKonekaciju();
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        Takmicenje t = new Takmicenje();
        
//        List<IOpstiDomenskiObjekat> l = db.vratiListuSvihObjekata(t);
//        System.out.println(l);

        Mesto m1 = new Mesto();
        m1.setMestoID(121);
        m1.setNaziv("beograd");
        Mesto m2 = new Mesto();
        m2.setMestoID(12323);
        m2.setNaziv("ns");
        Liga l1 = new Liga();
        l1.setNaziv("kurceva liga");
        l1.setTakmicenje(t);
//        try {
////          db.updateObjekta(l1)
//        } catch (SQLException ex) {
//            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Takmicar t1 = new Takmicar();
        t1.setIme("Mare");
        t1.setPrezime("barackovi");
        t1.setMesto(m1);
        t1.setLiga(l1);

        Takmicar t2 = new Takmicar();
        t2.setIme("Ogi");
        t2.setPrezime("barackovi");
        t2.setMesto(m2);
        t2.setLiga(l1);
        
        
        Takmicenje t11 = new Takmicenje();
        t11.setTakmicenjeID(2);
        TipTakmicenja p =  new TipTakmicenja();
        p.setTiptakmicenjaID(3);
        t11.setTiptakmicenja(p);
        t11.setDatum_pocetka(new Date(2008-11-11));
        try {
            db.updateObjekta(t11);
//            db.insertObjekta(t2);

//            System.out.println(x);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
