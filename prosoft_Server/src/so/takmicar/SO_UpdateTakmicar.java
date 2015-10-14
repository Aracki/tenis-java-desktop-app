/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicar;

import domen.Takmicar;
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
public class SO_UpdateTakmicar extends AbstractSO {

    Takmicar t;

    public SO_UpdateTakmicar(Takmicar t) {
        this.t = t;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        if (t.getLiga().getBroj_takmicara() >= 10) {
            throw new ValidationException("Izabrana liga vec ima 10 takmicara!");
        }

    }

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.updateObjekta(t);
        } catch (SQLException ex) {
            throw new SistemOperationException("Nije uspeo update - sql exception");
        }
    }
}
