/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.liga;

import domen.IOpstiDomenskiObjekat;
import domen.Liga;
import exception.PreConditionException;
import exception.SistemOperationException;
import exception.ValidationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_VratiLige extends AbstractSO {

    private List<IOpstiDomenskiObjekat> listaLiga;

    public List<IOpstiDomenskiObjekat> getListaLiga() {
        return listaLiga;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
    }

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            listaLiga = db.vratiListuSvihObjekata(new Liga());

        } catch (Exception ex) {
            throw new SistemOperationException("SQL greska" + ex.getMessage());
        }
    }

}
