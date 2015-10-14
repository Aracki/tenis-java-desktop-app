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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_InsertTipTakmicenja extends AbstractSO {

    TipTakmicenja tt;

    public SO_InsertTipTakmicenja(TipTakmicenja tt) {
        this.tt = tt;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        if ((tt.getVrsta_sistema() == 1) || (tt.getVrsta_sistema() == 2)) {

        } else {
            throw new ValidationException("Vrsta sistema mora da bude 1 ili 2");
        }
    }

   

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.insertObjekta(tt);
        } catch (SQLException ex) {
            Logger.getLogger(SO_InsertTipTakmicenja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
