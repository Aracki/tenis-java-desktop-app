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
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_InsertTakmicenje extends AbstractSO {
    
    private Takmicenje takmicenje;
    
    public SO_InsertTakmicenje(Takmicenje takmicenje) {
        this.takmicenje = takmicenje;
    }
    
    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        
    }
    
    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.insertObjekta(takmicenje);
        } catch (SQLException ex) {
            Logger.getLogger(SO_InsertTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
