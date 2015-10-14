/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicar;

import domen.IOpstiDomenskiObjekat;
import domen.Takmicar;
import domen.Takmicenje;
import exception.PreConditionException;
import exception.SistemOperationException;
import exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;
import so.takmicenje.SO_VratiListuTakmicenja;

/**
 *
 * @author Raca420
 */
public class SO_VratiListuTakmicara extends AbstractSO{
    private List<IOpstiDomenskiObjekat> lista;

    public SO_VratiListuTakmicara() {
        lista = new ArrayList<>();
    }

    
    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            lista = db.vratiListuSvihObjekata(new Takmicar());
        } catch (Exception ex) {
            System.out.println("GRESKA KOD SO VRATI LISTU TAKMICARA " +ex.getMessage());
        }
    }

    public List<IOpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<IOpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
}
