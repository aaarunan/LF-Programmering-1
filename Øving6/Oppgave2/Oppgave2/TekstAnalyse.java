package Oppgave2;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.Character.toUpperCase;

public class TekstAnalyse {
    int[] antallTegn = new int[30];
    private String alfabetet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public void Analyser(String input) {
        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            int value = FinnVerdi(input.charAt(i));
            if (value >= 0) {
                this.antallTegn[value]++;
            } else {
                this.antallTegn[29]++;
            }
        }
        System.out.println(Arrays.toString(this.antallTegn));
    }

    private int FinnVerdi(char bokstav) {
        char bokstav2;
        for (int i = 0; i < alfabetet.length(); i++) {
            bokstav2 = alfabetet.charAt(i);
            if (bokstav == bokstav2) {
                return i;
            }
        }
        return -1;
    }

    public int FinnAntallForskjellligeBokstaver() {
        int antall = 0;
        for (int i = 0; i < this.antallTegn.length-1; i++) {
            if (this.antallTegn[i] > 0){
                antall++;
            }
        }
        return antall;
    }

    public int FinnAntallBokstaver() {
        int antall = 0;
        for (int i = 0; i < this.antallTegn.length-1; i++) {
            if (this.antallTegn[i] > 0){
                antall+= this.antallTegn[i];
            }
        }
        return antall;
    }

    public double ProsentBokstaver() {
        double bokstaver = this.FinnAntallBokstaver();
        return Math.round((bokstaver/((double)(bokstaver+this.antallTegn[29])))*100);

    }

    public int FinnAntall(char bokstav) {
        return this.antallTegn[FinnVerdi(bokstav)];
    }



}
