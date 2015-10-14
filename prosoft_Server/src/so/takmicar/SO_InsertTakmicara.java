/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.takmicar;

import domen.Takmicar;
import exception.SistemOperationException;
import exception.ValidationException;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author Raca420
 */
public class SO_InsertTakmicara extends AbstractSO {

    private Takmicar takmicar;

    public SO_InsertTakmicara(Takmicar takmicar) {
        this.takmicar = takmicar;
    }

    @Override
    protected void izvrsiValidaciju() throws ValidationException {
//        if (takmicar.getLiga().getBroj_takmicara() >= 10) {
//            throw new ValidationException("Izabrana liga vec ima 10 takmicara!");
//        }

    }

    @Override
    protected void izvrsiTransakciju() throws SistemOperationException {
        try {
            db.insertObjekta(takmicar);
        } catch (SQLException ex) {
            System.out.println("GRESKA KOD SO INSERT TAKMICARAMA > " + ex.getMessage());
        }
    }


}
