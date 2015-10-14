/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.IOpstiDomenskiObjekat;
import domen.Liga;
import domen.Mec;
import domen.Takmicar;
import domen.Takmicenje;
import domen.TipTakmicenja;
import domen.User;
import java.io.File;
import java.util.List;
import konstante.Konstante;
import so.AbstractSO;
import so.liga.SO_KreirajLigu;
import so.liga.SO_VratiLige;
import so.mec.SO_UnosMeca;
import so.mec.SO_VratiMeceve;
import so.mesto.SO_VratiMesta;
import so.takmicar.SO_DeleteTakmicara;
import so.takmicar.SO_InsertTakmicara;
import so.takmicar.SO_UpdateTakmicar;
import so.takmicar.SO_VratiListuTakmicara;
import so.takmicenje.SO_InsertTakmicenje;
import so.takmicenje.SO_UpdateTakmicenje;
import so.takmicenje.SO_VratiListuTakmicenja;
import so.tiptakmicenja.SO_InsertTipTakmicenja;
import so.tiptakmicenja.SO_VratiListuTipovaTakmicenja;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Raca420
 */
public class KontrolerServer {

//    public static L
    
    private static ServerTransferObjekat sto;

    public static ServerTransferObjekat OPERACIJA_LOGOVANJE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        User u = (User) kto.getObjekat();
        if (u.getUserName().equals("ivan") && u.getPass().equals("ivan")) {
            sto.setUspesno(1);
            return sto;
        } else {
            sto.setUspesno(0);
            return sto;
        }
    }

    public static ServerTransferObjekat OPERACIJA_KREIRAJ_TIPTAKMICENJA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        AbstractSO ab = new SO_InsertTipTakmicenja((TipTakmicenja) kto.getObjekat());
        try {
            ab.izvrsiOperaciju();
            sto.setUspesno(1);
            sto.setPodaci("Uspesno ste kreirali tip takmicenja");
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(new Exception("Vrsta sistema moze biti 1 ili 2"));
            return sto;
        }
    }

    public static ServerTransferObjekat OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        AbstractSO ab = new SO_VratiListuTipovaTakmicenja();
        try {
            ab.izvrsiOperaciju();
            List l = ((SO_VratiListuTipovaTakmicenja) ab).getListaTipova();
            sto.setPodaci(l);
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setGreska(e);
            sto.setUspesno(-1);
            return sto;
        }
    }

    public static Object OPERACIJA_KREIRAJ_TAKMICENJE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_InsertTakmicenje((Takmicenje) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setPodaci("Uspesno kreirano takmicenje!");
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_VRATI_SVA_TAKMICENJA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab3 = new SO_VratiListuTakmicenja();
            ab3.izvrsiOperaciju();
            List l = ((SO_VratiListuTakmicenja) ab3).getLista();
            sto.setPodaci(l);
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setGreska(e);
            sto.setUspesno(-1);
            return sto;
        }
    }

    public static Object OPERACIJA_UPDATE_TAKMICENJE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_UpdateTakmicenje((Takmicenje) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_KREIRAJ_LIGU(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_KreirajLigu((Liga) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setUspesno(1);
            sto.setPodaci("Uspesno kreirana liga");
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_VRATI_LIGE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {

        try {
            AbstractSO ab3 = new SO_VratiLige();
            ab3.izvrsiOperaciju();
            List l = ((SO_VratiLige) ab3).getListaLiga();
            sto.setPodaci(l);
            sto.setUspesno(1);

            System.out.println("sto1" + sto);

            return sto;
        } catch (Exception e) {
            sto.setGreska(e);
            sto.setUspesno(-1);

            System.out.println("sto-1" + sto);

            return sto;
        }
    }

    public static Object OPERACIJA_VRATI_SVE_TAKMICARE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab3 = new SO_VratiListuTakmicara();
            ab3.izvrsiOperaciju();
            List l = ((SO_VratiListuTakmicara) ab3).getLista();
            sto.setPodaci(l);
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setGreska(e);
            sto.setUspesno(-1);
            return sto;
        }
    }

    public static Object OPERACIJA_VRATI_SVA_MESTA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_VratiMesta();
            ab.izvrsiOperaciju();
            List l = ((SO_VratiMesta) ab).getLista();
            sto.setPodaci(l);
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setGreska(e);
            sto.setUspesno(-1);
            return sto;
        }
    }

    public static Object OPERACIJA_KREIRAJ_TAKMICARA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_InsertTakmicara((Takmicar) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setUspesno(1);
            sto.setPodaci("Uspesno kreiran takmicar");
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_UPDATE_TAKMICAR(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_UpdateTakmicar((Takmicar) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setPodaci("Uspesan update takmicara!");
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_UNOS_MECA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_UnosMeca((Mec) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setPodaci(((SO_UnosMeca) ab).getM());
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_DELETE_TAKMICARA(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_DeleteTakmicara((Takmicar) kto.getObjekat());
            ab.izvrsiOperaciju();
            sto.setPodaci("Uspesno obrisan takmicar!");
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

    public static Object OPERACIJA_VRATI_MECEVE(KlijentTransferObjekat kto, ServerTransferObjekat sto) {
        try {
            AbstractSO ab = new SO_VratiMeceve();
            ab.izvrsiOperaciju();
            sto.setPodaci(((SO_VratiMeceve) ab).getListu());
            sto.setUspesno(1);
            return sto;
        } catch (Exception e) {
            sto.setUspesno(-1);
            sto.setGreska(e);
            return sto;
        }
    }

}
