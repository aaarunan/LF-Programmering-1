package Oppgave2.java;

import java.util.*;

public class Oppgave2 {
    public static void main(String[] args) {
        //Legger til alle spillere i en array
        Spiller[] Spiller = new Spiller[2];
        Spiller[0] = new Spiller(0);
        Spiller[1] = new Spiller(0);

        int i = 1;

        //Selve spilleprosessen
        while (!(Spiller[1].erFerdig() || Spiller[0].erFerdig())) {

            System.out.println("Runde: " + i);

            int A = Spiller[0].kastTerning();
            int B = Spiller[1].kastTerning();

            System.out.println("Spiller A: " + A + "  " + "Spiller B: " + B);
            System.out.println("--------------------------------");

            i++;
        }

        //Sluttfase
        if (Spiller[0].erFerdig() && Spiller[1].erFerdig()) {
            System.out.println("----Det ble uavgjort----");
        } else if (Spiller[0].erFerdig()) {
            System.out.println("!!!!!Spiller A vant!!!!!");
        } else {
            System.out.println("!!!!!Spiller B vant!!!!!");
        }
    }


}
