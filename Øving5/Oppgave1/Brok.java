package Oppgave1.java;

import java.util.ArrayList;
import java.util.Objects;

public class Brok {
    int teller;
    int nevner;


    public Brok(int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException();
        } else {
            this.teller = teller;
            this.nevner = nevner;
        }


    }

    public Brok(int teller) {
        this.teller = teller;
        this.nevner = 1;

    }
    public int getNevner() {
        return this.nevner;
    }

    public int getTeller() {
        return this.teller;
    }
    public void addere(Brok b) {
        if (this.nevner == b.nevner) {
            this.teller += b.teller;
        } else {
            this.teller = (this.nevner * b.teller) + (b.nevner * this.teller);
            this.nevner = b.nevner * this.nevner;
        }


    }

    public void multiplere(Brok b) {
        this.teller *= b.teller;
        this.nevner *= b.nevner;
    }

    public void dividere(Brok b) {
        int nevner = b.nevner;
        b.nevner = b.teller;
        b.teller = nevner;
        this.multiplere(b);

    }

    public void subtrahere(Brok b) {
        if (this.nevner == b.nevner) {
            this.teller -= b.teller;
        } else {
            this.teller = (this.nevner * b.teller) - (b.nevner * this.teller);
            this.nevner = b.nevner * this.nevner;
        }

    }

    public String get() {
        return this.teller + "/" + this.nevner;
    }

    public void forkort() {
        if (this.teller == 0) {
            return;
        }
        ArrayList<Integer> t = faktoriser(this.teller);
        ArrayList<Integer> n = faktoriser(this.nevner);

        ArrayList<Integer> sum;
        if (t.size() > n.size()) {
            sum = slett(t, n);;
        } else {
           sum = slett(n, t);
        }

        this.teller = sum.get(1);
        this.nevner = sum.get(0);

        if (this.nevner == 0) this.nevner = 1;


    }

    private ArrayList<Integer> slett(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> sum = new ArrayList<Integer>();
        sum.add(0, 0);
        sum.add(1, 0);

        for (int i = 0; i < a.size(); i++) {

            if (b.contains(a.get(i))) {
                for (int u = 0; u < b.size(); u++) {
                    if (Objects.equals(b.get(u), a.get(i))) {
                        b.remove(u);
                        break;
                    }
                }
                a.remove(i);
                i= -1;
            }
        }
        int aSum = 1;
        int bSum = 1;
        for (Integer integer : a) {
            aSum *= integer;
        }
        for (Integer integer : b) {
            bSum *= integer;
        }
        sum.set(0, aSum);
        sum.set(1, bSum);
        return sum;

    }

    private ArrayList<Integer> faktoriser(int x) {
        //negative tall funker ikke
        ArrayList<Integer> faktorer = new ArrayList<Integer>();
        int i = 2;
        int u = 0;
        while (x > 1) {
            if (x % i == 0) {
                faktorer.add(i);
                x /= i;
                i = 1;
            }
            i++;
        }
        return faktorer;
    }


}
