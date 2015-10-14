/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Raca420
 */
public class ServerTransferObjekat implements Serializable {

    private Object podaci;
    private int uspesno;
    private int operacija;

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    private Exception greska;

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesno() {
        return uspesno;
    }

    public void setUspesno(int uspesno) {
        this.uspesno = uspesno;
    }

    public Exception getGreska() {
        return greska;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    @Override
    public String toString() {
        return "STO *** Podaci> " + getPodaci() + " Operacija > " + getOperacija() + " uspesno? " + getUspesno();
    }

}
