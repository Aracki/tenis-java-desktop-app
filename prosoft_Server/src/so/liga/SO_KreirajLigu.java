/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.liga;

import domen.Liga;
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
public class SO_KreirajLigu extends AbstractSO {

    private Liga l;

    public SO_KreirajLigu(Liga l) {
        this.l = l;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        if (l.getBroj_takmicara() > 10 || l.getBroj_takmicara() < 2) {
            throw new ValidationException("Broj takmicara mora biti u rasponu 2-10"); 
        }
    }

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.insertObjekta(l);
        } catch (SQLException ex) {
            throw new SistemOperationException("SQL greska za unos lige");
        }
    }

}
