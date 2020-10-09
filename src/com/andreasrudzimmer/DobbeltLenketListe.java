package com.andreasrudzimmer;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {

    }

    public DobbeltLenketListe(T[] a) {

        if (a == null){
            throw new NullPointerException();
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null){
                    Node nyNode = new Node(a[i]);


                    if(hode == null) {
                        hode = hale = nyNode;
                        hode.forrige = null;
                        hale.neste = null;
                    }
                    else {
                        hale.neste = nyNode;
                        nyNode.forrige = hale;
                        hale = nyNode;
                        hale.neste = null;
                    }
                    antall++;
                }
            }
        }
    }


    private Node<T> finnNode(int indeks) {
        if(indeks>=0 && indeks<=(antall-1)) {
            Node<T> node;
            if (indeks < antall()/2) {
                node = hode;
                for (int i = 1; i <= indeks; i++) {
                    node = node.neste;
                }
            } else {
                node = hale;
                for (int i = antall()-2; i >= indeks; i--) {
                    node = node.forrige;
                }
            }
            return node;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public Liste<T> subliste(int fra, int til){
        DobbeltLenketListe<T> l = new DobbeltLenketListe<T>();
        try {
            for(int i=fra;i<til;i++) {
                l.leggInn(finnNode(i).verdi);
            }
        } catch (Exception e) {

        }
        if(fra>til) {
            throw new IllegalArgumentException();
        } else if(til>antall || fra==-1) {
            throw new IndexOutOfBoundsException();
        } else {
            return l;
        }
    }

    @Override
    public int antall() {
        if (antall == 0){
            return 0;
        }
        else{
            return antall;
        }
    }

    @Override
    public boolean tom() {
        if (antall == 0){
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi);
        Node nyNode = new Node(verdi);
        endringer++;

        try {
            if(hode==null) {
                hode = hale = nyNode;
                hode.forrige = null;
                hale.neste = null;
            } else {
                hale.neste = nyNode;
                nyNode.forrige = hale;
                hale = nyNode;
                hale.neste = null;
            }
            antall++;
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    public void leggInn(int indeks, T verdi) {
        Node set = new Node(verdi);
        if(indeks<0 || indeks>antall) {
            throw new IndexOutOfBoundsException();
        } else if(verdi.equals(null) || verdi==null) {
            throw new NullPointerException();
        } else {
            if(hode==null) {
                hode = set;
                hode.forrige = null;
                hale = set;
                hale.neste = null;
            }
            if(indeks>0 && indeks < antall) {
                Node<T> holder = finnNode(indeks-1);
                set.neste = holder.neste;
                holder.neste = set;
                set.forrige = holder;
                set.neste.forrige = set;
                hode.forrige = null;
                hale.neste = null;
            }
            if(indeks==0) {
                set.neste = hode;
                hode.forrige = set;
                hode = set;
                hode.forrige = null;
                hale.neste = null;
            }if(indeks==antall) {
                set.forrige = hale;
                hale.neste = set;
                hale = set;
                hode.forrige = null;
                hale.neste = null;
            }
            antall++;
            endringer++;
        }
    }

    @Override
    public boolean inneholder (T verdi) {
        if(indeksTil(verdi)>=0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        int r = -1;
        if(verdi != null) {
            Node<T> node = hode;
            int i = 0;
            while (node != null) {
                if(node.verdi == verdi || node.verdi.equals(verdi)) {
                    r=i;
                    break;
                }
                node = node.neste;
                i++;
            }
        }
        return r;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi);
        indeksKontroll(indeks, false);
        Node<T> node = finnNode(indeks);
        T mid = node.verdi;
        node.verdi = nyverdi;
        endringer++;
        return mid;
    }

    @Override
    public boolean fjern(T verdi) { //Får ikke denne til å fungere opptimalt, og rekker ikke det før innleveringen.
        Objects.requireNonNull(verdi);
        Node<T> node = hode;

        for (int i = 0; i < antall(); i++) {
            node = node.neste;

            if (node.verdi.equals(verdi)) {
                node.forrige.neste = node.neste;
                node.neste.forrige = node.forrige;

                endringer++;
                antall--;

                return true;
            }
        }
        return false;
    }



    @Override
    public T fjern(int indeks){ //Får ikke denne til å fungere opptimalt, og rekker ikke det før innleveringen.

            indeksKontroll(indeks, false);

            Node<T> node;
            if (indeks < antall() / 2) {
                node = hode;
                for (int i = 0; i <= indeks; i++) {
                    node = node.neste;
                }

            } else {
                node = hale;
                for (int i = antall() - 1; i >= indeks; i--) {
                    node = node.forrige;
                }
            }


        Node<T> holder = node; // Holder på den slettede verdien.

        node.forrige.neste = node.neste;
        node.neste.forrige = node.forrige;
        endringer++;
        antall--;

        return holder.verdi; // Returnerer den slettede verdien.
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!tom()) {
            Node<T> node = hode;
            while (node != null) {
                sb.append(node.verdi);
                node = node.neste;
                sb.append(", ");
            }
        }
        String ny_string = "";
        if(sb.length() > 1) {
            ny_string = sb.toString();
            ny_string = sb.substring(0, ny_string.length()-2) + "]";
        } else {
            sb.append("]");
            ny_string = sb.toString();
        }
        return ny_string;
    }

    public String omvendtString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!tom()) {
            Node<T> node = hale;
            while (node != null) {
                sb.append(node.verdi);
                node = node.forrige;
                sb.append(", ");
            }
        }
        String ny_string = "";
        if(sb.length() > 1) {
            ny_string = sb.toString();
            ny_string = sb.substring(0, ny_string.length()-2) + "]";
        } else {
            sb.append("]");
            ny_string = sb.toString();
        }
        return ny_string;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


