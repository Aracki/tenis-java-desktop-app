    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import exception.PreConditionException;
import exception.SistemOperationException;
import exception.ValidationException;
import java.sql.SQLException;

/**
 *
 * @author student1
 */
public abstract class AbstractSO {

    protected DBBroker db;

    public AbstractSO() {
        db = new DBBroker();
    }

    public void izvrsiOperaciju() throws Exception {
        otvoriKonekciju();
        try {
            izvrsiValidaciju();
            izvrsiTransakciju();
            potvrdiTransakciju();
        } catch (ValidationException ve) {
            throw new Exception(ve.getMessage());
        } catch (SistemOperationException soe) {
            ponistiTransakciju();
            throw new Exception(soe.getMessage());
        } finally {
            zatvoriKonekciju();
        }
    }

    private void otvoriKonekciju() throws SQLException {
        db.otvoriKonekaciju();
    }

    private void zatvoriKonekciju() throws SQLException {
        db.zatvoriKonekciju();
    }

    protected abstract void izvrsiValidaciju() throws ValidationException;

    protected abstract void izvrsiTransakciju() throws SistemOperationException;

    private void potvrdiTransakciju() throws SQLException {
        db.commit();
    }

    private void ponistiTransakciju() throws SQLException {
        db.rollback();
    }

}
