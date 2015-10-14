/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.mec;

import domen.Mec;
import exception.SistemOperationException;
import exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_VratiMeceve extends AbstractSO {

    private List<Mec> l;

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
    }

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            l = db.vratiListuSvihObjekata(new Mec());
        } catch (Exception ex) {
            throw new SistemOperationException("Sistem ne moze da nadje meceve");
        }
    }

    public Object getListu() {
        return l;
    }

}
