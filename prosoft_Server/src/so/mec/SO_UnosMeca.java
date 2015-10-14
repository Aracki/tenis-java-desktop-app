/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.mec;

import domen.Mec;
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
public class SO_UnosMeca extends AbstractSO {

    private static Mec m;
    private String rezultat;    
    

    public SO_UnosMeca(Mec m) {
        this.m = m;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
        if(m.getTakmicarDID().getTakmicarID() == m.getTakmicarGID().getTakmicarID()){
            throw new ValidationException("Izabrali ste dva ista tenisera!");
        }
    }

   
    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.insertObjekta(m);
        } catch (SQLException ex) {
            throw new SistemOperationException("SQL greska kod unosa meca");
        }
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Mec getM() {
        return m;
    }
    
    

}
