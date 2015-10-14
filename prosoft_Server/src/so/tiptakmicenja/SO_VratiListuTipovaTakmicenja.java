/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tiptakmicenja;

import domen.TipTakmicenja;
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
public class SO_VratiListuTipovaTakmicenja extends AbstractSO {

    private List<TipTakmicenja> listaTipova;

    public SO_VratiListuTipovaTakmicenja() {
        listaTipova = new ArrayList<>();
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {

    }


    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            listaTipova = db.vratiListuSvihObjekata(new TipTakmicenja());
            
        } catch (Exception ex) {
            Logger.getLogger(SO_VratiListuTipovaTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TipTakmicenja> getListaTipova() {
        return listaTipova;
    }

    public void setListaTipova(List<TipTakmicenja> listaTipova) {
        this.listaTipova = listaTipova;
    }

}
