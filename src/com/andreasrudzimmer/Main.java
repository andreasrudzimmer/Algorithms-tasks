package com.andreasrudzimmer;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

/*
        String[] s = {null, "a", null, "b", "c", null, null, "D", "e"};
        Liste<String> liste = new DobbeltLenketListe<>(s);
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s);
        System.out.println(l1.toString());
        System.out.println(l1.omvendtString());

*/
/*
        String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", null, "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString() + " " + l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());
*/
        DobbeltLenketListe<Integer> listen = new DobbeltLenketListe<>();
        System.out.println(listen.toString() + " " + listen.omvendtString());

        for (int i = 1; i < 7; i++){
            listen.leggInn(i);
            System.out.println(listen.toString() + " " + listen.omvendtString());
        }

        Character[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8));
        System.out.println(liste.subliste(5,5));
        System.out.println(liste.subliste(8, liste.antall()));
        System.out.println(liste.subliste(0,11));

        //Testprogram
    }



}
