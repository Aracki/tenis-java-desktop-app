/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Takmicar;
import java.util.Comparator;

/**
 *
 * @author Raca420
 */
public class CustomComparator implements Comparator<Takmicar> {

    @Override
    public int compare(Takmicar o1, Takmicar o2) {
        return o2.getBroj_pobeda() - o1.getBroj_pobeda();
    }

}
