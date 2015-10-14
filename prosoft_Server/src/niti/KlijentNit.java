/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.KontrolerServer;
import domen.Takmicenje;
import domen.TipTakmicenja;
import domen.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import so.AbstractSO;
import so.takmicenje.SO_InsertTakmicenje;
import so.takmicenje.SO_VratiListuTakmicenja;
import so.tiptakmicenja.SO_InsertTipTakmicenja;
import so.tiptakmicenja.SO_VratiListuTipovaTakmicenja;
import transfer.KlijentTransferObjekat;
import transfer.ServerTransferObjekat;

/**
 *
 * @author Raca420
 */
public class KlijentNit extends Thread {

    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;

    public KlijentNit(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(s.getInputStream());
            out = new ObjectOutputStream(s.getOutputStream());

            while (true) {
                try {
                    KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();
                    ServerTransferObjekat sto = new ServerTransferObjekat();
                    sto.setOperacija(kto.getOperacija());
                    switch (kto.getOperacija()) {
                        case Konstante.OPERACIJA_LOGOVANJE:
                            out.writeObject(KontrolerServer.OPERACIJA_LOGOVANJE(kto, sto));
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TIPTAKMICENJA:
                            out.writeObject(KontrolerServer.OPERACIJA_KREIRAJ_TIPTAKMICENJA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_SVE_TIPOVE_TAKMICENJA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TAKMICENJE:
                            out.writeObject(KontrolerServer.OPERACIJA_KREIRAJ_TAKMICENJE(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_SVA_TAKMICENJA:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_SVA_TAKMICENJA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_UPDATE_TAKMICENJE:
                            out.writeObject(KontrolerServer.OPERACIJA_UPDATE_TAKMICENJE(kto, sto));
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_LIGU:
                            out.writeObject(KontrolerServer.OPERACIJA_KREIRAJ_LIGU(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_LIGE:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_LIGE(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_TAKMICARE:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_SVE_TAKMICARE(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_SVA_MESTA:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_SVA_MESTA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_KREIRAJ_TAKMICARA:
                            out.writeObject(KontrolerServer.OPERACIJA_KREIRAJ_TAKMICARA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_UPDATE_TAKMICAR:
                            out.writeObject(KontrolerServer.OPERACIJA_UPDATE_TAKMICAR(kto, sto));
                            break;
                        case Konstante.OPERACIJA_UNOS_MECA:
                            out.writeObject(KontrolerServer.OPERACIJA_UNOS_MECA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_DELETE_TAKMICARA:
                            out.writeObject(KontrolerServer.OPERACIJA_DELETE_TAKMICARA(kto, sto));
                            break;
                        case Konstante.OPERACIJA_VRATI_SVE_MECEVE:
                            out.writeObject(KontrolerServer.OPERACIJA_VRATI_MECEVE(kto,sto));
                            break;
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

}
