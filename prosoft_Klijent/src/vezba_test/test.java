/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezba_test;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Raca420
 */
public class test {

//   static DSLista pom = new DSLista();
//    public static Cvor reverseListR(Cvor prvi) {
//        if (prvi.sledeci != null) {
//            reverseListR(prvi.sledeci);
//            prvi.sledeci = prvi.prethodni;
//        }
//
//    }
    public static String reverseString(String x) {
        if (x.isEmpty()) {
            return null;
        }

        String s = "";
        for (int i = x.length() - 1; i >= 0; i--) {
            s = s.concat(String.valueOf(x.charAt(i)));
        }

        return s;
    }

    public static String reverseStringRekurzivno(String s) {

        if (s.length() == 0) {
            return s;
        }

        return reverseStringRekurzivno(s.substring(1)) + s.charAt(0);

    }

    public static Object vratiSrednji(LinkedList l) {

        Object o1;
        Object o2;

        for (int i = 0; i < l.size(); i++) {
            o1 = l.get(i);
            try {
                o2 = l.get(i * 2 + 1);
            } catch (Exception e) {
                return o1;
            }
        }
        return null;

    }

    public static Cvor vratiSrednjiDS(DSLista dsl) {
        if (dsl.prvi == null) {
            return null;
        }

        Cvor pom1;

        for (int i = 0; i < dsl.vratiSize(); i++) {
            pom1 = dsl.get(i);
            if (dsl.get(i * 2 + 1) == null) {
                return pom1;
            }
        }
        return null;
    }

    public static int vratiTreciOdPozadi(Cvor pom1, Cvor pom2) {
        if (pom1 == null || pom2 == null || pom1.sledeci.sledeci == null) {
            return -1;
        }

        if (pom2.sledeci != null && pom2.sledeci.sledeci == null) {
            return pom1.sledeci.element;
        }

        if (pom2.sledeci != null) {
            return vratiTreciOdPozadi(pom1.sledeci.sledeci, pom2.sledeci.sledeci);

        } else {
            return pom1.element;
        }
    }

    public static int nadjiDuplikat(int[] niz) {
        int brojac = 0;
        for (int i = 0; i < niz.length; i++) {
            for (int j = i + 1; j < niz.length; j++) {
                if (niz[i] == niz[j]) {
                    brojac++;
                    if (brojac > 1) {
                        return niz[i];
                    }
                }
            }
        }
        return -1;
    }

    public static int printFib(int max) {

        int[] niz = new int[max];
        niz[0] = 1;
        niz[1] = 1;

        for (int i = 2; i < niz.length; i++) {
            niz[i] = niz[i - 1] + niz[i - 2];
        }

        for (int i : niz) {
            System.out.println(i);
        }
        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(reverseStringRekurzivno("ivan aracki"));
//        LinkedList<String> l = new LinkedList<>();
//        String[] nizStr = {"1", "2", "3", "4", "5", "6"};
//        l.addAll(Arrays.asList(nizStr));
//        System.out.println(vratiSrednji(l));
        Cvor c1 = new Cvor();
        c1.element = 1;
        Cvor c2 = new Cvor();
        c2.element = 2;
        Cvor c3 = new Cvor();
        c3.element = 3;
        Cvor c4 = new Cvor();
        c4.element = 4;
        Cvor c5 = new Cvor();
        c5.element = 5;
        Cvor c6 = new Cvor();
        c6.element = 6;
        Cvor c7 = new Cvor();
        c7.element = 7;

        DSLista l = new DSLista();
        l.ubaciUListuNaKraj(c1);
        l.ubaciUListuNaKraj(c2);
        l.ubaciUListuNaKraj(c3);
        l.ubaciUListuNaKraj(c4);
        l.ubaciUListuNaKraj(c5);
        l.ubaciUListuNaKraj(c6);
//        l.ubaciUListuNaKraj(c7);

        int[] niz = {-2, 1, 3, 4, 3, 2};
        test t = new test();
        System.out.println(Cvor.solution22(niz));

    }

