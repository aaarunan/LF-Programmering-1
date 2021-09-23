package Oppgave2.java;
import java.util.Random;


public class Spiller {
    int poeng;
    private Random terning = new Random();

    //Konstruerer objektet spiller med egenskap poeng
    public Spiller(int poeng) {
        this.poeng = poeng;

    }

    //Metode for å få poengsummen til spilleren
    public int getSumPoeng() {
        return this.poeng;
    }

    //Lager en metode slik at spilleren kan kaste terning
    public int kastTerning() {
        int poengSum = this.poeng;
        int n = terning.nextInt(6) + 1;

        //Logikken til spillet
        if (n == 1) {
            this.poeng = 0;
        } else if (poengSum > 100) {
            this.poeng -= n;
        } else  {
            this.poeng += n;
        }
        return this.poeng;


    }

    //Metode for å sjekke om spiller har 100 poeng
    public boolean erFerdig() {
        return this.poeng == 100;

    }

}
