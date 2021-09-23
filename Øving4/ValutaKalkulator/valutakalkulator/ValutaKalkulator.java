package valutakalkulator;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// input.close()????
public class ValutaKalkulator {
    private String[] menyItems = {"Avslutt", "dollar", "euro", "Svenske kroner", };
    private List<Valuta> valutaer = new ArrayList<>();


    public static void main(String[] args) {
        boolean loop = true;
        Scanner input = new Scanner(System.in);
        do {
            ValutaKalkulator valutakalkulator = new ValutaKalkulator();
            valutakalkulator.init();
            valutakalkulator.visMeny();
            double totalsum = valutakalkulator.calculate(input);

            if (totalsum == 0) {
                loop = false;
            } else {
                System.out.println("Totalsum: " + totalsum);
                System.out.println(" ");
            }

        } while (loop);
        input.close();


    }

    //initierer valutaer
    private void init() {
        valutaer.add(new Valuta("dollar", 10f));
        valutaer.add(new Valuta("euro", 6));
        valutaer.add(new Valuta("sek", 2));
    }

    //Kalkulerer etter inntastningner
    private double calculate(Scanner input) {
        int valuta = lesTast(input);

        //input validering
        if (valuta == 0) {
            System.out.println("Avsluttet");
            return 0;
        } else if (valuta < 1 || valuta > menyItems.length - 1) {
            System.out.println("Du må velge gyldig valuta");
        }else {

            //Meny valg for konvertering fra eller til
            System.out.println(" ");
            System.out.println("1. konvertere fra NOK");
            System.out.println("2. konvertere til NOK");
            int valg = lesTast(input);
            if (valg == 1 || valg == 2) {
                System.out.println("Hvor mye vil du konvertere?");
                int antall = lesTast(input);
                if (valg == 1) {
                    return valutaer.get(valuta-1).regnFra(antall);
                } else {
                    return valutaer.get(valuta-1).regnTil(antall);
                }
            } else {
                System.out.println("Ugyldig menyvalg.");
            }
        }
        return 0;
    }

    //Skriver ut alle menyvalgene
    private void visMeny() {
        System.out.println("----ValutaKalkulator----");
        for (int i = 0; i < menyItems.length; i++) {
            System.out.println(i  + ". " + menyItems[i]);
        }
    }

    public int lesTast(Scanner input) {
        return input.nextInt();

    }
}

