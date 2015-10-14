/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicenje;

import domen.Takmicenje;
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
public class SO_UpdateTakmicenje extends AbstractSO {

    Takmicenje t;

    public SO_UpdateTakmicenje(Takmicenje t) {
        this.t = t;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
    }

   

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.updateObjekta(t);
        } catch (SQLException ex) {
            throw new SistemOperationException("Nije uspeo update");
        }
    }
}
