/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import controller.Kontroler;
import controller.Podaci;
import domen.Liga;
import domen.Mec;
import domen.Mesto;
import domen.Takmicar;
import domen.Takmicenje;
import domen.TipTakmicenja;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import konstante.Konstante;
import transfer.ServerTransferObjekat;
import view.frmGlavna;
import view.frmLogovanje;
import view.tabTakmicenja.DlgUnosTakmicenja;

/**
 *
 * @author Raca420
 */
public class KlijentskaNit extends Thread {

    Socket s;
    private ObjectInputStream in;
    public ObjectOutputStream out;

    @Override
    public void run() {

        try {
            while (true) {
                System.out.println("Klijent ceka na server...");
                try {
                    ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
                    System.out.println("Klijent prihvatio objekat...");
                    System.out.println(sto);
                    switch (sto.getOperacija()) {
                        case Konstante.OPERACIJA_LOGOVANJE:
                            if (sto.getUspesno() == 1) {
                                System.out.println("Uspesno izvrsena operacija logovanja...");
                                frmLogovanje.ulogovan = true;
                            }
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TIPTAKMICENJA:
                            if (sto.getUspesno() == 1) {
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA:
                            if (sto.getUspesno() == 1) {
                                System.out.println("uspesno vraca liste >> " + (List) sto.getPodaci());

                                Podaci.listaTipovaTakmicenja = (List<TipTakmicenja>) sto.getPodaci();
                                DlgUnosTakmicenja.napuniCombo();
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_SVA_TAKMICENJA:
                            if (sto.getUspesno() == 1) {
                                Podaci.listaTakmicenja = (List<Takmicenje>) sto.getPodaci();
                                frmGlavna.napuniListuTakmicenja();
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TAKMICENJE:
                            if (sto.getUspesno() == 1) {//                              
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_LIGU:
                            if (sto.getUspesno() == 1) {//                              
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_LIGE:
                            if (sto.getUspesno() == 1) {
                                Podaci.listaLiga = (List<Liga>) sto.getPodaci();
                                frmGlavna.napuniLige();
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_TAKMICARE:
                            if (sto.getUspesno() == 1) {
                                System.out.println("KOKOKO" + ((List<Takmicar>) sto.getPodaci()).toString());
                                Podaci.listaTakmicara = (List<Takmicar>) sto.getPodaci();
                                System.out.println("DDD" + Podaci.listaTakmicara);
                                frmGlavna.napuniTblTakmicare();
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_SVA_MESTA:
                            if (sto.getUspesno() == 1) {
                                Podaci.listaMesta = (List<Mesto>) sto.getPodaci();

                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TAKMICARA:
                            if (sto.getUspesno() == 1) {
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_UPDATE_TAKMICAR:
                            if (sto.getUspesno() == 1) {
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_UNOS_MECA:
                            if (sto.getUspesno() == 1) {
                                JOptionPane.showMessageDialog(null, "Uspesno unet mec!");
                                Kontroler.getInstance().izvrsiUpdatePosleMeca(sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_DELETE_TAKMICARA:
                            if (sto.getUspesno() == 1) {
                                JOptionPane.showMessageDialog(null, sto.getPodaci());
                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_MECEVE:
                            if (sto.getUspesno() == 1) {
                                Podaci.listaMeceva = (List<Mec>) sto.getPodaci();
                                System.out.println("991119" + Podaci.listaMeceva.toString());

                            } else if (sto.getUspesno() == -1) {
                                JOptionPane.showMessageDialog(null, sto.getGreska().getMessage());
                            }
                            break;
                    }

                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setSoket(Socket soket) throws IOException {
        this.s = soket;
        out = new ObjectOutputStream(soket.getOutputStream());
        in = new ObjectInputStream(soket.getInputStream());
    }

}