    public static int fact(int x) {
        if (x == 0) {
            return 1;
        }
        return x * fact(x - 1);
    }

}

class DSLista {

    Cvor prvi;

    public void ubaciUListuNaKraj(Cvor novi) {
        if (prvi == null) {
            prvi = novi;
            prvi.index = 0;
        } else {
            Cvor pom = prvi;
            int br = 1;
            while (pom != null) {
                if (pom.sledeci == null) {
                    pom.sledeci = novi;
                    novi.prethodni = pom;
                    novi.index = br;
                    br++;
                    return;
                }
                pom = pom.sledeci;
            }
        }
    }

    public int vratiSize() {
        Cvor pom = prvi;
        if (pom == null) {
            return 0;
        }
        int brojac = 0;
        while (pom != null) {
            brojac++;
            pom = pom.sledeci;
        }
        return brojac;
    }

    public Cvor get(int i) {
        Cvor pom = prvi;
        if (pom == null) {
            return null;
        }

        while (pom != null) {
            if (pom.element == i) {
                return pom;
            }
            pom = pom.sledeci;
        }
        return null;
    }

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i <= vratiSize(); i++) {
            if (get(i) != null) {
                x = x.concat(String.valueOf(get(i).element));
            }
        }
        return x;
    }

}

class Cvor {

    int index;
    int element;
    Cvor sledeci;
    Cvor prethodni;

    @Override
    public String toString() {
        return String.valueOf(element);
    }

    static int left;
    static int right;
    static int n;
    static int largest;
    static int[] a;
    static int minPozitivan;

    private static void buildheap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    private static void maxheap(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    private static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sort(int[] a0) {
        a = a0;
        buildheap(a);
        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
    }

    int[] niz = {-2, 1, 3, 4, 3, 2};

    public static int solution2(int[] A) {
        sort(A);
        boolean kec = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > 0) {
                if (A[i] == 1) {
                    kec = true;
                }
                if (A[i] > 1 && !kec) {
                    return 1;
                } else {
                    if (A[i] > 0 && A[i + 1] != A[i] + 1 && A[i + 1] != A[i]) {
                        return A[i] + 1;
                    }
                }
            }
        }
        return A[A.length - 1] + 1;
    }

    public int solution(int[] A) {
        int pocetak = 0;
        int srednjaVrednost = Integer.MAX_VALUE;
        int x = 0;
        int brojac = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {
                x += A[j];
                brojac++;
                if (brojac > 1 && x / (j - i + 1) < srednjaVrednost) {
                    pocetak = i;
                    srednjaVrednost = x;
                }
            }
            brojac = 0;
            x = 0;
        }
        return pocetak;
    }

//        int[] niz = {-2, 1, 3, 4, 3, 2};
//    public static int solution22(int[] A) {
//        int pocetak = 0;
//        double srednjaVrednost = Integer.MAX_VALUE;
//        double x = 0;
//        int brojac = 0;
//        for (int i = 0; i < A.length - 1; i++) {
//            for (int j = i; j < A.length; j++) {
//                x += A[j];
//                brojac++;
//                if (brojac > 1 && x / (j - i + 1) < srednjaVrednost) {
//                    pocetak = i;
//                    srednjaVrednost = x / (j - i + 1);
//                }
//            }
//            brojac = 0;
//            x = 0;
//        }
//        return pocetak;
//    }
    
    public static int solution22(int[] A) {
        int pocetak = 0;
        double srednjaVrednost = Integer.MAX_VALUE;
        double x = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {
                x += A[j];
                if (j-i>0 && x / (j - i + 1) < srednjaVrednost) {
                    pocetak = i;
                    srednjaVrednost = x/(j - i + 1);
                }
            }
            x = 0;
        }
        return pocetak;
    }

}
