/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Raca420
 */
public interface IOpstiDomenskiObjekat extends Serializable {

    public String vratiPodatkeZaInsert();
    
    public String vratiImenaKolona();

    public String vratiImeTabele();

    public List<IOpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs);
    
    public List<IOpstiDomenskiObjekat> vratiListuPovezanihObjekata();
    
    public IOpstiDomenskiObjekat napraviObjekat(ResultSet rs);
    
    public Object vratiID();
    
    public String vratiNazivID();

    public void napuniObjekat(ResultSet rs1);
    
    
    
//    public String vratiPodatkeZaUpdate();
}
