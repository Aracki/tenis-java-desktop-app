/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicar;

import domen.Takmicar;
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
public class SO_DeleteTakmicara extends AbstractSO{

    private Takmicar tak;

    public SO_DeleteTakmicara(Takmicar tak) {
        this.tak = tak;
    }
    
    
    
    @Override
    protected void izvrsiValidaciju() throws ValidationException {
    }

   

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.deleteObjekat(tak);
        } catch (SQLException ex) {
            throw new SistemOperationException(ex.getMessage());
        }
    }
    
}
