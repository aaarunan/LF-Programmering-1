import static java.util.Calendar.YEAR;

import java.util.*;

public class Oppgave1 {
    public static Person person;
    public static Arbeidstaker arbeidstaker;
    public static GregorianCalendar kalender = new GregorianCalendar();
    public static boolean loop = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        personMeny(in);
        arbeidstakerMeny(in);
        while (loop) {
            getData();
            hovedMeny(in);

        }
        in.close();

    }

    private static void personMeny(Scanner in) {
        System.out.println("Fornavn:");
        String fNavn = in.nextLine();
        System.out.println("Etternavn:");
        String eNavn = in.nextLine();
        System.out.println("Fødselsår:");
        int fodselsar = in.nextInt();
        person = new Person(fNavn, eNavn, fodselsar);
    }

    private static void arbeidstakerMeny(Scanner in) {
        System.out.println("Arbeidstaker nummer:");
        int arbNummer = in.nextInt();
        System.out.println("Manedslønn:");
        int manedslonn = in.nextInt();
        System.out.println("Skatteprosent:");
        float skatteprosent = in.nextFloat();
        System.out.println("Ansettelsesår:");
        int ansettelsesar = in.nextInt();

        arbeidstaker = new Arbeidstaker(person, arbNummer, ansettelsesar, manedslonn, skatteprosent);


    }

    private static void hovedMeny(Scanner in) {
        System.out.println("");
        System.out.println("1. Endre månedslønn");
        System.out.println("2. Endre skatteprosent");
        System.out.println("3. Avslutt");

        switch (in.nextInt()) {
            case 1 -> {
                System.out.println("Månedslønn:");
                arbeidstaker.setManedslonn(in.nextInt());
            }

            case 2 -> {
                System.out.println("Skatteprosent:");
                arbeidstaker.setSkatteprosent(in.nextFloat());
            }
            case 3 -> {
                System.out.println("Avslutter");
                loop = false;
            }
            default -> {
                System.out.println("Ikke gyldig menyvalg.");
            }
        }


    }

    public static void getData() {
        System.out.println(arbeidstaker.toString());
        System.out.println("Skatteprosent: " + arbeidstaker.getSkatteprosent()*100 + "%.");
        System.out.println("Skattetrekk per måned: " + arbeidstaker.getSkattetrekkPerManed());
        System.out.println("Brutto lønn per år: " + arbeidstaker.getBruttoLonnPerAr());
        System.out.println("Skattetrekk per år: " + arbeidstaker.getSkatteTrekkPerAr());
        System.out.println("Alder: " + arbeidstaker.getAlder());
        System.out.println("Antall år i bedriften " + arbeidstaker.getAntallArIBedriften());
        int ar = 3;
        System.out.println("År:" + ar + " " + arbeidstaker.ansattHvisAntallAr(ar));

    }
}





