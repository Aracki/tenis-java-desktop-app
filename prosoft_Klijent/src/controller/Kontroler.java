/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.IOpstiDomenskiObjekat;
import domen.Mec;
import domen.Takmicar;
import domen.User;
import domen.Takmicenje;
import domen.TipTakmicenja;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import konstante.Konstante;
import threads.KlijentskaNit;
import transfer.KlijentTransferObjekat;
import view.frmLogovanje;
import view.tabTakmicenja.DlgIzmeniTakmicenje;

/**
 *
 * @author Raca420
 */
public class Kontroler {

    private static Kontroler instance;
    private KlijentskaNit kn;

    public Kontroler() {
        kn = frmLogovanje.kn;
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public void posaljiObjekat(KlijentTransferObjekat kto) throws IOException {
        kn.out.writeObject(kto);
    }

//    public void posaljiZahtevZaTT() {
//        KlijentTransferObjekat kto = new KlijentTransferObjekat();
//        kto.setOperacija(Konstante.OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA);
//        try {
//            posaljiObjekat(kto);
//        } catch (IOException ex) {
//            Logger.getLogger(DlgIzmeniTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void posaljiZahtevZaTakmicenja() {
//        KlijentTransferObjekat kto = new KlijentTransferObjekat();
//        kto.setOperacija(Konstante.OPERACIJA_VRATI_SVA_TAKMICENJA);
//        try {
//            posaljiObjekat(kto);
//        } catch (IOException ex) {
//            Logger.getLogger(DlgIzmeniTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void posaljiZahtevZaLige(){
//        KlijentTransferObjekat kto = new KlijentTransferObjekat();
//        kto.setOperacija(Konstante.OPERACIJA_VRATI_LIGE);
//        System.out.println("zahtev > " + kto);
//        try {
//            posaljiObjekat(kto);
//        } catch (IOException ex) {
//            Logger.getLogger(DlgIzmeniTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void posaljiZahtevZaTakmicare(){
//        KlijentTransferObjekat kto = new KlijentTransferObjekat();
//        kto.setOperacija(Konstante.OPERACIJA_VRATI_SVE_TAKMICARE);
//        System.out.println("zahtev > " + kto);
//        try {
//            posaljiObjekat(kto);
//        } catch (IOException ex) {
//            Logger.getLogger(DlgIzmeniTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//     public void posaljiZahtevZaMesta(){
//        KlijentTransferObjekat kto = new KlijentTransferObjekat();
//        kto.setOperacija(Konstante.OPERACIJA_VRATI_SVA_MESTA);
//        System.out.println("zahtev > " + kto);
//        try {
//            posaljiObjekat(kto);
//        } catch (IOException ex) {
//            Logger.getLogger(DlgIzmeniTakmicenje.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void posaljiZahtevZaPodatke() {
        List<KlijentTransferObjekat> listaKto = new ArrayList<>();
        KlijentTransferObjekat kto1 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto2 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto3 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto4 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto5 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto6 = new KlijentTransferObjekat();
        KlijentTransferObjekat kto7 = new KlijentTransferObjekat();

        kto1.setOperacija(Konstante.OPERACIJA_VRATI_SVA_MESTA);
        kto2.setOperacija(Konstante.OPERACIJA_VRATI_SVE_TAKMICARE);
        kto3.setOperacija(Konstante.OPERACIJA_VRATI_LIGE);
        kto4.setOperacija(Konstante.OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA);
        kto5.setOperacija(Konstante.OPERACIJA_VRATI_SVA_TAKMICENJA);
        kto6.setOperacija(Konstante.OPERACIJA_VRATI_SVE_TAKMICARE);
        kto7.setOperacija(Konstante.OPERACIJA_VRATI_SVE_MECEVE);

        listaKto.add(kto1);
        listaKto.add(kto2);
        listaKto.add(kto3);
        listaKto.add(kto4);
        listaKto.add(kto5);
        listaKto.add(kto6);
        listaKto.add(kto7);

        for (KlijentTransferObjekat k : listaKto) {
            try {
                posaljiObjekat(k);
            } catch (IOException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void izvrsiUpdatePosleMeca(Object podaci) {
        if (podaci instanceof Mec) {
            Mec m = (Mec) podaci;
            Takmicar tD = m.getTakmicarDID();
            Takmicar tG = m.getTakmicarGID();
            String rez = m.getRezultat();

            // 7:6, 2:6, 6:4
            String[] setovi = rez.split(",");
            int brGemDomPlus = 0;
//            int brGemDomMinus = 0;
            int brSetDomPlus = 0;
//            int brSetDomMinus = 0;

            int brGemGostPlus = 0;
//            int brGemGostMinus = 0;
            int brSetGostPlus = 0;
//            int brSetGostMinus = 0;

            System.out.println("SETOVI>>> " + Arrays.toString(setovi));
            for (int i = 0; i < setovi.length; i++) {
                String set = setovi[i].trim();
                System.out.println("SET" + i + ">>> " + set);

                String[] gem = set.split(":");
                System.out.println("GEM>>> " + Arrays.toString(gem));

                if (Integer.parseInt(gem[0]) > Integer.parseInt(gem[1])) {
                    brGemDomPlus += Integer.parseInt(gem[0].trim());
                    brGemGostPlus += Integer.parseInt(gem[1].trim());
                    brSetDomPlus++;
//                    brSetGostPlus--;
                }
                if (Integer.parseInt(gem[1]) > Integer.parseInt(gem[0])) {
                    brGemDomPlus += Integer.parseInt(gem[0].trim());
                    brGemGostPlus += Integer.parseInt(gem[1].trim());
//                    brSetDomPlus--;
                    brSetGostPlus++;
                }

            }
            tD.setGem_plus(brGemDomPlus + tD.getGem_plus());
            tD.setGem_minus(tD.getGem_minus() - brGemGostPlus);
            tG.setGem_plus(brGemGostPlus + tG.getGem_plus());
            tG.setGem_minus(tG.getGem_minus() - brGemDomPlus);

            tD.setSet_plus(tD.getSet_plus() + brSetDomPlus);
            tD.setSet_minus(tD.getSet_minus() - brSetGostPlus);
            tG.setSet_plus(tG.getSet_plus() + brSetGostPlus);
            tG.setSet_minus(tG.getSet_minus() - brSetDomPlus);

            if (brSetDomPlus > brSetGostPlus) {
                tD.setBroj_pobeda(tD.getBroj_pobeda() + 1);
                tG.setBroj_izgubljenih(tG.getBroj_izgubljenih() - 1);
            } else {
                tG.setBroj_pobeda(tG.getBroj_pobeda() + 1);
                tD.setBroj_izgubljenih(tD.getBroj_izgubljenih() - 1);
            }

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Konstante.OPERACIJA_UPDATE_TAKMICAR);
            kto.setObjekat(tD);
            KlijentTransferObjekat kto1 = new KlijentTransferObjekat();
            kto1.setOperacija(Konstante.OPERACIJA_UPDATE_TAKMICAR);
            kto1.setObjekat(tG);

            try {
                posaljiObjekat(kto);
                posaljiObjekat(kto1);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Greska kod update takmicara posle unosa meca!");
            }
        }
    }
}
