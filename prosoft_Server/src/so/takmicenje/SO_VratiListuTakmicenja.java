/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicenje;

import domen.IOpstiDomenskiObjekat;
import domen.Takmicenje;
import exception.PreConditionException;
import exception.SistemOperationException;
import exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_VratiListuTakmicenja extends AbstractSO {

    private List<IOpstiDomenskiObjekat> lista;

    public SO_VratiListuTakmicenja() {
        lista = new ArrayList<>();
    }

    
    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            lista = db.vratiListuSvihObjekata(new Takmicenje());
        } catch (Exception ex) {
            Logger.getLogger(SO_VratiListuTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<IOpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<IOpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

}
