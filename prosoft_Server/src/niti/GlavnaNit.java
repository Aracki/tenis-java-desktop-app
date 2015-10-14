/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raca420
 */
public class GlavnaNit extends Thread {

    public static List<KlijentNit> listaKlijenta = new ArrayList<>();

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            while (true) {
                System.out.println("Server je pokrenut, ceka klijenta... ");
                Socket s = ss.accept();
                System.out.println("Klijent se povezao sa serverom... ");
                KlijentNit kn = new KlijentNit(s);
                kn.start();
                listaKlijenta.add(kn);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
