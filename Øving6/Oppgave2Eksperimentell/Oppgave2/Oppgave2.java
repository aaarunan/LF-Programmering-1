package Oppgave2;
import java.util.Scanner;


public class Oppgave2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        String inntastet;
        while (loop) {
            inntastet = "";
            TekstAnalyse tekst = new TekstAnalyse();
            System.out.println("Skriv en streng:");
            inntastet =  in.next();
            tekst.Analyser(inntastet);

            System.out.println("Antall forksjellige bokstaver " + tekst.FinnAntallForskjellligeBokstaver());
            System.out.println("Antall bokstaver " + tekst.FinnAntallBokstaver());
            System.out.println("Antall prosent som er bokstaver " + tekst.ProsentBokstaver()+"%");
            System.out.println("Antall B: "+ tekst.FinnAntall('B'));
            System.out.println(" ");
            System.out.println("Trykk 1 for å fortsette");
            System.out.println("Trykk 2 for å avslutte");
            if (in.nextInt() == 2) {
                loop = false;
            }

        }
        in.close();

    }

}